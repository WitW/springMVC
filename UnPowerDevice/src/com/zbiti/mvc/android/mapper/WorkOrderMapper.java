package com.zbiti.mvc.android.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.WorkOrderInfo;

public interface WorkOrderMapper {
	
	
	public void updateWorkOrderList(@Param("orderId")String orderId);
	
	/**
	 * 获取工单列表
	 * @param staffId
	 * @return
	 */
	public List<WorkOrderInfo> getWorkOrderListByStaffID(@Param("staffId")String staffId);

	/**
	 * 修改工单状态
	 * @param orderId
	 */
	public void updateWorkOrder(@Param("orderId")String orderId);

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
	public WorkOrderInfo getWorkOrderId(@Param("orderId")String orderId);
	
	/**
	 * 分页查询工单信息
	 * @param map
	 * @param page
	 * @return
	 */
	public List<WorkOrderInfo> getWorkOrderInfolistPage(@Param("map")Map<String,String> map,@Param("page")Page page);
	

}
