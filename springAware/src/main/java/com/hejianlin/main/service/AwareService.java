package com.hejianlin.main.service;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
	// 目的：1、打印出当前bean的名字 2、读取资源文件的内容
	private String beanName;
	private ResourceLoader loader;

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.loader = resourceLoader;
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	
	public void outputResult(){
		
		System.out.println("Bean 的名称为："+ beanName);
		Resource resource=loader.getResource("classpath:com/hejianlin/main/service/test.txt");
		try {
			System.out.println("ResourceLoader加载文件的内容为：" +IOUtils.toString(resource.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
