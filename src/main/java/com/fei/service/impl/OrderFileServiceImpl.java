package com.fei.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fei.bean.OrderFile;
import com.fei.bean.OrderFileExample;
import com.fei.bean.Result;
import com.fei.bean.UploadFileBean;
import com.fei.dao.OrderFileMapper;
import com.fei.service.OrderFileService;

@Service
public class OrderFileServiceImpl implements OrderFileService{
	
	@Autowired
    private OrderFileMapper orderFileMapper;

	@Override
	public Result getOrderFileList(OrderFile vo) {
		Result result = new Result();
		OrderFileExample example = new OrderFileExample();
		OrderFileExample.Criteria andDeleteFlagEqualTo = example.createCriteria().andDeleteFlagEqualTo(0);
		//根据orderId查询文件列表
		if(!StringUtils.isEmpty(vo.getOrderId())){
			andDeleteFlagEqualTo.andOrderIdEqualTo(vo.getOrderId());
		}
		//根据orderId进行查询
		List<OrderFile> OrderFileList=orderFileMapper.selectByExample(example);
		result.setData(OrderFileList);
		result.setStatus(Result.SUCCESS);
		return result;
	}

	@Override
	public Result UploadFile(UploadFileBean vo) {
		Result result = new Result();
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            System.out.println("获取Android端传过来的普通信息：");
            System.out.println("文件名称: "+vo.getFileName());
            System.out.println("文件大小: "+vo.getFile().length());
            
            fos = new FileOutputStream("http://192.168.0.49:8080/upload/" + vo.getFileName());
            fis = new FileInputStream(vo.getFile());
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            result.setStatus("success");
            System.out.println("文件上传成功");
        } catch (Exception e) {
        	result.setStatus("fail");
            e.printStackTrace();
        } finally {
            close(fos, fis);
        }
		return result;
	}
	
	   private void close(FileOutputStream fos, FileInputStream fis) {
	        if (fis != null) {
	            try {
	                fis.close();
	                fis=null;
	            } catch (IOException e) {
	                System.out.println("FileInputStream关闭失败");
	                e.printStackTrace();
	            }
	        }
	        if (fos != null) {
	            try {
	                fos.close();
	                fis=null;
	            } catch (IOException e) {
	                System.out.println("FileOutputStream关闭失败");
	                e.printStackTrace();
	            }
	        }
	    }
}
