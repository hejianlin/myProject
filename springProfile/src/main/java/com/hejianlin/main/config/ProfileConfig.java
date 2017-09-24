package com.hejianlin.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.hejianlin.main.service.DemoBean;

public class ProfileConfig {

	@Bean
	@Profile("dev")
	public DemoBean devDemoBean(){
		return new DemoBean("form development profile");
	}
	
	@Bean
	@Profile("prod")
	public DemoBean prodDemoBean(){
		return new DemoBean("form production profile");
	}
}
