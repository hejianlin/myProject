package com.hejianlin.testSpringMvcWithNoWebXml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
//用来演示ExceptionHandlerAdvice类中的全局配置
public class AdviceController {
    @RequestMapping("/advice")
	public String getSomString(@ModelAttribute("msg")String msg,DemoObj obj){
		//进入这里之前，在ExceptionHandlerAdvice已经设置了id为null
		throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+msg);
	}
}
