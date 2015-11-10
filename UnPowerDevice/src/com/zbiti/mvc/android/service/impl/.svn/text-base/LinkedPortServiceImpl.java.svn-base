package com.zbiti.mvc.android.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbiti.mvc.android.dao.LinkedPortDao;
import com.zbiti.mvc.android.service.LinkedPortService;

/**
 * 相连端口业务实现类
 * @author dlt
 *
 */
@Service
public class LinkedPortServiceImpl implements LinkedPortService {
	
	@Autowired
	private LinkedPortDao linkedPortDaoImpl;

	public List<Map<String, String>> getLinePortInfo(String aPort, String zPort) {
		
		return linkedPortDaoImpl.getLinePortInfo(aPort, zPort);
	}

	public void insertLinePort(String aPort, String zPort) {
		
		linkedPortDaoImpl.insertLinePort(aPort, zPort);
	}

	public void updateLinePort(String aPort, String zPort) {
		
		linkedPortDaoImpl.updateLinePort(aPort, zPort);
	}

}
