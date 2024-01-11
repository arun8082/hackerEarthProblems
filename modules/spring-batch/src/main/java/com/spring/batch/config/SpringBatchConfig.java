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
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.spring.batch.dao.bean.CustomerBean;
import com.spring.batch.dao.repo.CustomerRepo;

@Configuration
//@EnableBatchProcessing
@EnableBatchProcessing(dataSourceRef = "batchDataSource", transactionManagerRef = "batchTransactionManager")
public class SpringBatchConfig extends DefaultBatchConfiguration {

	@Autowired
	private CustomerRepo customerRepo;

	@Bean
	Job createJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new JobBuilder("job1", jobRepository).start(csvImportStep(jobRepository, platformTransactionManager))
				.build();
	}

	@Bean
	Step csvImportStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("step1", jobRepository).<CustomerBean, CustomerBean>chunk(3, platformTransactionManager)
				.allowStartIfComplete(false).reader(getItemReader()).processor(getProcessor()).writer(getWriter())
				.build();
	}

//	@Bean
	FlatFileItemReader<CustomerBean> getItemReader() {
		FlatFileItemReader<CustomerBean> reader = new FlatFileItemReader<>();
		reader.setName("reader");
		reader.setStrict(true);
		reader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
		reader.setLinesToSkip(1);
		reader.setLineMapper(getLineMapper());
		return reader;
	}

//	@Bean
	public CustomerItemProcessor getProcessor() {
		return new CustomerItemProcessor();
	}

//	@Bean
	RepositoryItemWriter<CustomerBean> getWriter() {
		RepositoryItemWriter<CustomerBean> writter = new RepositoryItemWriter<>();
		writter.setMethodName("save");
		writter.setRepository(customerRepo);
		return writter;
	}

	public LineMapper<CustomerBean> getLineMapper() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");
		lineTokenizer.setStrict(true);

		BeanWrapperFieldSetMapper<CustomerBean> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(CustomerBean.class);

		DefaultLineMapper<CustomerBean> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}

}
