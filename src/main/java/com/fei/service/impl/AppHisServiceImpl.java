package com.fei.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * APPÏÂÔØ½Ó¿Ú
 * 
 * @author fei
 */
import org.springframework.stereotype.Service;

import com.fei.bean.AppsHis;
import com.fei.bean.AppsHisExample;
import com.fei.bean.Result;
import com.fei.dao.AppsHisMapper;
import com.fei.service.AppHisService;
@Service
public class AppHisServiceImpl implements AppHisService {

	@Autowired
	private AppsHisMapper appsHisMapper;
	
	@Override
	public Result getApps(String systemType) {
		Result result = new Result();
		AppsHisExample example = new AppsHisExample();
		AppsHisExample.Criteria andDeleteFlagEqualTo = example.createCriteria().andDeleteFlagEqualTo(0).andAppStatusEqualTo("1");
		andDeleteFlagEqualTo.andSystemTypeEqualTo(systemType);
		List<AppsHis> appList = appsHisMapper.selectByExample(example);
		if(appList!=null && appList.size()==1){
			result.setData(appList.get(0));
			result.setStatus(Result.SUCCESS);
		}
		return result;
	}

}
