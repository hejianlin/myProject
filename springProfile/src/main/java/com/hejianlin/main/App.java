package com.hejianlin.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hejianlin.main.config.ProfileConfig;
import com.hejianlin.main.service.DemoBean;

public class App {
	private static AnnotationConfigApplicationContext context = null;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext();
	    context.getEnvironment().setActiveProfiles("prod");//选择生产环境配置
	    context.register(ProfileConfig.class);//注册Bean配置类
	    context.refresh();//刷新容器
	    DemoBean demoBean=context.getBean(DemoBean.class);
	    System.out.println(demoBean.getContent());
	    context.close();
	}
}
