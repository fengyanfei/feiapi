package com.fei.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fei.bean.Client;
import com.fei.bean.Order;
import com.fei.bean.OrderExample;
import com.fei.bean.OrderFile;
import com.fei.bean.Result;
import com.fei.dao.ClientMapper;
import com.fei.dao.OrderFileMapper;
import com.fei.dao.OrderMapper;
import com.fei.service.OrderService;
import com.fei.util.PropertiesUtils;
import com.fei.util.StringUtils;
import com.fei.util.Utils;
import com.fei.vo.OrderVo;
import com.github.pagehelper.PageHelper;

/**
 * 订单表数据查询
 * 
 * @author fei
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderFileMapper orderFileMapper;
	@Autowired
	private ClientMapper clientMapper;

	@Override
	public Result getOrderList(OrderVo vo) {
		Result result = new Result();
		PageHelper.startPage(vo.getStartPage(), vo.getPageSize());
		List<Order> orderList = orderMapper.selectByOrderList(vo);
		/*
		 * for(Order map:orderList){ }
		 */
		result.setData(orderList);
		result.setStatus("success");
		return result;
	}

	@Override
	public Result uploadOrderFile(Order order, MultipartFile[] files) throws IllegalStateException, IOException {
		Result result = new Result();
		if (order != null && !StringUtils.isEmpty(order.getOrderId())) {
			Order currentOrder = orderMapper.selectByPrimaryKey(order.getOrderId());
			int currentProgress = currentOrder.getProgress();
			// 校验提交的状态是否正确,修改和驳回时不能进行修改
			if (order.getProgress() > currentProgress) {
				if (!StringUtils.isEmpty(order.getIdCard())) {
					Client client = new Client();
					client.setClientId(currentOrder.getClientId());
					client.setIdCard(order.getIdCard());
					// 修改客户身份证号
					clientMapper.updateByPrimaryKeySelective(client);
				}
				orderMapper.updateByPrimaryKeySelective(order);

/*				String path = PropertiesUtils.propertiesMap.get("upload.path") + "/"
						+ PropertiesUtils.propertiesMap.get("upload.name");*/
				//upload.name位null，文件夹重复了，在后台会创建一个null的文件夹，改为如下
				String path = PropertiesUtils.propertiesMap.get("upload.path");
				String dirName = "order";
				File dir = new File(path + "/" + dirName);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				// 将上传文件保存到一个目标文件当中
				for (int i = 0; i < files.length; i++) {
					if (!files[i].isEmpty()) {
						MultipartFile multipartFile = files[i];
						String filename = Utils.getUUID() + ".png";
						File filepath = new File(dir.getPath(), filename);
						multipartFile.transferTo(filepath);

						OrderFile record = new OrderFile();
						record.setOrderFileId(Utils.getUUID());
						record.setOrderId(order.getOrderId());
						record.setDeleteFlag(0);
						record.setCreateTime(new Date());
						record.setFilePath("upload/" + dirName + "/" + filename);
						if (order.getProgress() == 3) { // 带看
							record.setFileType(0);
						} else if (order.getProgress() == 6) { // 成交
							record.setFileType(1);
						}

						record.setCreateTime(new Date());
						record.setCreateUser(order.getAgentId());
						orderFileMapper.insert(record);
					}
				}
				result.setStatus(Result.SUCCESS);
			}
		} else {

		}
		return result;
	}

	@Override
	public Result addOrder(Order order) {
		Result result = new Result();
		String id = Utils.getUUID();
		order.setOrderId(Utils.getUUID());
		order.setCreateTime(new Date());
		order.setDeleteFlag(0);
		order.setProgress(0);
		orderMapper.insert(order);
		result.setData(id);
		result.setStatus(Result.SUCCESS);
		result.setMsg("添加成功");
		return result;
	}

}
