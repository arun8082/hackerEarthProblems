package com.arun.ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringAIDemoApplication {

    private static Logger logger = LoggerFactory.getLogger(SpringAIDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringAIDemoApplication.class, args);
        logger.info("SpringAIDemoApplication started successfully........");
    }
}
