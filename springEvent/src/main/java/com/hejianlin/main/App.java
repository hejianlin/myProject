package com.hejianlin.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hejianlin.main.config.EventConfig;
import com.hejianlin.main.service.DemoPublisher;

public class App {
	private static AnnotationConfigApplicationContext context = null;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(EventConfig.class);
	    DemoPublisher demoPublisher=context.getBean(DemoPublisher.class);
	    demoPublisher.publish("hello world!");
	    context.close();
	}
}
