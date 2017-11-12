package com.hejianlin.testUpload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SeeRequestContentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("本次请求正文的长度为："+req.getHeader("Content-Length"));
		System.out.println("本次请求类型及表单域分隔符："+req.getContentType());
		 //servlet输入流
		ServletInputStream sis=req.getInputStream();
		//servlet输出流
		ServletOutputStream sos=resp.getOutputStream();
		
		byte[]b=new byte[2048];
		
		int count=0;
		
		while((count=sis.read(b))!=-1){
			sos.write(b, 0, count);
		}
		
		sos.flush();
		sos.close();
	}

}
