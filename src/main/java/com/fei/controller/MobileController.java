package com.fei.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fei.bean.BaseInfo;
import com.fei.bean.Client;
import com.fei.bean.LoanOrder;
import com.fei.bean.Result;
import com.fei.bean.SecondHouseOrder;
import com.fei.service.MobileService;
import com.fei.vo.BuildingOldVo;
import com.fei.vo.BuildingVo;

/**
 * 移动端手机接口
 * 
 * @author chw
 *
 */
@Controller
@RequestMapping("/mobile")
public class MobileController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MobileService mobileService;

	/**
	 * 楼盘分页列表
	 * 
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/getBuildingListByPage")
	@ResponseBody
	private Result getBuildingListByPage(BuildingVo vo) {
		Result result = new Result();
		try {
			result = mobileService.getBuildingListByPage(vo);
		} catch (Exception e) {
			logger.error("新房分页查询列表====", e);
		}
		return result;
	}

	@RequestMapping(value = "/getBuildingDetail")
	@ResponseBody
	private Result getBuildingDetail(String buildingId, String userId) {
		Result result = new Result();
		try {
			result = mobileService.getBuildingDetail(buildingId, userId);
		} catch (Exception e) {
			logger.error("新房详情参数====", e);
		}
		return result;
	}

	/**
	 * 获取baseinfo数据 可按key获取，可按key+code，也可以全部获取
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/getBaseInfo")
	@ResponseBody
	private Result getBaseInfo(BaseInfo info) {
		Result result = new Result();
		try {
			result = mobileService.getBaseInfo(info);
		} catch (Exception e) {
			logger.error("BaseInfo====", e);
		}
		return result;
	}

	/**
	 * 获取户型列表
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/getApartment")
	@ResponseBody
	private Result getApartment(String buildingId) {
		Result result = new Result();
		try {
			result = mobileService.getApartment(buildingId);
		} catch (Exception e) {
			logger.error("获取户型列表====", e);
		}
		return result;
	}
	
	/**
	 * 
	 * @param code 市编码
	 * @param cityName 市名称
	 * @return
	 */
	@RequestMapping(value = "/getArea")
	@ResponseBody
	private Result getArea(String code, String cityName) {
		Result result = new Result();
		try {
			result = mobileService.getCity(code,cityName);
		} catch (Exception e) {
			logger.error("获取所有市====", e);
		}
		return result;
	}

	@RequestMapping(value = "/getAdvert")
	@ResponseBody
	private Result getAdvert(Integer advType) {
		Result result = new Result();
		try {
			result = mobileService.getAdvert(advType);
		} catch (Exception e) {
			logger.error("获取生效广告====", e);
		}
		return result;
	}

	@RequestMapping(value = "/getClient")
	@ResponseBody
	private Result getClient(String agentId) {
		Result result = new Result();
		try {
			result = mobileService.getClient(agentId);
		} catch (Exception e) {
			logger.error("获取登录人客户列表====", e);
		}
		return result;
	}

	@RequestMapping(value = "/addClient")
	@ResponseBody
	private Result addClient(Client client) {
		Result result = new Result();
		try {
			result = mobileService.addClient(client);
		} catch (Exception e) {
			logger.error("新增客户====", e);
		}
		return result;
	}

	@RequestMapping(value = "/getProblem")
	@ResponseBody
	private Result getProblem(Integer userCategory) {
		Result result = new Result();
		try {
			result = mobileService.getProblem(userCategory);
		} catch (Exception e) {
			logger.error("常见问题列表====", e);
		}
		return result;
	}

	@RequestMapping(value = "/getBankRate")
	@ResponseBody
	private Result getBankRate() {
		Result result = new Result();
		try {
			result = mobileService.getBankRate();
		} catch (Exception e) {
			logger.error("银行利率列表====", e);
		}
		return result;
	}

	@RequestMapping(value = "/getLoanOrder")
	@ResponseBody
	private Result getLoanOrder(LoanOrder vo) {
		Result result = new Result();
		try {
			result = mobileService.getLoanOrder(vo);
		} catch (Exception e) {
			logger.error("根据经纪人Id查询贷款办理列表====", e);
		}
		return result;
	}

	@RequestMapping(value = "/addLoanOrder")
	@ResponseBody
	private Result addLoanOrder(LoanOrder order) {
		Result result = new Result();
		try {
			result = mobileService.addLoanOrder(order);
		} catch (Exception e) {
			logger.error("新建证件办理====", e);
		}
		return result;
	}

	@RequestMapping(value = "/getSecondHouseOrder")
	@ResponseBody
	private Result getSecondHouseOrder(SecondHouseOrder vo) {
		Result result = new Result();
		try {
			result = mobileService.getSecondHouseOrder(vo);
		} catch (Exception e) {
			logger.error("二手房过户列表====", e);
		}
		return result;
	}

	@RequestMapping(value = "/addSecondHouseOrder")
	@ResponseBody
	private Result addSecondHouseOrder(SecondHouseOrder order) {
		Result result = new Result();
		try {
			result = mobileService.addSecondHouseOrder(order);
		} catch (Exception e) {
			logger.error("新建二手房过户====", e);
		}
		return result;
	}

	@RequestMapping(value = "/getBuildingOldListByPage")
	@ResponseBody
	private Result getBuildingOldListByPage(BuildingOldVo buildOld) {
		Result result = new Result();
		try {
			result = mobileService.getBuildingOldListByPage(buildOld);
		} catch (Exception e) {
			logger.error("二手房分页查询列表====", e);
		}
		return result;
	}

	/**
	 * 二手房详情参数 其它参数 在列表接口中取到
	 * 
	 * @param buildingOldId
	 * @return
	 */
	@RequestMapping(value = "/getBuildingOldDetail")
	@ResponseBody
	private Result getBuildingOldDetail(String buildingOldId) {
		Result result = new Result();
		try {
			result = mobileService.getBuildingOldDetail(buildingOldId);
		} catch (Exception e) {
			logger.error("二手房详情参数====", e);
		}
		return result;
	}

	/**
	 * 
	 * @param invest
	 *            总额
	 * @param totalMonth
	 *            总月数
	 * @param yearRate
	 *            利率
	 * @param type
	 *            0等额本息 1等额本金
	 * @return
	 */
	@RequestMapping(value = "/calculateLoan")
	@ResponseBody
	private Result calculateLoan(double invest, int totalMonth, double yearRate, int type) {
		Result result = new Result();
		try {
			result = mobileService.calculateLoan(invest, totalMonth, yearRate, type);
		} catch (Exception e) {
			logger.error("房贷计算器====", e);
		}
		return result;
	}

	/**
	 * 房贷计算器组合贷款 公积金参数
	 * 
	 * @param accInvest
	 * @param accYearRate
	 * @param accTotalmonth
	 *            商贷
	 * @param busInvest
	 * @param busYearRate
	 * @param busTotalmonth
	 * @param type
	 *            0等额本息 1等额本金
	 * @return
	 */
	@RequestMapping(value = "/calculateCombinationLoan")
	@ResponseBody
	private Result calculateCombinationLoan(double accInvest, double accYearRate, int accTotalmonth, double busInvest,
			double busYearRate, int busTotalmonth, int type) {
		Result result = new Result();
		try {
			result = mobileService.calculateCombinationLoan(accInvest, accYearRate, accTotalmonth, busInvest,
					busYearRate, busTotalmonth, type);
		} catch (Exception e) {
			logger.error("房贷计算器组合贷款====", e);
		}
		return result;
	}

	/**
	 * 房贷计算器获取利率
	 * 
	 * @param type
	 *            0公积金 1商贷
	 * @return
	 */
	@RequestMapping(value = "/getLoanRate")
	@ResponseBody
	private Result getLoanRate(Integer type) {
		Result result = new Result();
		try {
			result = mobileService.getLoanRate(type);
		} catch (Exception e) {
			logger.error("房贷计算器获取利率====", e);
		}
		return result;
	}

	/***
	 * 
	 * @param agentId
	 * @param buildId
	 * @return
	 */
	@RequestMapping(value = "/getUnReportClient")
	@ResponseBody
	private Result getUnReportClient(String agentId, String buildId) {
		Result result = new Result();
		try {
			result = mobileService.getUnReportClient(agentId, buildId);
		} catch (Exception e) {
			logger.error("获取楼盘未报备客户====", e);
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
