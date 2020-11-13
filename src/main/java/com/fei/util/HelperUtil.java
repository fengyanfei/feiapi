package com.fei.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HelperUtil {
	
	
	/**
	 * ������:saveUrlAs()<br>
	 * ����:�����ļ�<br>
	 * ����:File�ļ������ַ<br>
	 * ����:String �ļ�����<br>
	 * ����ֵ:null<br>
	 * �쳣˵��:java.io.IOException<br>
	 **/
	public static List<String> FileUpload(File[] fileList, String[] fileName,String path) {
		List<String> pathList=new ArrayList<>();
		try{
			if(fileList!=null && fileName!=null){
				for (int i = 0; i < fileList.length; i++) {
					// �����չ��
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					String newFileName = df.format(new Date()) + "_" + fileName[i];
					InputStream in = new FileInputStream(fileList[i]);
					pathList.add("upload/project/"+newFileName);
					File planFile=new File(path);
					if(!planFile.exists()){
						planFile.mkdirs();
					}
					File uploadFile = new File(path, newFileName);
					OutputStream out = new FileOutputStream(uploadFile);
					byte[] buffer = new byte[1024 * 1024];
					int length;
					while ((length = in.read(buffer)) > 0) {
						out.write(buffer, 0, length);
					}
					in.close();
					out.close();
				}
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pathList;
	}

}
