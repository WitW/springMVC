package com.zbiti.mvc.android.model;

import java.util.List;

public class WorkOrderSaveInfoList {
	
	private String staffId;		//操作人
	
	private String area;		//地区

	private List<WorkOrderSaveInfo> workOrderSaveInfo;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<WorkOrderSaveInfo> getWorkOrderSaveInfo() {
		return workOrderSaveInfo;
	}

	public void setWorkOrderSaveInfo(List<WorkOrderSaveInfo> workOrderSaveInfo) {
		this.workOrderSaveInfo = workOrderSaveInfo;
	}

	
	
	
	
}
