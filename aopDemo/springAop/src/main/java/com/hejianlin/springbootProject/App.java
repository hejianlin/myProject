package com.hejianlin.springbootProject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hejianlin.springbootProject.service.DemoAnnotationService;
import com.hejianlin.springbootProject.service.DemoMethodService;

/**
 * Hello world!
 *
 */
public class App {
	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(AopConfig.class);
		DemoAnnotationService demoAnnotationService=context.getBean(DemoAnnotationService.class);
		DemoMethodService demoMethodService=context.getBean(DemoMethodService.class);
		demoMethodService.add();
		demoAnnotationService.add();
		
		context.close();
	}
}
