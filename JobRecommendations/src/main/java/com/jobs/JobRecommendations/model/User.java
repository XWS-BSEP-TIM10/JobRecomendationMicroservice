package com.jobs.JobRecommendations.model;

import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Relationship;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
@Node("User")
public class User {
    @Id
    private String id;

    @Relationship(type = "INTERESTED", direction = Relationship.Direction.OUTGOING)
    private List<Interest> interests;

    public User() {
        this.interests = new ArrayList<>();
    }

    public User(String id) {
        this.id = id;
        this.interests = new ArrayList<>();
    }

    public User(String id, List<Interest> interests) {
        this.id = id;
        this.interests = interests;
    }

    public String getId() {
        return id;
    }

    public List<Interest> getConnections() {
        return interests;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setConnections(List<Interest> interests) {
        this.interests = interests;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }
}
