package com.hejianlin.testUpload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
public class AJAXFileUploadServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置上传时存在磁盘临时文件
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置支持中文名
		upload.setHeaderEncoding("utf-8");
		MyProgressListener myProgressListener = new MyProgressListener(req);
		upload.setProgressListener(myProgressListener);// 对文件上传进度进行监听
		// 使用servletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个fileItem对应一个form表单输入项
		try {
			List<FileItem> items = upload.parseRequest(req);
			// 得到遍历器
			Iterator<FileItem> iterator = items.iterator();

			while (iterator.hasNext()) {
				FileItem item = iterator.next();
				// 判断是否是表单域
				if (!item.isFormField()) {
					System.out.println("查找到一个二进制数据");
					System.out.println("该文件表单name为：" + item.getFieldName());
					System.out.println("该文件文件名为：" + item.getName());
					System.out.println("该文件文件类型为：" + item.getContentType());
					System.out.println("该文件文件大小为：" + item.getSize());
					System.out.println();

					String fullNameString = item.getName();
					String[] nameArray = fullNameString.split("\\\\");
					String fileName = "tempName";
					if (nameArray.length > 0) {
						fileName = nameArray[nameArray.length - 1];
					}
					// 将上传的文件写入指定的目录
					File uploadFile = new File("e:" + File.separator + "fileupload" + File.separator + fileName);
					try {
						item.write(uploadFile);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 重定向到成功到页面
		resp.sendRedirect("success.jsp");

	}
}
