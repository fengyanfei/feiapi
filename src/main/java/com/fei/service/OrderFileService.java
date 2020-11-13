package com.fei.service;

import com.fei.bean.OrderFile;
import com.fei.bean.Result;
import com.fei.bean.UploadFileBean;

public interface OrderFileService {
	Result getOrderFileList(OrderFile vo);
	
	Result UploadFile(UploadFileBean vo);
}
