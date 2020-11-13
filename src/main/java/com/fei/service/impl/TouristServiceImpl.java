package com.fei.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fei.bean.Result;
import com.fei.bean.Tourist;
import com.fei.bean.TouristExample;
import com.fei.dao.TouristMapper;
import com.fei.service.TouristService;
import com.fei.util.MD5Encrypt;
import com.fei.util.StringUtils;
import com.fei.util.Utils;

@Service
public class TouristServiceImpl implements TouristService {

	@Autowired
	private TouristMapper touristMapper;

	/**
	 * 根据传入的查询信息进行游客的查询
	 * 
	 * @author fei
	 */
	@Override
	public Result getTouristBean(Tourist vo) {
		Result result = new Result();
		TouristExample example = new TouristExample();
		TouristExample.Criteria andDeleteFlagEqualTo = example.createCriteria().andDeleteFlagEqualTo(0);
		if (!StringUtils.isEmpty(vo.getPhone()) && !StringUtils.isEmpty(vo.getPassword())) {
			andDeleteFlagEqualTo.andPhoneEqualTo(vo.getPhone()).andPasswordEqualTo(vo.getPassword());
			List<Tourist> touristList = touristMapper.selectByExample(example);
			if (touristList.size() > 0) {
				// 将是经纪人字段还是游客字段加入进去，其中经纪人是0，游客是1
				for (Tourist map : touristList) {
					map.setUserCategory("1");
				}
				result.setData(touristList);
				result.setStatus(Result.SUCCESS);
			} else {
				result.setStatus(Result.FAIL);
				result.setMsg("用户名和密码错误");
			}

		} else {
			result.setStatus(Result.FAIL);
			result.setMsg("用户名或密码为空");
		}
		return result;
	}

	@Override
	public Result updateTourist(Tourist vo) {
		Result result = new Result();
		Tourist tourist = touristMapper.selectByPrimaryKey(vo.getId());
		if (tourist != null && tourist.getPassword() != null
				&& tourist.getPassword().equals(MD5Encrypt.MD5Encode(vo.getOldPassword()))) {
			int updateByPrimaryKeySelective = touristMapper.updateByPrimaryKeySelective(vo);
			if (updateByPrimaryKeySelective > 0) {
				result.setStatus(Result.SUCCESS);
				result.setMsg("密码修改成功");
			}
		} else {
			result.setMsg("原密码错误请重新填写");
		}
		return result;
	}

	@Override
	public Result registerTourist(Tourist tourist) {
		Result result = new Result();
		if (StringUtils.isEmpty(tourist.getPhone()) || StringUtils.isEmpty(tourist.getPassword())) {
			result.setMsg("账号或手机号码为空");
			return result;
		}else{
			String uuid = Utils.getUUID();
			tourist.setId(uuid);
			tourist.setDeleteFlag(0);
			tourist.setCreateTime(new Date());
			tourist.setName(tourist.getName());
			int insert = touristMapper.insert(tourist);
			if (insert > 0) {
				result.setStatus(Result.SUCCESS);
				result.setData(uuid);
				result.setMsg("注册成功");
			}
		}
		return result;
	}
}
