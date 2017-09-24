package com.hejianlin.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hejianlin.main.config.ScopeConfig;
import com.hejianlin.main.service.PrototypeService;
import com.hejianlin.main.service.SingletonService;

public class App {
	private static AnnotationConfigApplicationContext context = null;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(ScopeConfig.class);
		SingletonService singletonService1=context.getBean(SingletonService.class);
		SingletonService singletonService2=context.getBean(SingletonService.class);
		PrototypeService prototypeService1=context.getBean(PrototypeService.class);
		PrototypeService prototypeService2=context.getBean(PrototypeService.class);
		System.out.println("SingletonService1与SingletonService2是否相等："+singletonService1.equals(singletonService2));
		System.out.println("prototypeService1与prototypeService2是否相等："+prototypeService1.equals(prototypeService2));
	        context.close();
	}
}
