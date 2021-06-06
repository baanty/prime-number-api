package com.pijush.prime.integrationtest.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PrimeApplicationIntegrationTestConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public ExecutorService buildExecutor() {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		return executor;
	}
}
