package com.jobs.JobRecommendations.service;

import com.jobs.JobRecommendations.model.Interest;
import com.jobs.JobRecommendations.model.JobAd;

import java.util.List;

public interface JobAdService {

    JobAd add(JobAd jobAd, List<String> interests);
    List<JobAd> findJobAdRecommendations(String userId);
    List<Interest> getJobInterests(String jobId);
}
