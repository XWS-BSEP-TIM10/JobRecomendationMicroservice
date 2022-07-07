package com.jobs.JobRecommendations.service;

public interface LoggerService {
    void interestSuccessfullyAdded(Long interestId);
    void unsuccessfulInterestAdding();
    void jobSuccessfullyAdded(String jobId);
    void unsuccessfulJobAdding();
    void recommendationsSuccessfullyFounded();
}
