package com.hejianlin.main.service;

//java配置方式
public class BeanWayService {
	public void init() {
		System.out.println("@Bean-init-method");
	}

	public void destroy() {
		System.out.println("@Bean-destroy-method");
	}
  
	public BeanWayService(){
		super();
		System.out.println("初始化构造函数-BeanWayService");
	}
}
