package com.jobs.JobRecommendations.service.impl;

import com.jobs.JobRecommendations.service.LoggerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerServiceImpl implements LoggerService {

    private final Logger logger;

    public LoggerServiceImpl(Class<?> parentClass) {this.logger = LogManager.getLogger(parentClass); }

    @Override
    public void interestSuccessfullyAdded(Long interestId) {
        logger.info("Interest successfully added. Interest id: {0}", interestId);
    }

    @Override
    public void unsuccessfulInterestAdding() {
        logger.warn("Unsuccessful adding interest.");
    }

    @Override
    public void jobSuccessfullyAdded(String jobId) {
        logger.info("Job successfully added. Job id: {0}", jobId);
    }

    @Override
    public void unsuccessfulJobAdding() {
        logger.warn("Unsuccessful adding job.");
    }

    @Override
    public void recommendationsSuccessfullyFounded() {
        logger.info("Job recommendations successfully founded.");
    }
}
