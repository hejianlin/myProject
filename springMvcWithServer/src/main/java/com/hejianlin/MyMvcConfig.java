package com.hejianlin;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.hejianlin")
public class MyMvcConfig {
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views");//这是运行时的目录
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);//项目中使用JSTL，SpringMVC会把视图由InternalView转换为JstlView
		return viewResolver;

	}
}
