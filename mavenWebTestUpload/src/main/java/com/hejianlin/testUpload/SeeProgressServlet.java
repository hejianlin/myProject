package com.hejianlin.testUpload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
//js会应用这个servlet,将fileUploadStatus对象转化为json对象，输出在页面上
@SuppressWarnings("serial")
public class SeeProgressServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FileUploadStatus fileUploadStatus = (FileUploadStatus) req.getSession().getAttribute("fileUploadStatus");

		// 将java对象转化为json对象
		JSONObject jsonObject = JSONObject.fromObject(fileUploadStatus);
		PrintWriter outPrintWriter = resp.getWriter();
		
		outPrintWriter.println(jsonObject.toString());
		outPrintWriter.flush();
		outPrintWriter.close();

	}

}
