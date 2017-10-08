package com.hejianlin.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hejianlin.main.config.ScheduleConfig;

public class App {
	private static AnnotationConfigApplicationContext context = null;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(ScheduleConfig.class);
	}
}
