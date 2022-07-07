package com.jobs.JobRecommendations.service.impl;

import com.jobs.JobRecommendations.model.Interest;
import com.jobs.JobRecommendations.model.JobAd;
import com.jobs.JobRecommendations.model.User;
import com.jobs.JobRecommendations.repository.JobAdRepository;
import com.jobs.JobRecommendations.service.InterestService;
import com.jobs.JobRecommendations.service.JobAdService;
import com.jobs.JobRecommendations.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobAdServiceImpl implements JobAdService {

    private final InterestService interestService;
    private final JobAdRepository jobAdRepository;
    private final UserService userService;

    public JobAdServiceImpl(InterestService interestService, JobAdRepository jobAdRepository, UserService userService) {
        this.interestService = interestService;
        this.jobAdRepository = jobAdRepository;
        this.userService = userService;
    }

    @Override
    public JobAd add(JobAd jobAd, List<String> interests) {
        List<Interest> jobInterests = findInterests(interests);
        jobAd.setInterests(jobInterests);
        return jobAdRepository.save(jobAd);
    }

    @Override
    public List<JobAd> findJobAdRecommendations(String userId) {
        User user = userService.findById(userId);
        List<JobAd> jobAdRecommendations = new ArrayList<JobAd>();

        for(Interest interest : user.getInterests()){
            for(JobAd jobAd : jobAdRepository.findJobAdsForInterest(interest.getDescription())){
                if(!jobAd.getUserId().equals(userId)){
                    jobAdRecommendations.add(jobAd);
                }
            }
        }
        return jobAdRecommendations;
    }

    @Override
    public List<Interest> getJobInterests(String jobId) {
        return jobAdRepository.findJobInterests(jobId);
    }

    private List<Interest> findInterests(List<String> interests){

        List<Interest> newInterests = new ArrayList<>();

        for(String interest: interests){
            Interest oldInterest = interestService.findByDescription(interest);
            if(oldInterest != null){
                newInterests.add(oldInterest);
            }else{
                Interest newInterest = new Interest(interest);
                interestService.save(newInterest);
                newInterests.add(newInterest);
            }
        }

        return newInterests;

    }

}
