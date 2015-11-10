package com.zbiti.mvc.android.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.WorkOrderInfo;

/**
 * 工单DAO层接口
 * @author dlt
 *
 */
public interface WorkOrderDao {
	
	public void updateWorkOrderList(@Param("orderId")String orderId);
	
	/**
	 * 工号获取下属工单
	 * @param staffId
	 * @return
	 */
	public List<WorkOrderInfo> getWorkOrderListByStaffID(String staffId);

	/**
	 * 更新工单状态
	 * @param orderId
	 */
	public void updateWorkOrder(String orderId);

	/**
	 * 工单录入
	 * @param wo
	 */
	public void saveWorkOrder(WorkOrderInfo wo);
	
	/**
	 * 根据工单ID获取工单信息
	 * @param orderId
	 * @return
	 */
	public WorkOrderInfo getWorkOrderId(String orderId);
	
	/**
	 * 分页查询工单信息
	 * @param map
	 * @param page
	 * @return
	 */
	public List<WorkOrderInfo> getWorkOrderInfolistPage(Map<String, String> map, Page page);
	
}
