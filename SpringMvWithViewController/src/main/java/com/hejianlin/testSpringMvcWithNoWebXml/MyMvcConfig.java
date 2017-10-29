package com.hejianlin.testSpringMvcWithNoWebXml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc // 需要开启springmvc支持，若无此句，重写WebMvcConfigurerAdapter类的方法无效
@ComponentScan("com.hejianlin.testSpringMvcWithNoWebXml")
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override//重写这个方法，用于页面的转向，适用于简化只有简单的页面转向，没有任务业务处理的情况
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index2").setViewName("/index2"); 
	}

	@Override//路径参数如果带.的话，.后面的值将会被忽略，此时可以重写这个方法，设置不可忽略“.”后面的参数，比如输入参数“xx.yy”，
	//yy将不会被忽略
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);//设置为false
	}

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
