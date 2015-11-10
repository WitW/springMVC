package com.zbiti.mvc.android.model;


/**
 * 设备端口实体类
 * @author zhaoqi
 *
 */
public class DevicePortInfo {
	//光路编码
	private String glNo;
	//设备ID
	private String deviceId;
	//经度
	private String longitude;
	//纬度
	private String latitude;	
	//设备类型
	private String deviceType;

	//设备编码
	private String deviceNo;
	
	//设备名称
	private String deviceName;

	//端口ID
	private String portId;

	//端口编码
	private String portNo;
	
	//端口操作
	private String portOpr;

	//端口RFID
	private String portRfid;

	//端口上光纤的RFID
	private String jointRfid;
	
	//端口架
	private String shelfLocation;
	
	//端口框
	private String frameLocation;

	//端口槽
	private String slotLocation;
	
	//端口
	private String portLocation;
	
	private boolean isInPort;

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

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

	public String getPortId() {
		return portId;
	}

	public void setPortId(String portId) {
		this.portId = portId;
	}

	public String getPortNo() {
		return portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}

	public String getPortRfid() {
		return portRfid;
	}

	public void setPortRfid(String portRfid) {
		this.portRfid = portRfid;
	}

	public String getJointRfid() {
		return jointRfid;
	}

	public void setJointRfid(String jointRfid) {
		this.jointRfid = jointRfid;
	}

	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	public String getFrameLocation() {
		return frameLocation;
	}

	public void setFrameLocation(String frameLocation) {
		this.frameLocation = frameLocation;
	}

	public String getSlotLocation() {
		return slotLocation;
	}

	public void setSlotLocation(String slotLocation) {
		this.slotLocation = slotLocation;
	}

	public String getPortLocation() {
		return portLocation;
	}

	public void setPortLocation(String portLocation) {
		this.portLocation = portLocation;
	}

	public String getPortOpr() {
		return portOpr;
	}

	public void setPortOpr(String portOpr) {
		this.portOpr = portOpr;
	}

	public String getGlNo() {
		return glNo;
	}

	public void setGlNo(String glNo) {
		this.glNo = glNo;
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

	public boolean isInPort() {
		return isInPort;
	}

	public void setInPort(boolean isInPort) {
		this.isInPort = isInPort;
	}
	
	
}
