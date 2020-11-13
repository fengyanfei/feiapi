package com.fei.bean;

import java.io.File;

public class UploadFileBean {
	private File file;
    // 上传文件类型
    private String fileType;
    // 封装上传文件名
    private String fileName;
    //id
    private String id;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
}
