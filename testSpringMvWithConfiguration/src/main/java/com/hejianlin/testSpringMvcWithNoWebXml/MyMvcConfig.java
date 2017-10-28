package com.hejianlin.testSpringMvcWithNoWebXml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc // 需要开启springmvc支持，若无此句，重写WebMvcConfigurerAdapter类的方法无效
@ComponentScan("com.hejianlin.testSpringMvcWithNoWebXml")
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");// 这是运行时的目录
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);// 项目中使用JSTL，SpringMVC会把视图由InternalView转换为JstlView
		return viewResolver;

	}

	// 静态资源映射，重写以下方法，然后在jsp页面引用其他静态资源就可以这样子写路径：js/xx文件
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("js/**").addResourceLocations("classpaht:/assets/");
		// addResourceHandler对外暴露的静态文件的访问路径，addResourceLocations文本放置的目录
	}

	// 配置自定义拦截器的bean
	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();

	}

	@Override//重写这个方法，添加拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());//注册自定义拦截器
	}
	
	
}
