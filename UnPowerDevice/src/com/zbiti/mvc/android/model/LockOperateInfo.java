package com.zbiti.mvc.android.model;

/**
 * 门禁操作信息model
 * @author dlt
 *
 */
public class LockOperateInfo {
	
	//ID
	private String operId;
	
	//账号
	private String staffNbr;
	
	//设备编码
	private String deviceNo;
	
	//照片路径
	private String photoPath;
	
	//操作日期
	private String operDate;
	
	//操作说明
	private String note;
	
	//操作类型
	private String type;
	
	//用户姓名
	private String staffName;
	
	//设备名称
	private String deviceName;
	
	

	public String getStaffNbr() {
		return staffNbr;
	}

	public void setStaffNbr(String staffNbr) {
		this.staffNbr = staffNbr;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getOperDate() {
		return operDate;
	}

	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
}
