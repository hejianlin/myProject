package com.hejianlin.testSpringMvcWithNoWebXml;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/anno")//默认此类的访问路径
public class HelloController {
	
	//@ResponseBod：将返回值放在response体内，而不是直接返回页面
	@RequestMapping(produces="text/plain;charset=UTF-8")//未标明路径，默认使用类定义的路径,produces可定制返回response的媒体类型
	//和字符集,这里的意思是将文件设置为纯文本的形式，浏览器在获取到这种文件时并不会对其进行处理，text/html的意思是将文件的content-type设置为text/html的形式，浏览器在获取到这种文件时会自动调用html的解析器对文件进行相应的处理。
	public @ResponseBody String anno(HttpServletRequest request){
		return "url:"+request.getRequestURI()+"can access";
	}
	
	@RequestMapping(value="/pathvar/{str}",produces="text/plain;charset=UTF-8")//演示路径变量
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request){
		return "url:"+request.getRequestURI()+"can access,str:"+str;
	}
	
	@RequestMapping(value="/requestParam",produces="text/plain;charset=UTF-8")//演示常规的request参数获取
	public @ResponseBody String demoRequestParamor(Long id, HttpServletRequest request){
		return "url:"+request.getRequestURI()+"can access,id:"+id;
	}
	
	@RequestMapping(value="/obj",produces="application/json;charset=UTF-8")//演示传递对象参数
	@ResponseBody
	public String passObj(DemoObj obj,HttpServletRequest request){
		return "url:"+request.getRequestURI()+" can access,obj id:"+obj.getId()+"obj name:"+obj.getName();
	}
	
	//演示映射不同的的路劲到相同的方法上
	@RequestMapping(value={"/name1","/name2"},produces="text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {
		return "url:"+request.getRequestURI()+" can access";
	}

	//直接返回对应的页面,默认是get方法，调用html视图解析器，使用get方法，如果不返回html页面，直接返回相应字符串，
	//一定要使用 @ResponseBody注解
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String login() {
		return "index";
	}
	

}
