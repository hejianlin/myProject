package com.hejianlin.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;

	public static void main(String[] args) {
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TaskExectorConfig.class);
		AsyncTaskService asyncTaskService = annotationConfigApplicationContext.getBean(AsyncTaskService.class);
		for (int i = 0; i < 10; i++) {
			asyncTaskService.saleByShenzhenbei(i);
			asyncTaskService.saleByShenzhenxi(i);
			asyncTaskService.saleByShenzhennan(i);
		}

	}
}
