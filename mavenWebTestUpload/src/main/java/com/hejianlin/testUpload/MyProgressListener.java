package com.hejianlin.testUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class MyProgressListener implements ProgressListener {
	// 自定义的上传文件状态类
	private FileUploadStatus fileUploadStatus;
	// session对象
	private HttpSession session;

	// 构造器
	public MyProgressListener(HttpServletRequest request) {
		session = request.getSession();
	}

	@Override
	public void update(long arg0, long arg1, int arg2) {
		System.out.println("监听器被调用");
		// 实例化fileUploadStatus对象
		fileUploadStatus = (FileUploadStatus) (session.getAttribute("fileUploadStatus") == null ? new FileUploadStatus()
				: session.getAttribute("fileUploadStatus"));
		//设置对应的属性
		fileUploadStatus.setBytesReadNumber(arg0);
		fileUploadStatus.setContentLength(arg1);
		fileUploadStatus.setItems(arg2);

		//将该属性设置在session中
		session.setAttribute("fileUploadStatus", fileUploadStatus);

	}

}
