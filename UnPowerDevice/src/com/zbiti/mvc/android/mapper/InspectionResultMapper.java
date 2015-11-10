package com.zbiti.mvc.android.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.CheckDeviceInfo;
import com.zbiti.mvc.android.model.ResultCheckInfo;


public interface InspectionResultMapper {
	
	/**
	 * 分页查询巡检信息
	 * @param page
	 * @return
	 */
	public List<Map<String, String>> getAllInspectionResultlistPage(@Param("page")Page page);
	
	
	/**
	 * 根据设备编码查询所有信息
	 * @param deviceNo
	 * @return
	 */
	public List<Map> selectAllDeviceInfo(@Param("deviceNo")String deviceNo);
	
	
	/**
	 * 保存巡检端口和插头信息信息
	 * @param tempCheckInfo
	 */
	public void saveResultCheckInfo(ResultCheckInfo tempCheckInfo);
	
	/**
	 * 根据设备编码查询设备下的端口ID
	 * @param map_deviceNo_portId
	 */
	public List<Map<String, String>> deviceNo_portTD_map(@Param("map_deviceNo_portId")Map<String, String>map_deviceNo_portId);
	
	/**
	 * 保存巡检信息
	 * @param tempCheckInfo
	 */
	public void saveCheckInfo(CheckDeviceInfo tempCheckInfo);
	
	
	/**
	 * 查询分光器的IN端口
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> getSplitterInPortID(@Param("map")Map<String, String>map);
	
	/**
	 * 查询分光器的端口
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> getSplitterPortID(@Param("map")Map<String, String>map);

	/**
	 * 分页查询巡检信息
	 * @param map
	 * @param page
	 * @return
	 */
	public List<Map<String, String>> getInspectionResultlistPage(@Param("map")Map<String,String> map,@Param("page")Page page);

	/**
	 * 查询架的UNITID
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> getFramelUnitId(@Param("map")Map<String,String> map);
	
	/**
	 * 查询框的UnitID
	 * @param unit_id
	 * @return
	 */
	
	public List<Map<String, String>>getSlotUnitID(@Param("unit_id")Map<String, String> unit_id);
	
	/**
	 * 查询模块UnitID
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> getUnitId(@Param("umap")Map<String,String> umap);
	
	/**
	 * 查询模块UnitID
	 * @param portMap
	 * @return
	 */
	public List<Map<String, String>> getAllPortID(@Param("portMap")Map<String, String> portMap);
	
	/**
	 * 查看结果表里面的端口ID和巡检结果
	 * @param resultMap
	 * @return
	 */
	public List<Map<String, String>> get_portID_result(@Param("resultMap")Map<String, String>resultMap);
	
	/**
	 * 查看CHECK_INFO表中的最大的RESULT_ID
	 * @return
	 */
	public Map<String, String> get_MAX_RESULT_ID();
}
