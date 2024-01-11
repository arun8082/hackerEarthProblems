package com.spring.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.batch.service.CustomerService;

@RestController
public class DataController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/importCsv")
	public Boolean importCsv() throws Exception {
		customerService.importCsvToDb();
		return true;
	}
	

}
