package com.hejianlin.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hejianlin.main.service.BeanWayService;
import com.hejianlin.main.service.JSR250WayService;

@Configuration
@ComponentScan("com.hejianlin.main.service")
public class PerPostConfig {
    @Bean(initMethod="init",destroyMethod="destroy")//指定构造之后，销毁之前执行的方法
	public BeanWayService beanWayService(){
		return new BeanWayService();
	}
    
    @Bean
    public JSR250WayService jsr250WayService(){
    	return new JSR250WayService();
    }
}
