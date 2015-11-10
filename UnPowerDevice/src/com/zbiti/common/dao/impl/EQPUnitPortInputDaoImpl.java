package com.zbiti.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zbiti.common.dao.EQPUnitPortInputDao;
import com.zbiti.common.mapper.EQPUnitPortInputMapper;

/**
 * 系统资源录入<br>
 * dao实现类
 * @author dlt
 *
 */
@Repository("eQPUnitPortInputDaoImpl")
public class EQPUnitPortInputDaoImpl implements EQPUnitPortInputDao {

	@Autowired
	private EQPUnitPortInputMapper eQPUnitPortInputMapper;
	
	public String getMaxEqpId() {
		
		return eQPUnitPortInputMapper.getMaxEqpId();
	}

	public String getMaxPortId() {
		
		return eQPUnitPortInputMapper.getMaxPortId();
	}

	public String getMaxUnitId() {
		
		return eQPUnitPortInputMapper.getMaxUnitId();
	}

	public void insertEquipmentInfo(Map<String, String> map) {
		
		eQPUnitPortInputMapper.insertEquipmentInfo(map);
	}

	public void insertPortInfo(Map<String, String> map) {
		
		eQPUnitPortInputMapper.insertPortInfo(map);
	}

	public void insertUnitInfo(Map<String, String> map) {

		eQPUnitPortInputMapper.insertUnitInfo(map);
	}

	public Map<String, String> getUnitIdByNo(String eqpNo,String unitNo) {
		
		return eQPUnitPortInputMapper.getUnitIdByNo(eqpNo,unitNo);
	}

	public List<Map<String, String>> getFrameInfo(String eqpNo) {
		
		return eQPUnitPortInputMapper.getFrameInfo(eqpNo);
	}

	public List<Map<String, String>> getAreaByParentId(String parentAreaId) {
		
		return eQPUnitPortInputMapper.getAreaByParentId(parentAreaId);
	}

	public List<Map<String, String>> getPrefectureArea() {
		
		return eQPUnitPortInputMapper.getPrefectureArea();
	}

}
