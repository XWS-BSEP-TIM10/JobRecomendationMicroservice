package com.jobs.JobRecommendations.service;

import com.jobs.JobRecommendations.model.Event;

import java.util.List;

public interface EventService {
    Event save(Event event);
    List<Event> findAll();
}
