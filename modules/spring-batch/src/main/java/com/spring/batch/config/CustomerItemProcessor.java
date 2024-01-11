package com.spring.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.batch.dao.bean.CustomerBean;

@Component
public class CustomerItemProcessor implements ItemProcessor<CustomerBean, CustomerBean> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public CustomerBean process(CustomerBean item) throws Exception {
		logger.info("item processor input:{}, output:{}", item);
		return item;
	}

}
