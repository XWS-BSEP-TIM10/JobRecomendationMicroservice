package com.jobs.JobRecommendations.service;

import com.jobs.JobRecommendations.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getAll();

    User findById(String id);
}
