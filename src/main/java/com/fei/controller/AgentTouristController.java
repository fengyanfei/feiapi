package com.fei.controller;

import java.io.File;

/**
 * 手机端游客、经纪人接口数据s
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
	 * 方法名:getUserBean()<br>
	 * 描述:根据用户名和密码获得游客、经纪数据<br>
	 * 输入:phone,password<br>
	 * 返回值:Result<br>
	 * 异常说明:null<br>
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
			// 当在经纪人表中查不到时，到游客表中进行查询
			if (null == result.getData() || result.getData().equals("")) {
				Tourist tourist = new Tourist();
				tourist.setPhone(vo.getPhone());
				tourist.setPassword(vo.getPassword());
				result = touristService.getTouristBean(tourist);
			}

		} catch (Exception e) {
			logger.error("根据用户名和密码获得用户数据====", e);
		}
		return result;
	}

	/**
	 * 方法名:doUpdatePassword()<br>
	 * 描述:根据用户id和新的密码对登录人进行密码修改<br>
	 * 输入:id,password,oldPassword原密码<br>
	 * 返回值:Result<br>
	 * 异常说明:null<br>
	 */
	@RequestMapping(value = "/doUpdatePassword")
	@ResponseBody
	private Result doUpdatePassword(Agent vo) {
		Result result = new Result();
		try {
			if (!StringUtils.isEmpty(vo.getPassword()) && !StringUtils.isEmpty(vo.getOldPassword())
					&& !StringUtils.isEmpty(vo.getPassword())) {
				// 经纪人
				if (vo.getUserCategory() != null && vo.getUserCategory().equals("0")) {
					result = agentService.updateAgent(vo);
					// 游客
				} else {
					Tourist tourist = new Tourist();
					tourist.setId(vo.getId());
					tourist.setPassword(vo.getPassword());
					tourist.setOldPassword(vo.getOldPassword());
					result = touristService.updateTourist(tourist);
				}
			} else {
				result.setMsg("原密码或新密码为空请填写");
			}
		} catch (Exception e) {
			logger.error("根据用户id和新的密码对登录人进行密码修改====", e);
		}
		return result;
	}

	/**
	 * 方法名:getAgentList()<br>
	 * 描述:根据公司ID获取该公司的经纪人列表<br>
	 * 输入:companyId<br>
	 * 返回值:Result<br>
	 * 异常说明:null<br>
	 */
	@RequestMapping(value = "/getAgentList")
	@ResponseBody
	private Result getAgentList(Agent vo) {
		Result result = new Result();
		try {
			result = agentService.getAgentList(vo);
		} catch (Exception e) {
			logger.error("根据公司ID获取该公司的经纪人列表====", e);
		}
		return result;
	}

	/**
	 * 方法名:getOrderList()<br>
	 * 描述:根据人员ID查询自己的订单，如果经纪人是公司负责人则查看公司下所有员工订单<br>
	 * 输入:id<br>
	 * 返回值:Result<br>
	 * 异常说明:null<br>
	 */
	@RequestMapping(value = "/getOrderList")
	@ResponseBody
	private Result getOrderList(OrderVo vo) {
		Result result = new Result();
		try {
			result = orderService.getOrderList(vo);
		} catch (Exception e) {
			logger.error("根据人员ID查询自己的订单====", e);
		}
		return result;
	}

	/**
	 * 方法名:getOrderFileList()<br>
	 * 描述:根据订单ID查询该订单下的所有图片数据<br>
	 * 输入:orderId<br>
	 * 返回值:Result<br>
	 * 异常说明:null<br>
	 */
	@RequestMapping(value = "/getOrderFileList")
	@ResponseBody
	private Result getOrderFileList(OrderFile vo) {
		Result result = new Result();
		try {
			result = orderFileService.getOrderFileList(vo);
		} catch (Exception e) {
			logger.error("根据订单ID查询该订单下的所有图片数据====", e);
		}
		return result;
	}

	/**
	 * 方法名:doUploadFile()<br>
	 * 描述:订单文件上传方法<br>
	 * 输入:id,file<br>
	 * 返回值:Result<br>
	 * 异常说明:null<br>
	 */
	@RequestMapping(value = "/uploadOrderFile", method = RequestMethod.POST)
	@ResponseBody
	private Result uploadOrderFile(Order order, @RequestParam("files") MultipartFile[] files) {
		Result result = new Result();
		try {
			result = orderService.uploadOrderFile(order, files);
		} catch (Exception e) {
			logger.error("订单上传文件====", e);
		}
		return result;
	}

	/**
	 * 上传头像
	 * 
	 * @param userId
	 *            用户id
	 * @param userCategory
	 *            用户类别0：经纪人，1：游客
	 * @param file
	 *            图片
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
			logger.error("上传头像====", e);
		}
		return result;
	}

	/**
	 * 方法名:addOrder()<br>
	 * 描述:报备新增订单方法<br>
	 * 输入值: 返回值:Result<br>
	 * 异常说明:null<br>
	 */
	@RequestMapping(value = "/addOrder")
	@ResponseBody
	private Result addOrder(Order order) {
		Result result = new Result();
		try {
			result = orderService.addOrder(order);
		} catch (Exception e) {
			logger.error("报备新增订单方法====", e);
		}
		return result;
	}
	
	/**
	 * 游客注册接口
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
			logger.error("游客注册接口方法====", e);
		}
		return result;
	}
	/**
	 * APP下载接口
	 * @param systemType：Android或者IOS
	 * @return
	 */
	@RequestMapping(value = "/getAppsHis")
	@ResponseBody
	private Result getAppsHis(String systemType) {
		Result result = new Result();
		try {
			result = appHisService.getApps(systemType);
		} catch (Exception e) {
			logger.error("APP下载接口方法====", e);
		}
		return result;
	}
	
}
