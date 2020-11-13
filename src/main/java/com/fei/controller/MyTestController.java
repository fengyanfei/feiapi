package com.fei.controller;

import java.io.File;

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
import com.fei.bean.Result;
import com.fei.bean.Tourist;
import com.fei.bean.User;
import com.fei.service.AgentService;
import com.fei.service.AppHisService;
import com.fei.service.MobileService;
import com.fei.service.TouristService;
import com.fei.util.PropertiesUtils;
import com.fei.util.Utils;
import com.fei.vo.BuildingVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/test")
public class MyTestController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MobileService mobileService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private TouristService touristService;
	@Autowired
	private AppHisService appHisService;
	/**
	 * ¥�̷�ҳ�б�
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
	 * ������:uploadFileTest()<br>
	 * ����:�ļ��ϴ��ӿ�<br>
	 * ����:files<br>
	 * ����ֵ:Result<br>
	 * �쳣˵��:null<br>
	 */
	@RequestMapping(value = "/uploadFileTest", method = RequestMethod.POST)
    @ResponseBody
    private Result uploadFileTest(@RequestParam("files") MultipartFile[] files,User user) {
        Result result = new Result();
        try {

            String path = PropertiesUtils.propertiesMap.get("upload.path");
            String dirName = "order";
            File dir = new File(path + "/" + dirName);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            for(int i=0;i<files.length;i++){
                MultipartFile multipartFile = files[i];
                String name=multipartFile.getOriginalFilename();
                System.out.println(name);
                String filename = Utils.getUUID() + ".png";
                File filepath = new File(dir.getPath(), filename);
                multipartFile.transferTo(filepath);
            }

        } catch (Exception e) {
            logger.error("�ļ��ϴ����Խӿ�====", e);
        }
        return result;
    }
	
	/**
	 * json�ַ����ϴ��ӿ�
	 * @param tourist 
	 * @return
	 */
	@RequestMapping(value = "/jsonUpload")
	@ResponseBody
	private Result jsonUpload(String userList) {
		Result result = new Result();
		try {
			JSONArray array = JSONArray.fromObject(userList);
			JSONObject obj=array.getJSONObject(0);
			Tourist tour = (Tourist)JSONObject.toBean(obj, Tourist.class);  
			result = touristService.registerTourist(tour);
		} catch (Exception e) {
			logger.error("�ο�ע��ӿڷ���====", e);
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
	private Result registerTourist(Tourist map) {
		Result result = new Result();
		try {
			result = touristService.registerTourist(map);
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
