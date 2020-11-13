package com.fei.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fei.bean.Agent;
import com.fei.bean.Result;

public interface AgentService {
	
	Result getAgentList(Agent agent);
	
	Agent getAgentBean(String id);
	
	Result updateAgent(Agent agent);
	
	Result uploadHeadImage(String userId,String userCategory,MultipartFile file) throws IllegalStateException, IOException;
}
