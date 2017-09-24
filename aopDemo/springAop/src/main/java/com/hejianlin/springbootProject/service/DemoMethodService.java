package com.hejianlin.springbootProject.service;

import org.springframework.stereotype.Service;
//使用方法的规则的被拦截类
@Service
public class DemoMethodService {
	public void add() {
		System.out.println("这里是使用方法规则拦截的");
	}
}
