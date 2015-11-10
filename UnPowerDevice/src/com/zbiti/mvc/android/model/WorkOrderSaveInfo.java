package com.zbiti.mvc.android.model;

import java.util.List;

public class WorkOrderSaveInfo {
	private String staffId;		//操作人
	
	private String area;		//地区
	
	private String orderId;		//工单ID
	
	private String event;		//工单类型
	
	private List<PortRfidInfo> ports ;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public List<PortRfidInfo> getPorts() {
		return ports;
	}

	public void setPorts(List<PortRfidInfo> ports) {
		this.ports = ports;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
}
