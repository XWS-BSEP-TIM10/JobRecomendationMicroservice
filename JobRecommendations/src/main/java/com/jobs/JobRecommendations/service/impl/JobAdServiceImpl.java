package com.jobs.JobRecommendations.service.impl;

import com.jobs.JobRecommendations.model.Interest;
import com.jobs.JobRecommendations.model.JobAd;
import com.jobs.JobRecommendations.repository.JobAdRepository;
import com.jobs.JobRecommendations.service.InterestService;
import com.jobs.JobRecommendations.service.JobAdService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobAdServiceImpl implements JobAdService {

    private final InterestService interestService;
    private final JobAdRepository jobAdRepository;

    public JobAdServiceImpl(InterestService interestService, JobAdRepository jobAdRepository) {
        this.interestService = interestService;
        this.jobAdRepository = jobAdRepository;
    }

    @Override
    public JobAd add(JobAd jobAd, List<String> interests) {
        List<Interest> jobInterests = findInterests(interests);
        jobAd.setInterests(jobInterests);
        return jobAdRepository.save(jobAd);
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
