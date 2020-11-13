package com.fei.service;

import com.fei.bean.BaseInfo;
import com.fei.bean.BuildingOldExample;
import com.fei.bean.Client;
import com.fei.bean.LoanOrder;
import com.fei.bean.Result;
import com.fei.bean.SecondHouseOrder;
import com.fei.vo.BuildingOldVo;
import com.fei.vo.BuildingVo;

public interface MobileService {
		
	Result getBuildingListByPage(BuildingVo vo);
	
	Result getBuildingDetail(String buildingId, String userId);
	
	Result getBaseInfo(BaseInfo info);
	
	Result getApartment(String buildingId);
	
	Result getCity(String code, String cityName);
	
	Result getAdvert(Integer advType);
	
	Result getClient(String agentId);
	
	 Result addClient(Client client);
	 
	 Result getProblem(Integer category);
	 
	 Result getBankRate();
	 
	 Result getLoanOrder(LoanOrder order);
	 
	 Result addLoanOrder(LoanOrder order);
	 
	 Result getSecondHouseOrder(SecondHouseOrder vo);
	 
	 Result addSecondHouseOrder(SecondHouseOrder order);
	 
	 Result getBuildingOldListByPage(BuildingOldVo buildOld);
	 
	 Result calculateLoan(double invest, int totalMonth, double yearRate,int type);
	 
	 Result getLoanRate(Integer type);
	 
	 Result getBuildingOldDetail(String buildingOldId);
	 
	  Result calculateCombinationLoan(double accInvest, double accYearRate,
				int accTotalmonth, double busInvest, double busYearRate, int busTotalmonth, int type);
	  
	  Result getUnReportClient(String agentId, String buildId);
}
