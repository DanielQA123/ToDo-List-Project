package com.qa.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public String message() {
		return "hello World";
	}

	@Bean
	public String serverStart() {
		return LocalTime.now().toString();
	}

}
