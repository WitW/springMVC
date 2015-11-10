package com.zbiti.common.dao;

import java.util.List;
import java.util.Map;

/**
 * 系统资源录入<br>
 * dao接口
 * @author dlt
 *
 */
public interface EQPUnitPortInputDao {
	
	/**
	 * 新增设备信息
	 * @param map
	 */
	public void insertEquipmentInfo(Map<String,String> map);

	/**
	 * 新增框、托盘等
	 * @param map
	 */
	public void insertUnitInfo(Map<String,String> map);
	
	/**
	 * 新增端口信息
	 * @param map
	 */
	public void insertPortInfo(Map<String,String> map);
	
	/**
	 * 获取最大的设备ID
	 * @return
	 */
	public String getMaxEqpId();
	
	/**
	 * 获取最大的UnitId
	 * @return
	 */
	public String getMaxUnitId();
	
	/**
	 * 获取最大的端口ID
	 * @return
	 */
	public String getMaxPortId();
	
	/**
	 * 通过列框编码查询Unit信息
	 * @param unitNo
	 * @return
	 */
	public Map<String,String> getUnitIdByNo(String epqNo,String unitNo);
	
	/**
	 * 根据设备编码查列/框信息
	 * @param eqpNo
	 * @return
	 */
	public List<Map<String,String>> getFrameInfo(String eqpNo);
	
	/**
	 * 查江苏所有地级区域
	 * @return
	 */
	public List<Map<String,String>> getPrefectureArea();
	
	/**
	 * 根据父ID查，所属区域
	 * @param parentAreaId
	 * @return
	 */
	public List<Map<String,String>> getAreaByParentId(String parentAreaId);
}
