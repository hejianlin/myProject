package com.hejianlin.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hejianlin.main.config.AwareConfig;
import com.hejianlin.main.service.AwareService;

public class App {
	private static AnnotationConfigApplicationContext context = null;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(AwareConfig.class);
		AwareService awareService = context.getBean(AwareService.class);
		awareService.outputResult();
		context.close();
	}
}
