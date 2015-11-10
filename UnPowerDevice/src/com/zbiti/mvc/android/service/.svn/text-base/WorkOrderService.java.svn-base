package com.zbiti.mvc.android.service;

import java.util.List;
import java.util.Map;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.WorkOrderInfo;
import com.zbiti.mvc.android.model.WorkOrderSaveInfo;

/**
 * 工单业务接口
 * @author dlt
 *
 */
public interface WorkOrderService {

	/**
	 * 根据STAFFID获取工单列表
	 * @param staffId
	 * @return
	 */
	public List<WorkOrderInfo> getWorkOrderListByStaffID(String staffId);

	/**
	 * 更新工单状态
	 * @param orderId
	 */
	public void updateWorkOrder(String orderId,String staffId);
	
	/**
	 * 更新离线工单状态
	 * @param orderId
	 */
	public void updateWorkOrderList(List<WorkOrderSaveInfo>workOrderSaveInfo);


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
