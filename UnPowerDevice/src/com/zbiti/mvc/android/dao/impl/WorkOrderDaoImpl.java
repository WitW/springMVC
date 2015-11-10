package com.zbiti.mvc.android.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.WorkOrderDao;
import com.zbiti.mvc.android.mapper.WorkOrderMapper;
import com.zbiti.mvc.android.model.WorkOrderInfo;

/**
 * 工单DAO实现类
 * @author dlt
 *
 */
@Repository("WorkOrderDao")
public class WorkOrderDaoImpl implements WorkOrderDao {
	@Autowired
	WorkOrderMapper workOrderMapper;

	public List<WorkOrderInfo> getWorkOrderListByStaffID(String staffId) {
		return workOrderMapper.getWorkOrderListByStaffID(staffId);
	}

	public void updateWorkOrder(String orderId) {
		workOrderMapper.updateWorkOrder(orderId);
	}

	public void saveWorkOrder(WorkOrderInfo wo) {
		workOrderMapper.saveWorkOrder(wo);
	}

	public WorkOrderInfo getWorkOrderId(String orderId) {
		
		return workOrderMapper.getWorkOrderId(orderId);
	}

	public List<WorkOrderInfo> getWorkOrderInfolistPage(
			Map<String, String> map, Page page) {
		
		return workOrderMapper.getWorkOrderInfolistPage(map, page);
	}

	@Override
	public void updateWorkOrderList(String orderId) {
		workOrderMapper.updateWorkOrderList(orderId);
	}

}
