package com.zbiti.mvc.android.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.InspectionResultDao;
import com.zbiti.mvc.android.mapper.InspectionResultMapper;
import com.zbiti.mvc.android.model.CheckDeviceInfo;
import com.zbiti.mvc.android.model.ResultCheckInfo;

@Repository
public class InspectionResultDaoImpl implements InspectionResultDao {

	@Autowired
	private InspectionResultMapper inspectionResultMapperImpl;
	public List<Map<String, String>> getInspectionResult(Map<String, String> map,
			Page page) {
		return inspectionResultMapperImpl.getInspectionResultlistPage(map, page);
	}
	
	public List<Map<String, String>> getFramelUnitId(
			Map<String, String> map) {
		return inspectionResultMapperImpl.getFramelUnitId(map);
	}
	
	public List<Map<String, String>> getSlotUnitID(Map<String, String> unit_id) {
		return inspectionResultMapperImpl.getSlotUnitID(unit_id);
	}

	public List<Map<String, String>> getUnitId(Map<String, String> umap) {
		return inspectionResultMapperImpl.getUnitId(umap);
	}

	public List<Map<String, String>> getAllPortID(Map<String, String> portMap) {
		return inspectionResultMapperImpl.getAllPortID(portMap);
	}

	public List<Map<String, String>> get_portID_result(
			Map<String, String> resultMap) {
		return inspectionResultMapperImpl.get_portID_result(resultMap);
	}

	public List<Map<String, String>> getSplitterPortID(Map<String, String> map) {
		return inspectionResultMapperImpl.getSplitterPortID(map);
	}

	public List<Map<String, String>> getSplitterInPortID(Map<String, String> map) {
		return inspectionResultMapperImpl.getSplitterInPortID(map);
	}

	public Map<String, String> get_MAX_RESULT_ID() {
		return inspectionResultMapperImpl.get_MAX_RESULT_ID();
	}

	public List<Map<String, String>> deviceNo_portTD_map(
			Map<String, String> map_deviceNo_portId) {
		return inspectionResultMapperImpl.deviceNo_portTD_map(map_deviceNo_portId);
	}

	public void saveCheckInfo(CheckDeviceInfo tempCheckInfo) {
		inspectionResultMapperImpl.saveCheckInfo(tempCheckInfo);
	}

	public void saveResultCheckInfo(ResultCheckInfo tempCheckInfo) {
		inspectionResultMapperImpl.saveResultCheckInfo(tempCheckInfo);
	}

	public List<Map> selectAllDeviceInfo(String deviceNo) {
		return inspectionResultMapperImpl.selectAllDeviceInfo(deviceNo);
	}

	@Override
	public List<Map<String, String>> getAllInspectionResultlistPage(Page page) {
		return inspectionResultMapperImpl.getAllInspectionResultlistPage(page);
	}


}
