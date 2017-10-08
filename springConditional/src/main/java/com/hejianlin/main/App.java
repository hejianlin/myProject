package com.hejianlin.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hejianlin.main.config.ConditionConfig;
import com.hejianlin.main.service.ListServiceCmd;

public class App {
	private static AnnotationConfigApplicationContext context = null;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(ConditionConfig.class);
		ListServiceCmd listServiceCmd=context.getBean(ListServiceCmd.class);
		System.out.println(context.getEnvironment().getProperty("os.name")+"系统下的列表命令为："+listServiceCmd.showListCmd());
	}
}
