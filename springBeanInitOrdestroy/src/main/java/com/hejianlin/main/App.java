package com.hejianlin.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hejianlin.main.config.PerPostConfig;
import com.hejianlin.main.service.BeanWayService;
import com.hejianlin.main.service.JSR250WayService;

public class App {
	private static AnnotationConfigApplicationContext context = null;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(PerPostConfig.class);
		BeanWayService beanWayService=context.getBean(BeanWayService.class);
		JSR250WayService jSR250WayService=context.getBean(JSR250WayService.class);
		context.close();
	}
}
