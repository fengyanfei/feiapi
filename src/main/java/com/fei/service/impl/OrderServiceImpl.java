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
 * ���������ݲ�ѯ
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
			// У���ύ��״̬�Ƿ���ȷ,�޸ĺͲ���ʱ���ܽ����޸�
			if (order.getProgress() > currentProgress) {
				if (!StringUtils.isEmpty(order.getIdCard())) {
					Client client = new Client();
					client.setClientId(currentOrder.getClientId());
					client.setIdCard(order.getIdCard());
					// �޸Ŀͻ����֤��
					clientMapper.updateByPrimaryKeySelective(client);
				}
				orderMapper.updateByPrimaryKeySelective(order);

/*				String path = PropertiesUtils.propertiesMap.get("upload.path") + "/"
						+ PropertiesUtils.propertiesMap.get("upload.name");*/
				//upload.nameλnull���ļ����ظ��ˣ��ں�̨�ᴴ��һ��null���ļ��У���Ϊ����
				String path = PropertiesUtils.propertiesMap.get("upload.path");
				String dirName = "order";
				File dir = new File(path + "/" + dirName);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				// ���ϴ��ļ����浽һ��Ŀ���ļ�����
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
						if (order.getProgress() == 3) { // ����
							record.setFileType(0);
						} else if (order.getProgress() == 6) { // �ɽ�
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
		result.setMsg("��ӳɹ�");
		return result;
	}

}
