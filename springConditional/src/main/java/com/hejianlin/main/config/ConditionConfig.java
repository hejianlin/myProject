package com.hejianlin.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.hejianlin.main.service.LinuxCondition;
import com.hejianlin.main.service.LinuxListService;
import com.hejianlin.main.service.ListServiceCmd;
import com.hejianlin.main.service.WindowsCondition;
import com.hejianlin.main.service.WindowsListService;

@Configuration
public class ConditionConfig {
	@Bean
	@Conditional(WindowsCondition.class)//符合windows条件则实例化WindowsListService
	public ListServiceCmd windowsListService() {
		return new WindowsListService();
	}
 
	@Bean
	@Conditional(LinuxCondition.class)//符合linux条件则实例化LinuxListService
	public ListServiceCmd linuxListService(){
		return new LinuxListService();
	}
}
