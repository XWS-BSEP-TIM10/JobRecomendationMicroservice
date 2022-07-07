package com.jobs.JobRecommendations.repository;

import com.jobs.JobRecommendations.model.User;
import org.neo4j.springframework.data.repository.Neo4jRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, String> {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(String id);
}
