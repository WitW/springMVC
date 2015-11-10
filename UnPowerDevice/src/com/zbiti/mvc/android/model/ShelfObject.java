package com.zbiti.mvc.android.model;

import java.util.List;

/**
 * 架类
 * @author zhaoqi
 *
 */
public class ShelfObject {
	private String name;	//架编码
	
	private String seq ;	//架在父级设备中的序号
	
	private List<FrameObject> frames;	//列框

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

	public List<FrameObject> getFrames() {
		return frames;
	}

	public void setFrames(List<FrameObject> frames) {
		this.frames = frames;
	}
	
	
}
