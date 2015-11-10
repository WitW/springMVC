package com.zbiti.mvc.android.model;

public class CheckPortID_Rfid {
	
	private String phy_port_id;//端口ID
	
	private String new_fiber_rf_id;	//新插头RFID
	
	private String old_fiber_rf_id;	//旧插头RFID

	public String getPhy_port_id() {
		return phy_port_id;
	}

	public void setPhy_port_id(String phy_port_id) {
		this.phy_port_id = phy_port_id;
	}

	public String getNew_fiber_rf_id() {
		return new_fiber_rf_id;
	}

	public void setNew_fiber_rf_id(String new_fiber_rf_id) {
		this.new_fiber_rf_id = new_fiber_rf_id;
	}

	public String getOld_fiber_rf_id() {
		return old_fiber_rf_id;
	}

	public void setOld_fiber_rf_id(String old_fiber_rf_id) {
		this.old_fiber_rf_id = old_fiber_rf_id;
	}

}
