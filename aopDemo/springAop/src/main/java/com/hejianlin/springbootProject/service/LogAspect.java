package com.hejianlin.springbootProject.service;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

//编写切面
@Aspect
@Component
public class LogAspect {
	// 声明切点
	@Pointcut("@annotation(com.hejianlin.springbootProject.service.Action)")
	public void annotationPointCut() {
	}

	@Before("execution(* com.hejianlin.springbootProject.service.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法式规则拦截的方法：" + method.getName());
	}
	
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint){
		MethodSignature signature=(MethodSignature)joinPoint.getSignature();
		Method method=signature.getMethod();
		Action action=method.getAnnotation(Action.class);
		System.out.println("注解式拦截："+"方法名："+method.getName()+" 注解："+action.name());
	}
}
