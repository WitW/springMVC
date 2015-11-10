package com.zbiti.mvc.android.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 模块类
 * @author zhaoqi
 *
 */
public class SlotObject {
	private String id;		//模块ID
	
	private String name;	//模块名称
	
	private String seq;		//模块在父级设备中的序号
	
	private String rfId;	//模块RFID
	
	private LinkedList<DevicePortInfo> ports;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public LinkedList<DevicePortInfo> getPorts() {
		return ports;
	}

	public void setPorts(LinkedList<DevicePortInfo> ports) {
		this.ports = ports;
	}

	public String getRfId() {
		return rfId;
	}

	public void setRfId(String rfId) {
		this.rfId = rfId;
	}
	
	
}
