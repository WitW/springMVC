package com.zbiti.mvc.android.model;

public class ResultCheckInfo {
	
	private String phy_port_id;//端口ID
	
	private String oss_rf_id;//系统资源里面的rf_id
	
	private String new_rf_id;//扫描传过来的rf_id
	
	private String check_result;//扫描结果
	
	private int result_id;//巡检ID

	public String getPhy_port_id() {
		return phy_port_id;
	}

	public void setPhy_port_id(String phy_port_id) {
		this.phy_port_id = phy_port_id;
	}

	public String getOss_rf_id() {
		return oss_rf_id;
	}

	public void setOss_rf_id(String oss_rf_id) {
		this.oss_rf_id = oss_rf_id;
	}

	public String getNew_rf_id() {
		return new_rf_id;
	}

	public void setNew_rf_id(String new_rf_id) {
		this.new_rf_id = new_rf_id;
	}

	public String getCheck_result() {
		return check_result;
	}

	public void setCheck_result(String check_result) {
		this.check_result = check_result;
	}

	public int getResult_id() {
		return result_id;
	}

	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}


	
	
	
	
}
