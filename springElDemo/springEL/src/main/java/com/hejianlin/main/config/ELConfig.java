package com.hejianlin.main.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.hejianlin.main.service")
@PropertySource("classpath:com/hejianlin/main/service/test.properties") // 注入配置文件要指定文件地址
public class ELConfig {
	@Value("I love you") // 直接注入字符串
	private String normal;
	@Value("#{systemProperties['os.name']}") // 通过语句注入系统属性
	private String osName;
	@Value("#{T(java.lang.Math).random()*100.0}") // 注入表达式结果
	private double randomNumber;
	@Value("#{demoService.another}") // 注入其他bean的属性
	private String fromAnother;
	@Value("classpath:com/hejianlin/main/service/test.txt") // 注入文件资源
	private Resource testFile;
	@Value("http://www.baidu.com") // 注入网页资源
	private Resource testUrl;
	
	@Value("${book.name}") // 注入配置文件,得到属性的值要通过$来获得，而且还要配置PropertySourcesPlaceholderConfigurer的bean
	private String bookName;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Autowired
	private Environment environment;// 注入配置文件后，可以通过这个对象来获得配置文件中属性的值

	// 输出属性信息
	public void outputResource() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);

			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
