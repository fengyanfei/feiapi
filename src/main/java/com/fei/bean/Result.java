package com.fei.bean;

public class Result {
	
	private String status;
	
	private String msg;
	
	private int totalSize;
	
	private Object data;
	
	
	public final static String SUCCESS = "success";
	public final static String FAIL = "fail";
	public final static String REPEAT = "repeat";



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public Result() {
		super();
		status = FAIL;
	}
	
	

}
