package com.hejianlin.testSpringMvcWithNoWebXml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//拦截器配置
public class DemoInterceptor extends HandlerInterceptorAdapter {//通过继承这个类来实现自定义过滤器

	@Override//重写poshHandle方法，在请求发生后执行
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//得到请求开始时间
		long startTime=(Long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime=System.currentTimeMillis();
		System.out.println("本次请求处理时间为："+new Long(endTime-startTime)+"ms");
		request.setAttribute("handlingTime", endTime-startTime);
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override//重写preHandle方法，在请求发生前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime=System.currentTimeMillis();
		//设置请求开始时间
		request.setAttribute("startTime",startTime);
		return true;
	}

}
