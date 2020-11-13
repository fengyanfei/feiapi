package com.fei.service;

import com.fei.bean.Result;
import com.fei.bean.Tourist;

public interface TouristService {
	
	Result getTouristBean(Tourist vo);
	
	Result updateTourist(Tourist vo);
	
	Result registerTourist(Tourist tourist);

}
