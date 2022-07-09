package com.jobs.JobRecommendations.repository;

import com.jobs.JobRecommendations.model.Event;
import org.neo4j.springframework.data.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends Neo4jRepository<Event, Long> {
    Event save(Event event);
    List<Event> findAll();
}
