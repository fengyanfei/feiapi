package com.fei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fei.bean.Company;
import com.fei.bean.CompanyExample;
import com.fei.bean.Result;
import com.fei.dao.CompanyMapper;
import com.fei.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
    private CompanyMapper companyMapper;
	@Override
	public Result getCompanyBean(Company vo) {
		Result result = new Result();
		CompanyExample example = new CompanyExample();
		example.createCriteria().andDeleteFlagEqualTo(0);
		List<Company> companyist=companyMapper.selectByExample(example);
		result.setData(companyist);
		result.setStatus(Result.SUCCESS);
		return result;
	}

}
