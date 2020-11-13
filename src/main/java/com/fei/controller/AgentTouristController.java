package com.fei.controller;

import java.io.File;

/**
 * �ֻ����ο͡������˽ӿ�����s
 * @author fengyanfei
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fei.bean.Agent;
import com.fei.bean.Order;
import com.fei.bean.OrderFile;
import com.fei.bean.Result;
import com.fei.bean.Tourist;
import com.fei.bean.User;
import com.fei.service.AgentService;
import com.fei.service.AppHisService;
import com.fei.service.OrderFileService;
import com.fei.service.OrderService;
import com.fei.service.TouristService;
import com.fei.util.MD5Encrypt;
import com.fei.util.PropertiesUtils;
import com.fei.util.StringUtils;
import com.fei.util.Utils;
import com.fei.vo.OrderVo;

@Controller
@RequestMapping("/user")
public class AgentTouristController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TouristService touristService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderFileService orderFileService;
	@Autowired
	private AppHisService appHisService;

	/**
	 * ������:getUserBean()<br>
	 * ����:�����û������������ο͡���������<br>
	 * ����:phone,password<br>
	 * ����ֵ:Result<br>
	 * �쳣˵��:null<br>
	 */
	@RequestMapping(value = "/userLogin")
	@ResponseBody
	private Result userLogin(Agent vo) {
		Result result = new Result();
		try {
			if (vo.getPassword() != null && vo.getPassword().length() > 0) {
				String password = MD5Encrypt.MD5Encode(vo.getPassword());
				vo.setPassword(password);
			}
			result = agentService.getAgentList(vo);
			// ���ھ����˱��в鲻��ʱ�����οͱ��н��в�ѯ
			if (null == result.getData() || result.getData().equals("")) {
				Tourist tourist = new Tourist();
				tourist.setPhone(vo.getPhone());
				tourist.setPassword(vo.getPassword());
				result = touristService.getTouristBean(tourist);
			}

		} catch (Exception e) {
			logger.error("�����û������������û�����====", e);
		}
		return result;
	}

	/**
	 * ������:doUpdatePassword()<br>
	 * ����:�����û�id���µ�����Ե�¼�˽��������޸�<br>
	 * ����:id,password,oldPasswordԭ����<br>
	 * ����ֵ:Result<br>
	 * �쳣˵��:null<br>
	 */
	@RequestMapping(value = "/doUpdatePassword")
	@ResponseBody
	private Result doUpdatePassword(Agent vo) {
		Result result = new Result();
		try {
			if (!StringUtils.isEmpty(vo.getPassword()) && !StringUtils.isEmpty(vo.getOldPassword())
					&& !StringUtils.isEmpty(vo.getPassword())) {
				// ������
				if (vo.getUserCategory() != null && vo.getUserCategory().equals("0")) {
					result = agentService.updateAgent(vo);
					// �ο�
				} else {
					Tourist tourist = new Tourist();
					tourist.setId(vo.getId());
					tourist.setPassword(vo.getPassword());
					tourist.setOldPassword(vo.getOldPassword());
					result = touristService.updateTourist(tourist);
				}
			} else {
				result.setMsg("ԭ�����������Ϊ������д");
			}
		} catch (Exception e) {
			logger.error("�����û�id���µ�����Ե�¼�˽��������޸�====", e);
		}
		return result;
	}

	/**
	 * ������:getAgentList()<br>
	 * ����:���ݹ�˾ID��ȡ�ù�˾�ľ������б�<br>
	 * ����:companyId<br>
	 * ����ֵ:Result<br>
	 * �쳣˵��:null<br>
	 */
	@RequestMapping(value = "/getAgentList")
	@ResponseBody
	private Result getAgentList(Agent vo) {
		Result result = new Result();
		try {
			result = agentService.getAgentList(vo);
		} catch (Exception e) {
			logger.error("���ݹ�˾ID��ȡ�ù�˾�ľ������б�====", e);
		}
		return result;
	}

	/**
	 * ������:getOrderList()<br>
	 * ����:������ԱID��ѯ�Լ��Ķ���������������ǹ�˾��������鿴��˾������Ա������<br>
	 * ����:id<br>
	 * ����ֵ:Result<br>
	 * �쳣˵��:null<br>
	 */
	@RequestMapping(value = "/getOrderList")
	@ResponseBody
	private Result getOrderList(OrderVo vo) {
		Result result = new Result();
		try {
			result = orderService.getOrderList(vo);
		} catch (Exception e) {
			logger.error("������ԱID��ѯ�Լ��Ķ���====", e);
		}
		return result;
	}

	/**
	 * ������:getOrderFileList()<br>
	 * ����:���ݶ���ID��ѯ�ö����µ�����ͼƬ����<br>
	 * ����:orderId<br>
	 * ����ֵ:Result<br>
	 * �쳣˵��:null<br>
	 */
	@RequestMapping(value = "/getOrderFileList")
	@ResponseBody
	private Result getOrderFileList(OrderFile vo) {
		Result result = new Result();
		try {
			result = orderFileService.getOrderFileList(vo);
		} catch (Exception e) {
			logger.error("���ݶ���ID��ѯ�ö����µ�����ͼƬ����====", e);
		}
		return result;
	}

	/**
	 * ������:doUploadFile()<br>
	 * ����:�����ļ��ϴ�����<br>
	 * ����:id,file<br>
	 * ����ֵ:Result<br>
	 * �쳣˵��:null<br>
	 */
	@RequestMapping(value = "/uploadOrderFile", method = RequestMethod.POST)
	@ResponseBody
	private Result uploadOrderFile(Order order, @RequestParam("files") MultipartFile[] files) {
		Result result = new Result();
		try {
			result = orderService.uploadOrderFile(order, files);
		} catch (Exception e) {
			logger.error("�����ϴ��ļ�====", e);
		}
		return result;
	}

	/**
	 * �ϴ�ͷ��
	 * 
	 * @param userId
	 *            �û�id
	 * @param userCategory
	 *            �û����0�������ˣ�1���ο�
	 * @param file
	 *            ͼƬ
	 * @return
	 */
	@RequestMapping(value = "/uploadHeadImage", method = RequestMethod.POST)
	@ResponseBody
	private Result uploadHeadImage(@RequestParam("userId") String userId,
			@RequestParam("userCategory") String userCategory, @RequestParam("file") MultipartFile file) {
		Result result = new Result();
		try {
			result = agentService.uploadHeadImage(userId,userCategory, file);
		} catch (Exception e) {
			logger.error("�ϴ�ͷ��====", e);
		}
		return result;
	}

	/**
	 * ������:addOrder()<br>
	 * ����:����������������<br>
	 * ����ֵ: ����ֵ:Result<br>
	 * �쳣˵��:null<br>
	 */
	@RequestMapping(value = "/addOrder")
	@ResponseBody
	private Result addOrder(Order order) {
		Result result = new Result();
		try {
			result = orderService.addOrder(order);
		} catch (Exception e) {
			logger.error("����������������====", e);
		}
		return result;
	}
	
	/**
	 * �ο�ע��ӿ�
	 * @param tourist 
	 * @return
	 */
	@RequestMapping(value = "/registerTourist")
	@ResponseBody
	private Result registerTourist(Tourist tourist) {
		Result result = new Result();
		try {
			result = touristService.registerTourist(tourist);
		} catch (Exception e) {
			logger.error("�ο�ע��ӿڷ���====", e);
		}
		return result;
	}
	/**
	 * APP���ؽӿ�
	 * @param systemType��Android����IOS
	 * @return
	 */
	@RequestMapping(value = "/getAppsHis")
	@ResponseBody
	private Result getAppsHis(String systemType) {
		Result result = new Result();
		try {
			result = appHisService.getApps(systemType);
		} catch (Exception e) {
			logger.error("APP���ؽӿڷ���====", e);
		}
		return result;
	}
	
}
