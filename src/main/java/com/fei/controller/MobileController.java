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
 * �ƶ����ֻ��ӿ�
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
	 * ¥�̷�ҳ�б�
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
			logger.error("�·���ҳ��ѯ�б�====", e);
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
			logger.error("�·��������====", e);
		}
		return result;
	}

	/**
	 * ��ȡbaseinfo���� �ɰ�key��ȡ���ɰ�key+code��Ҳ����ȫ����ȡ
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
	 * ��ȡ�����б�
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
			logger.error("��ȡ�����б�====", e);
		}
		return result;
	}
	
	/**
	 * 
	 * @param code �б���
	 * @param cityName ������
	 * @return
	 */
	@RequestMapping(value = "/getArea")
	@ResponseBody
	private Result getArea(String code, String cityName) {
		Result result = new Result();
		try {
			result = mobileService.getCity(code,cityName);
		} catch (Exception e) {
			logger.error("��ȡ������====", e);
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
			logger.error("��ȡ��Ч���====", e);
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
			logger.error("��ȡ��¼�˿ͻ��б�====", e);
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
			logger.error("�����ͻ�====", e);
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
			logger.error("���������б�====", e);
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
			logger.error("���������б�====", e);
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
			logger.error("���ݾ�����Id��ѯ��������б�====", e);
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
			logger.error("�½�֤������====", e);
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
			logger.error("���ַ������б�====", e);
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
			logger.error("�½����ַ�����====", e);
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
			logger.error("���ַ���ҳ��ѯ�б�====", e);
		}
		return result;
	}

	/**
	 * ���ַ�������� �������� ���б�ӿ���ȡ��
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
			logger.error("���ַ��������====", e);
		}
		return result;
	}

	/**
	 * 
	 * @param invest
	 *            �ܶ�
	 * @param totalMonth
	 *            ������
	 * @param yearRate
	 *            ����
	 * @param type
	 *            0�ȶϢ 1�ȶ��
	 * @return
	 */
	@RequestMapping(value = "/calculateLoan")
	@ResponseBody
	private Result calculateLoan(double invest, int totalMonth, double yearRate, int type) {
		Result result = new Result();
		try {
			result = mobileService.calculateLoan(invest, totalMonth, yearRate, type);
		} catch (Exception e) {
			logger.error("����������====", e);
		}
		return result;
	}

	/**
	 * ������������ϴ��� ���������
	 * 
	 * @param accInvest
	 * @param accYearRate
	 * @param accTotalmonth
	 *            �̴�
	 * @param busInvest
	 * @param busYearRate
	 * @param busTotalmonth
	 * @param type
	 *            0�ȶϢ 1�ȶ��
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
			logger.error("������������ϴ���====", e);
		}
		return result;
	}

	/**
	 * ������������ȡ����
	 * 
	 * @param type
	 *            0������ 1�̴�
	 * @return
	 */
	@RequestMapping(value = "/getLoanRate")
	@ResponseBody
	private Result getLoanRate(Integer type) {
		Result result = new Result();
		try {
			result = mobileService.getLoanRate(type);
		} catch (Exception e) {
			logger.error("������������ȡ����====", e);
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
			logger.error("��ȡ¥��δ�����ͻ�====", e);
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
