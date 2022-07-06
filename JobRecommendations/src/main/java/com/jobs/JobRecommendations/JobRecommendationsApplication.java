package com.jobs.JobRecommendations;

import com.jobs.JobRecommendations.model.JobAd;
import com.jobs.JobRecommendations.repository.JobAdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobRecommendationsApplication implements CommandLineRunner {

	@Autowired
	private JobAdRepository jobAdRepository;

	public static void main(String[] args) {
		SpringApplication.run(JobRecommendationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JobAd jobad = new JobAd();
		jobad.setId("kina");
		jobAdRepository.save(jobad);

	}
}
