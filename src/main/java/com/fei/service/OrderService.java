package com.fei.service;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fei.bean.Order;
import com.fei.bean.Result;
import com.fei.vo.OrderVo;

public interface OrderService {
	Result getOrderList(OrderVo vo);

	Result uploadOrderFile(Order order, @RequestParam("files") MultipartFile[] files) throws IllegalStateException, IOException;
	Result addOrder(Order vo);
}
