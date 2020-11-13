package com.fei.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class Utils {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String getWebappPath(HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("");
		File proFile = new File(realPath);
		// webappĿ¼
		return proFile.getParent();
	}

	public static String getServerIP(HttpServletRequest request) {
		return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
	}

}
