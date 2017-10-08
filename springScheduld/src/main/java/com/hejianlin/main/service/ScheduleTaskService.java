package com.hejianlin.main.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTaskService {
	// 设置时间格式
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate=5000)//设置每隔5秒执行
	public void reportCurrentTime(){
		System.out.println("每隔5秒执行一次，当前时间为："+DATE_FORMAT.format(new Date()));
	}
	
	@Scheduled(cron="0 35 20 ? * *")
	public void fixTimeExecution(){
		System.out.println("在指定时间内执行，指定的时间为："+DATE_FORMAT.format(new Date()));
	}

}
