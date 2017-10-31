package com.hejianlin.testSpringMvcWithNoWebXml;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // 包含@Controller和@ResponseBody注解，即默认是返回数据的
@RequestMapping("/rest")
public class RestControllerDemo {

	@RequestMapping(value = "/getJson", produces = "application/json;charset=UTF-8") 
	public DemoObj getJson(DemoObj obj) {
	return new DemoObj(obj.getId(),obj.getName());// 对象直接转化为json
	}
	
	@RequestMapping(value = "/getXml", produces = "application/xml;charset=UTF-8") 
	public DemoObj getXml(DemoObj obj) {
	return new DemoObj(obj.getId(),obj.getName());// 对象直接转化为xml
	}
}
