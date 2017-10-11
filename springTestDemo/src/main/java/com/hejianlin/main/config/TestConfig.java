package com.hejianlin.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hejianlin.main.service.TestBean;

@Configuration
public class TestConfig {
@Bean
@Profile("dev")
public TestBean devTestBean(){
	return new TestBean("from dev profile");
}
@Bean
@Profile("prod")
public TestBean prodTestBean(){
	return new TestBean("from prod profile");
}
}
