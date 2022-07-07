package com.jobs.JobRecommendations.service;

import com.jobs.JobRecommendations.model.Interest;
import com.jobs.JobRecommendations.model.User;

public interface InterestService {

    Interest addInterest(Interest interest, User user);

}
