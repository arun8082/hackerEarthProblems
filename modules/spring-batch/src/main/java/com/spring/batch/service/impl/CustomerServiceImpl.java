package com.spring.batch.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.batch.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@Override
	public void importCsvToDb() throws Exception {
		logger.info("Import CSV started.....................");
		JobParameters jobParameters = new JobParametersBuilder().addLocalDateTime("start-at", LocalDateTime.now())
				.toJobParameters();
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		logger.info("Import CSV ended.....................{}" + jobExecution.getId());
	}

}
