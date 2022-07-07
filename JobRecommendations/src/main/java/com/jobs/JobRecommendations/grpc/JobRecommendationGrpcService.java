package com.jobs.JobRecommendations.grpc;

import com.jobs.JobRecommendations.model.Interest;
import com.jobs.JobRecommendations.model.JobAd;
import com.jobs.JobRecommendations.model.User;
import com.jobs.JobRecommendations.service.InterestService;
import com.jobs.JobRecommendations.service.JobAdService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import proto.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@GrpcService
public class JobRecommendationGrpcService extends JobRecommendationGrpcServiceGrpc.JobRecommendationGrpcServiceImplBase{

    private final InterestService interestService;
    private final JobAdService jobAdService;

    @Autowired
    public JobRecommendationGrpcService(InterestService interestService, JobAdService jobAdService) {
        this.interestService = interestService;
        this.jobAdService = jobAdService;
    }

    @Override
    public void add(NewInterestProto request, StreamObserver<RemoveInterestResponseProto> responseObserver) {
        RemoveInterestResponseProto responseProto;

        Interest newInterest = new Interest(request.getDescription());
        User user = new User(request.getUserId());
        Interest addedInterest = interestService.addInterest(newInterest, user);
        if (addedInterest == null) {
            responseProto = RemoveInterestResponseProto.newBuilder().setStatus("Status 500").build();
        } else {
            responseProto = RemoveInterestResponseProto.newBuilder().setStatus("Status 200").build();
        }
        responseObserver.onNext(responseProto);
        responseObserver.onCompleted();
    }

    @Override
    public void addJob(JobAdRequestProto request, StreamObserver<RemoveInterestResponseProto> responseObserver) {
        RemoveInterestResponseProto responseProto;

        JobAd newJobAd = new JobAd(UUID.randomUUID().toString(), request.getTitle(), request.getPosition(),
                request.getDescription(), new Date(), request.getCompany(), request.getUserId());
        List<String> interests = new ArrayList<>();
        for(String interest : request.getRequirementsList()){
            interests.add(interest);
        }

        JobAd addedJob = jobAdService.add(newJobAd, interests);

        if (addedJob == null) {
            responseProto = RemoveInterestResponseProto.newBuilder().setStatus("Status 500").build();
        } else {
            responseProto = RemoveInterestResponseProto.newBuilder().setStatus("Status 200").build();
        }
        responseObserver.onNext(responseProto);
        responseObserver.onCompleted();
    }

    @Override
    public void findRecommendations(UserIdRequestProto request, StreamObserver<JobAdRecommendationsResponseProto> responseObserver) {
        JobAdRecommendationsResponseProto responseProto;

        List<JobAd> recommendations = jobAdService.findJobAdRecommendations(request.getUserId());

        List<JobAdRequestProto> requestProtos = new ArrayList<>();

        for(JobAd jobAd : recommendations){
            List<String> requirements = new ArrayList<>();
            for(Interest interest : jobAdService.getJobInterests(jobAd.getId())){
                requirements.add(interest.getDescription());
            }
            JobAdRequestProto jobAdProto = JobAdRequestProto.newBuilder().setTitle(jobAd.getTitle())
                    .setPosition(jobAd.getPosition()).setDescription(jobAd.getDescription()).setUserId(jobAd.getUserId())
                    .setCompany(jobAd.getCompany()).addAllRequirements(requirements).build();
            requestProtos.add(jobAdProto);
        }
        responseProto = JobAdRecommendationsResponseProto.newBuilder().addAllRecommendations(requestProtos).build();
        responseObserver.onNext(responseProto);
        responseObserver.onCompleted();
    }

}
