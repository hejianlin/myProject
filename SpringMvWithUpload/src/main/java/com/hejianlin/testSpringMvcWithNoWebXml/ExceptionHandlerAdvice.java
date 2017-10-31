package com.hejianlin.testSpringMvcWithNoWebXml;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice//用于将全局配置放置在同一个地方
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(value=Exception.class)//该注解用于全局处理控制器里的异常，设置拦截条件为所有的Exception
	public ModelAndView exception(Exception exception,WebRequest request){
		//error页面
		ModelAndView modelAndView=new ModelAndView("error");
		//为error页面设置对象errorMessage，该对象存有详细异常信息
		modelAndView.addObject("errorMessage",exception.getMessage());
		return modelAndView;
	}
	
	@ModelAttribute//用来绑定键值对到Model里，在这里是让所有的RequestMapping都能获得到在此处的设置的键值对。
	public void addAttributes(Model model){
		//将这个键值对添加到全局
		model.addAttribute("msg", "额外信息");
	}

	@InitBinder//用来设置WebDataBinder,WebDataBinder用来自动绑定前台请求参数到Model中
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFields("id");//设置忽略request参数的id,如果前台有传id,这时候id也会被置为null
	}
}
