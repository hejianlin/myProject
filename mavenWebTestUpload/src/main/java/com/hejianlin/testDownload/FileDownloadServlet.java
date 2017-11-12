package com.hejianlin.testDownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FileDownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 得到输入的文件名，转化为utf-8的格式
		String fileName = new String(req.getParameter("fileName").getBytes("ISO-8859-1"), "UTF-8");
		// 得到文件对象
		FileInputStream fis = new FileInputStream(
				new File("e:" + File.separator + "fileupload" + File.separator + fileName));
		// 客户端类型
		System.out.println("客户端类型：" + req.getHeader("User-Agent"));

		// 这里不用设置要下载文件的保存地址，直接使用浏览器下载，下载在浏览器的默认下载地址中

		if (req.getHeader("User-Agent").contains("Firefox")) {
			// 火狐的处理方式是将中文的字符用ISO-8859-1编码，火狐会在客户端自己进行转码
			resp.addHeader("content-disposition", "attachment;filename=" + req.getParameter("fileName"));
		} else if (req.getHeader("User-Agent").contains("MSIE")) {
			//// 使用URLEncoder这个类将中文编码为16进制的asci码，ie可以自己进行转码
			resp.addHeader("content-disposition",
					"attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
		} else if (req.getHeader("User-Agent").contains("Chrome")) {
			resp.addHeader("content-disposition",
					"attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
		}

		ServletOutputStream sos = resp.getOutputStream();

		int count = 0;
		byte[] b = new byte[1024];

		while ((count = fis.read(b)) != -1) {
			sos.write(b, 0, count);
		}

		sos.flush();
		sos.close();
	}

}
