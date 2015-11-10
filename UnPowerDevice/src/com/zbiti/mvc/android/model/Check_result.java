package com.zbiti.mvc.android.model;

public class Check_result {
	
	private String PHY_PORT_ID;//端口ID
	
	private String result_check = "0";//巡检结果，默认0:闲置状态

	public String getPHY_PORT_ID() {
		return PHY_PORT_ID;
	}

	public void setPHY_PORT_ID(String pHY_PORT_ID) {
		PHY_PORT_ID = pHY_PORT_ID;
	}

	public String getResult_check() {
		return result_check;
	}

	public void setResult_check(String result_check) {
		this.result_check = result_check;
	}
	
	
}
