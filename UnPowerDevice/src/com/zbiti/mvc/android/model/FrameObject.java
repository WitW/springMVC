package com.zbiti.mvc.android.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 列框类
 * @author zhaoqi
 *
 */
public class FrameObject {
	private String name;	//列框编码
	
	private String seq;		//列框在父级设备中的序号
	
	private LinkedList<SlotObject> slots;	//模块

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

	public LinkedList<SlotObject> getSlots() {
		return slots;
	}

	public void setSlots(LinkedList<SlotObject> slots) {
		this.slots = slots;
	}
	
	
}
