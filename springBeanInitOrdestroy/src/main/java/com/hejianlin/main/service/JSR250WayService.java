package com.hejianlin.main.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {
	@PostConstruct//在构造函数执行完之后执行
	public void init(){
		System.out.println("jsr250-init-method");
	}
	
	@PreDestroy //在bean销毁之前执行
	public void destroy(){
		System.out.println("jsr250-destroy-method");
	}
	
	public JSR250WayService(){
		super();
		System.out.println("初始化构造函数-JSR250WayService");
	}
}
