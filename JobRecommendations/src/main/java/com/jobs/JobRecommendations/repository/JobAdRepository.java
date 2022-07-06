package com.jobs.JobRecommendations.repository;

import com.jobs.JobRecommendations.model.JobAd;
import org.neo4j.springframework.data.repository.Neo4jRepository;

public interface JobAdRepository extends Neo4jRepository<JobAd, String> {

    JobAd save(JobAd jobAd);

}
