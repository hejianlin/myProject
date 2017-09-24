package com.hejianlin.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//自定义发布类
@Component
public class DemoPublisher {
	@Autowired
	private ApplicationContext applicationContext;//使用applicationContext来发布事件

	public void publish(String msg) {
		System.out.println("我是发布器，我发布了消息："+msg);
		applicationContext.publishEvent(new DemoEvent(this, msg));//使用publishEvent方法来发布
	}
}
