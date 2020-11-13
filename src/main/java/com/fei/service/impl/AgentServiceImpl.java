package com.fei.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fei.bean.Agent;
import com.fei.bean.AgentExample;
import com.fei.bean.Company;
import com.fei.bean.CompanyExample;
import com.fei.bean.Result;
import com.fei.bean.Tourist;
import com.fei.dao.AgentMapper;
import com.fei.dao.CompanyMapper;
import com.fei.dao.TouristMapper;
import com.fei.service.AgentService;
import com.fei.util.MD5Encrypt;
import com.fei.util.PropertiesUtils;
import com.fei.util.StringUtils;
import com.fei.util.Utils;

/**
 * ��Ա���ݲ�ѯ
 * 
 * @author fei
 */
@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentMapper agentMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private TouristMapper touristMapper;

	@Autowired
	private HttpServletRequest request;

	@Override
	public Result getAgentList(Agent vo) {
		Result result = new Result();
		AgentExample example = new AgentExample();
		AgentExample.Criteria andDeleteFlagEqualTo = example.createCriteria().andDeleteFlagEqualTo(0);
		if (!StringUtils.isEmpty(vo.getPhone())) {
			andDeleteFlagEqualTo.andPhoneEqualTo(vo.getPhone());
		}
		if (!StringUtils.isEmpty(vo.getPassword())) {
			andDeleteFlagEqualTo.andPasswordEqualTo(vo.getPassword());
		}
		if (!StringUtils.isEmpty(vo.getCompanyId())) {
			andDeleteFlagEqualTo.andCompanyIdEqualTo(vo.getCompanyId());
		}
		List<Agent> agentList = agentMapper.selectByExample(example);
		// ��ѯ��˾���ƺ��쵼����Ϣ
		CompanyExample exampleCompany = new CompanyExample();
		example.createCriteria().andDeleteFlagEqualTo(0);
		List<Company> companyList = companyMapper.selectByExample(exampleCompany);
		HashMap<String, Company> companyMap = new HashMap<String, Company>();
		for (int i = 0; i < companyList.size(); i++) {
			companyMap.put(companyList.get(i).getCompanyId(), companyList.get(i));
		}
		if (agentList.size() > 0) {
			// ���Ǿ������ֶλ����ο��ֶμ����ȥ�����о�������0���ο���1
			for (Agent map : agentList) {
				map.setUserCategory("0");
				if (map.getCompanyId() != null && companyMap.containsKey(map.getCompanyId())) {
					map.setCompanyName(companyMap.get(map.getCompanyId()).getCompanyName());
					map.setCompanyPhone(companyMap.get(map.getCompanyId()).getCompanyPhone());
					map.setLeaderName(companyMap.get(map.getCompanyId()).getLeaderName());
					map.setLeaderPhone(companyMap.get(map.getCompanyId()).getLeaderPhone());
				}
			}
			result.setData(agentList);
			result.setStatus(Result.SUCCESS);
		} else {
			result.setStatus(Result.FAIL);
		}

		return result;
	}

	@Override
	public Agent getAgentBean(String id) {
		Agent bean = agentMapper.selectByPrimaryKey(id);
		// ˵���Ǵ��ڲ���û�б�ɾ�����û�
		if (bean != null && bean.getDeleteFlag() == 0) {
			return bean;
		} else {
			return null;
		}
	}

	@Override
	public Result updateAgent(Agent vo) {
		Result result = new Result();
		Agent agent = agentMapper.selectByPrimaryKey(vo.getId());
		// ԭ������бȽ�
		if (agent != null && agent.getPassword() != null
				&& agent.getPassword().equals(MD5Encrypt.MD5Encode(vo.getOldPassword()))) {
			// ��������
			int updateByPrimaryKeySelective = agentMapper.updateByPrimaryKeySelective(vo);
			if (updateByPrimaryKeySelective > 0) {
				result.setStatus(Result.SUCCESS);
				result.setMsg("�����޸ĳɹ�");
			}
		} else {
			result.setMsg("ԭ���������������д");
		}

		return result;
	}

	/**
	 * 
	 */
	@Override
	public Result uploadHeadImage(String userId,String userCategory, MultipartFile file) throws IllegalStateException, IOException {
		Result result = new Result();
		if (StringUtils.isEmpty(userId) || file.isEmpty()) {
			return result;
		} else {
			String path = PropertiesUtils.propertiesMap.get("upload.path");
			String dirName = "head";
			String filename = Utils.getUUID() + ".png";
			File filepath = new File(path + "/" + dirName, filename);
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// ���ϴ��ļ����浽һ��Ŀ���ļ�����
			file.transferTo(filepath);
			int updateByPrimaryKey;
			String photoPath="upload/" + dirName + "/" + filename;
			if(!StringUtils.isEmpty(userCategory) && userCategory.equals("0")){
				Agent record = new Agent();
				record.setId(userId);
				record.setPhotoPath(photoPath);
				updateByPrimaryKey = agentMapper.updateByPrimaryKeySelective(record);
			}else{
				Tourist tour=new Tourist();
				tour.setId(userId);
				tour.setPhotoPath(photoPath);
				updateByPrimaryKey = touristMapper.updateByPrimaryKeySelective(tour);
			}
			
			if (updateByPrimaryKey > 0) {
				result.setStatus(Result.SUCCESS);
				result.setMsg("����ɹ�");
				result.setData(photoPath);
			}
			return result;
		}
	}
}
