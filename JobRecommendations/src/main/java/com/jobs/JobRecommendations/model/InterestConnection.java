package com.jobs.JobRecommendations.model;

import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Property;
import org.neo4j.springframework.data.core.schema.RelationshipProperties;
import org.springframework.data.annotation.Id;

@RelationshipProperties
public class InterestConnection {

    @Id
    @GeneratedValue
    private Long id;

    public InterestConnection() {
    }

    public InterestConnection(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
