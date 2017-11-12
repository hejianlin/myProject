package com.hejianlin.testUpload;

public class FileUploadStatus {
	// 读取的字节个数
	private long bytesReadNumber = 0L;
	// 字节总个数
	private long contentLength = 0L;
	// 当前被读取的分块的,0表示没有被读取，1表示第一个块被读取，……
	private int  items;

	public void setItems(int items) {
		this.items = items;
	}

	public long getBytesReadNumber() {
		return bytesReadNumber;
	}

	public void setBytesReadNumber(long bytesReadNumber) {
		this.bytesReadNumber = bytesReadNumber;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public int getItems() {
		return items;
	}


}
