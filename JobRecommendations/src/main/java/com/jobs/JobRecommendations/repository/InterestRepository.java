package com.jobs.JobRecommendations.repository;

import com.jobs.JobRecommendations.model.Interest;

import org.neo4j.springframework.data.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterestRepository extends Neo4jRepository<Interest, Long> {
    Interest save(Interest interest);
    List<Interest> findAll();
    Optional<Interest> findById(Long id);
    Optional<Interest> findByDescription(String description);
}
