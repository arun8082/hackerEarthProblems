package com.spring.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.spring.batch.dao.bean.CustomerBean;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig extends DefaultBatchConfiguration {

	@Autowired
	private FlatFileItemReader<CustomerBean> reader;

	@Autowired
	private RepositoryItemWriter<CustomerBean> writer;

	@Autowired
	private CustomerItemProcessor processor;

	@Bean
	Job createJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new JobBuilder("job1", jobRepository).start(csvImportStep(jobRepository, platformTransactionManager))
				.build();
	}

	@Bean
	Step csvImportStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("step1", jobRepository).<CustomerBean, CustomerBean>chunk(3, platformTransactionManager)
				.allowStartIfComplete(false).reader(reader).processor(processor).writer(writer).build();
	}

}
