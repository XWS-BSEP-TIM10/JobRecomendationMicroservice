package com.jobs.JobRecommendations.service.impl;

import com.jobs.JobRecommendations.model.User;
import com.jobs.JobRecommendations.repository.UserRepository;
import com.jobs.JobRecommendations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        if(userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        return null;
    }
}
