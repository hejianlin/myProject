package com.hejianlin;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitalizer implements WebApplicationInitializer {// WebApplicationInitializer接口是用来实现
	// servlet3.0+配置的接口，从而实现了代替web.xml的位置，实现此接口将自动被SpringServletContainerInitializer（用来启动servlet3.0a容器）获取到

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();// 注解配置web应用上下文对象
		ctx.register(MyMvcConfig.class);
		ctx.setServletContext(servletContext);// 注册配置类 ，将其和当前servletContext关联
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));//注册SpringMvc的DispatcherServlet
		//Spring主要通过DispatcherServlet实现了Servlet。DispatcherServlet最上层也是继承的是HttpServlet这个类。
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
