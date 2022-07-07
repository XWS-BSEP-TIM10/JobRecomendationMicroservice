package com.jobs.JobRecommendations.grpc;

import com.jobs.JobRecommendations.model.Interest;
import com.jobs.JobRecommendations.model.User;
import com.jobs.JobRecommendations.service.InterestService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import proto.JobRecommendationGrpcServiceGrpc;
import proto.NewInterestProto;
import proto.RemoveInterestResponseProto;

@GrpcService
public class JobRecommendationGrpcService extends JobRecommendationGrpcServiceGrpc.JobRecommendationGrpcServiceImplBase{

    private final InterestService interestService;

    @Autowired
    public JobRecommendationGrpcService(InterestService interestService) {
        this.interestService = interestService;
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


}
