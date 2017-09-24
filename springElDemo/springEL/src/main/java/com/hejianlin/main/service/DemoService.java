package com.hejianlin.main.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class DemoService {
	@Value("其他类的属性") // 直接注入普通字符串
	private String another;

	public String getAnother() {
		return another;
	}

	public void setAnother(String another) {
		this.another = another;
	}

}
