package com.zbiti.mvc.android.model;

public class SelectOtherReturnObject {
	private String gl_no;
	
	private String address;
	
	private String lnk_state;
	
	private DevicePortInfo curPort ;
	
	private DevicePortInfo otherPort ;

	public String getGl_no() {
		return gl_no;
	}

	public void setGl_no(String glNo) {
		gl_no = glNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLnk_state() {
		return lnk_state;
	}

	public void setLnk_state(String lnkState) {
		lnk_state = lnkState;
	}

	public DevicePortInfo getCurPort() {
		return curPort;
	}

	public void setCurPort(DevicePortInfo curPort) {
		this.curPort = curPort;
	}

	public DevicePortInfo getOtherPort() {
		return otherPort;
	}

	public void setOtherPort(DevicePortInfo otherPort) {
		this.otherPort = otherPort;
	}
	
}
