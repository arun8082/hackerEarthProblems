package com.spring.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.spring.batch.dao.bean.CustomerBean;
import com.spring.batch.dao.repo.CustomerRepo;

@Configuration
public class ReaderWriterConfig {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomerRepo customerRepo;

	@Bean
	@StepScope
	public FlatFileItemReader<CustomerBean> getItemReader(@Value("#{jobParameters[csvFileName]}") String csvFileName) {
		logger.info("====>csvFileName::" + csvFileName);
		FlatFileItemReader<CustomerBean> reader = new FlatFileItemReader<>();
		reader.setName("reader");
		reader.setStrict(true);
		reader.setResource(new FileSystemResource(csvFileName));
		reader.setLinesToSkip(1);
		
		reader.setLineMapper(getLineMapper());
		return reader;
	}

//	@Bean
	public CustomerItemProcessor getProcessor() {
		return new CustomerItemProcessor();
	}

	@Bean
	public RepositoryItemWriter<CustomerBean> getWriter() {
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
