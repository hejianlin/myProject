package com.hejianlin.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hejianlin.main.config.ELConfig;

public class App {
	private static AnnotationConfigApplicationContext context = null;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(ELConfig.class);
		ELConfig elConfig=context.getBean(ELConfig.class);
		elConfig.outputResource();
		context.close();
	}
}
