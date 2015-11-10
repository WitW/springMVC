package com.zbiti.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zbiti.common.dao.EQPUnitPortInputDao;
import com.zbiti.common.service.EQPUnitPortInputService;

/**
 * 系统资源录入；设备、托盘、端口等<br>
 * 业务层实现类
 * @author dlt
 *
 */
@Service
public class EQPUnitPortInputServiceImpl implements EQPUnitPortInputService {
	
	@Autowired
	private EQPUnitPortInputDao eQPUnitPortInputDaoImpl;

	public String getMaxEqpId() {
		
		return eQPUnitPortInputDaoImpl.getMaxEqpId();
	}

	public String getMaxPortId() {
		
		return eQPUnitPortInputDaoImpl.getMaxPortId();
	}

	public String getMaxUnitId() {
		
		return eQPUnitPortInputDaoImpl.getMaxPortId();
	}

	public void insertEquipmentInfo(Map<String, String> map) {
		
		eQPUnitPortInputDaoImpl.insertEquipmentInfo(map);
	}

	public void insertPortInfo(Map<String, String> map) {
		
		eQPUnitPortInputDaoImpl.insertPortInfo(map);
	}

	public void insertUnitInfo(Map<String, String> map) {
	
		eQPUnitPortInputDaoImpl.insertUnitInfo(map);
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveAllEQPUnitInfo(Map<String,String> map ,int frameNum,int moduleNum,int portNum) {

		//获取系统中最大的设备ID
		String maxEqpId = eQPUnitPortInputDaoImpl.getMaxEqpId();
		
		String newEqpId = String.valueOf(Long.parseLong(maxEqpId) + 1);
		
		
		map.put("PHY_EQP_ID", newEqpId);
		
		//新增设备信息
		eQPUnitPortInputDaoImpl.insertEquipmentInfo(map);
		
		//unit表信息
		Map<String, String> unit = new HashMap<String,String>();
		String unitName = map.get("NAME");
		String unitNo = map.get("NO");
		
		String maxUnitId = eQPUnitPortInputDaoImpl.getMaxUnitId();
		
		long newUnitId = Long.parseLong(maxUnitId) + 1;
		
		unit.put("UNIT_ID", String.valueOf(newUnitId));
		unit.put("NAME", unitName);
		unit.put("NO", unitNo);
		unit.put("AREA_ID", map.get("AREA_ID"));
		
		unit.put("PHY_EQP_ID", newEqpId);
		//unit.put("PARENT_UNIT_ID", null);
		if(map.get("RES_SPEC_ID").equals("411")){//ODF
			unit.put("RES_SPEC_ID", "1135");
		}else if(map.get("RES_SPEC_ID").equals("703")){//光交箱
			unit.put("RES_SPEC_ID", "1140");
		}else if(map.get("RES_SPEC_ID").equals("704")){//分纤箱
			unit.put("RES_SPEC_ID", "1141");
		}
		
		unit.put("SEQUENCE", "1");
		unit.put("ROW_NO", "1");
		unit.put("COLUMN_NO", "1");
		unit.put("COLUMNS", "1");
		unit.put("NUM_ROWS", String.valueOf(frameNum));
		
		//新增设备对应的unit
		eQPUnitPortInputDaoImpl.insertUnitInfo(unit);
		
		//端口最大ID
		String maxPortId = eQPUnitPortInputDaoImpl.getMaxPortId();
		long portId = Long.parseLong(maxPortId);
		
		for (int i = 1; i <= frameNum; i++) {
			
			String unitCode = "/A";
			
			if(i<10){
				unitCode = unitCode + "0";
			}
			String newunitName = unitName + unitCode + i;
			String newunitNo = unitNo + unitCode + i;
			
			unit.put("UNIT_ID", String.valueOf(newUnitId + i + (i - 1) * moduleNum));
			unit.put("NAME", newunitName);
			unit.put("NO", newunitNo);
			unit.put("PARENT_UNIT_ID", String.valueOf(newUnitId));
			
			unit.put("RES_SPEC_ID", "306");
			unit.put("SEQUENCE", i+"");
			unit.put("ROW_NO", i+"");
			unit.put("COLUMNS", "1");
			unit.put("NUM_ROWS", String.valueOf(moduleNum));
			//插入列框
			eQPUnitPortInputDaoImpl.insertUnitInfo(unit);
			
			for (int j = 1; j <= moduleNum; j++) {
				unit.put("UNIT_ID", String.valueOf(newUnitId + i + (i - 1) * moduleNum + j));
				unit.put("NAME", newunitName + "/" + j);
				unit.put("NO", unitCode + i +"/"+j +"");
				//unit.put("NO", j +"");
				unit.put("PARENT_UNIT_ID", String.valueOf(newUnitId + i));
				
				unit.put("RES_SPEC_ID", "313");  //模块
				unit.put("SEQUENCE", j + "");
				unit.put("ROW_NO", j + "");
				unit.put("COLUMNS", portNum + "");
				unit.put("NUM_ROWS", "1");
				//新增模块
				eQPUnitPortInputDaoImpl.insertUnitInfo(unit);
				
				
				for (int v = 1; v <= portNum; v++) {
					
					
					int seqInEqp = (i - 1) * moduleNum * portNum + (j - 1)
					* portNum + v;
					
					System.out.println("====="+String.valueOf(portId + seqInEqp));
					
					Map<String, String> port = new HashMap<String,String>();
					port.put("PHY_PORT_ID", String.valueOf(portId + seqInEqp));
//					port.put("NO",  unitCode + i +"/"+j + "/" + v);
					port.put("NO", i + "/" + j + "/" + v);
					port.put("UNIT_ID", String.valueOf(newUnitId + i + (i - 1) * moduleNum + j));
					port.put("PHY_EQP_ID", newEqpId);
					port.put("RES_SPEC_ID", "361");
					port.put("UP_OR_DOWN_ID", "1");
					port.put("SEQ_IN_UNIT", v + "");
					port.put("SEQ_IN_EQP", seqInEqp + "");
					port.put("ROW_NO", j + "");
					port.put("COLUMN_NO", v + "");
					//新增端口
					eQPUnitPortInputDaoImpl.insertPortInfo(port);
				}
			}
		}
		System.out.println("设备ID。。。。。。。。。。。"+newEqpId);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void saveFGUnitPortInfo(Map<String,String> map,String posType,String parentUnitId){
		//String posType = ""; // 1:8 type=8;1:16 type=16
		
		int typeNum = Integer.parseInt(posType);
		
		String maxEqpId = eQPUnitPortInputDaoImpl.getMaxEqpId();
		
		String newEqpId = String.valueOf(Long.parseLong(maxEqpId) + 1);
		map.put("PHY_EQP_ID", newEqpId);
		
		eQPUnitPortInputDaoImpl.insertEquipmentInfo(map);
		
		String maxUnitId  = eQPUnitPortInputDaoImpl.getMaxUnitId();
		
		String newUnitId =  String.valueOf(Long.parseLong(maxUnitId) + 1);
		
		Map<String, String> unit = new HashMap<String,String>();
		
		unit.put("UNIT_ID", String.valueOf(newUnitId));
		unit.put("NAME", map.get("NAME") + "/1");
		unit.put("NO", map.get("NO") + "/1");
		unit.put("AREA_ID", map.get("AREA_ID"));
		
		unit.put("PHY_EQP_ID", newEqpId);

		unit.put("PARENT_UNIT_ID", parentUnitId);
	
		unit.put("RES_SPEC_ID", "313");
	
		
		unit.put("SEQUENCE", "1");
		unit.put("ROW_NO", "1");
		unit.put("COLUMN_NO", "1");
		unit.put("COLUMNS", "9");
		unit.put("NUM_ROWS", String.valueOf(typeNum / 8 == 0 ? 1
						: typeNum / 8));
		
		//新增设备对应的unit
		eQPUnitPortInputDaoImpl.insertUnitInfo(unit);
		
		String maxPortId = eQPUnitPortInputDaoImpl.getMaxPortId();
		long portId = Long.parseLong(maxPortId);
		for(int i = 1 ; i <= typeNum + 1; i++){
			Map<String, String> port = new HashMap<String,String>();
			port.put("PHY_PORT_ID", String.valueOf(portId + i));
			port.put("UNIT_ID", String.valueOf(newUnitId));
			port.put("PHY_EQP_ID", newEqpId);
			port.put("NO", i + "");
			if(i==typeNum + 1){
				port.put("RES_SPEC_ID", "1131"); //进线口
				port.put("ROW_NO", "1");
				port.put("COLUMN_NO", typeNum+1+"");
			}else{
				port.put("RES_SPEC_ID", "1132");
				port.put("ROW_NO", i/8+1+"");
				port.put("COLUMN_NO", i%8 + "");
			}
			
			port.put("UP_OR_DOWN_ID", "80000408");
			port.put("SEQ_IN_UNIT", i + "");
			port.put("SEQ_IN_EQP", i + "");
			
			
			//新增端口
			eQPUnitPortInputDaoImpl.insertPortInfo(port);
		}
	}

	
	public Map<String, String> getUnitIdByNo(String epqNo,String unitNo) {
		
		return eQPUnitPortInputDaoImpl.getUnitIdByNo(epqNo,unitNo);
	}

	public List<Map<String, String>> getFrameInfo(String eqpNo) {
		
		return eQPUnitPortInputDaoImpl.getFrameInfo(eqpNo);
	}

	public List<Map<String, String>> getAreaByParentId(String parentAreaId) {
		
		return eQPUnitPortInputDaoImpl.getAreaByParentId(parentAreaId);
	}

	public List<Map<String, String>> getPrefectureArea() {
		
		return eQPUnitPortInputDaoImpl.getPrefectureArea();
	}

}
