package com.hejianlin.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//任务执行类
//假设深圳北站，深圳西站，深圳南站各有20张票，他们互补影响售卖，这时可以用异步任务来表示售票过程
@Service
public class AsyncTaskService {

	@Async // 表明该方法是一个异步方法
	public void saleByShenzhenxi(int num) {
		System.out.println("深圳西站卖出第"+num+"张票");
	}

	@Async // 表明该方法是一个异步方法
	public void saleByShenzhenbei(int num) {
		System.out.println("深圳北站卖出第"+num+"张票");
	}
	
	@Async // 表明该方法是一个异步方法
	public void saleByShenzhennan(int num) {
		System.out.println("深圳南站卖出第"+num+"张票");
	}
}
