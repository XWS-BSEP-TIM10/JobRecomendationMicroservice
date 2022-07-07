package com.jobs.JobRecommendations.repository;

import com.jobs.JobRecommendations.model.Interest;
import com.jobs.JobRecommendations.model.JobAd;
import org.neo4j.springframework.data.repository.Neo4jRepository;
import org.neo4j.springframework.data.repository.query.Query;

import java.util.List;

public interface JobAdRepository extends Neo4jRepository<JobAd, String> {

    JobAd save(JobAd jobAd);

    @Query("MATCH (ja:JobAd)-[r:INTERESTED]-(i:Interest{description: $0}) RETURN ja")
    List<JobAd> findJobAdsForInterest(String interestDescription);

    @Query("MATCH (ja:JobAd{id: $0})-[r:INTERESTED]-(i:Interest) RETURN i")
    List<Interest> findJobInterests(String jobId);
}
