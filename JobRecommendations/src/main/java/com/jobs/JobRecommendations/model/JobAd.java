package com.jobs.JobRecommendations.model;

import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;

import java.util.Date;

@Node("JobAd")
public class JobAd {

    @Id
    private String id;

    private String title;

    private String position;

    private String description;

    private Date creationDate;

    private String company;

    public JobAd() {
    }

    public JobAd(String id, String title, String position, String description, Date creationDate, String company) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.description = description;
        this.creationDate = creationDate;
        this.company = company;
    }

    public String getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getCompany() {
        return company;
    }

    public void setId(String id) {
        this.id = id;
    }
}
