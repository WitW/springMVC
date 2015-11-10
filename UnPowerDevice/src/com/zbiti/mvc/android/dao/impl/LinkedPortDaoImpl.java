package com.zbiti.mvc.android.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zbiti.mvc.android.dao.LinkedPortDao;
import com.zbiti.mvc.android.mapper.LinkedPortMapper;

/**
 * 相连端口dao实现类
 * @author dlt
 *
 */
@Repository
public class LinkedPortDaoImpl implements LinkedPortDao {
	
	@Autowired
	private LinkedPortMapper linkedPortMapper;

	public List<Map<String, String>> getLinePortInfo(String aPort, String zPort) {
		
		return linkedPortMapper.getLinePortInfo(aPort, zPort);
	}

	public void insertLinePort(String aPort, String zPort) {
		
		linkedPortMapper.insertLinePort(aPort, zPort);
	}

	public void updateLinePort(String aPort, String zPort) {
		
		linkedPortMapper.updateLinePort(aPort, zPort);
	}

}
