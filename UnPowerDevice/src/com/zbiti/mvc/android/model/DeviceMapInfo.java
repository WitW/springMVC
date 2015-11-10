package com.zbiti.mvc.android.model;

/**
 * 设备地图类
 * @author dlt
 *
 */
public class DeviceMapInfo {
	
	private String deviceNo;
	
	private String deviceName;
	
	private String state;
	
	private String longitude;//经度
	
	private String latitude;//维度
	
	private String operDate;
	
	private String staffNbr;

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getOperDate() {
		return operDate;
	}

	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}

	public String getStaffNbr() {
		return staffNbr;
	}

	public void setStaffNbr(String staffNbr) {
		this.staffNbr = staffNbr;
	}
	
}
