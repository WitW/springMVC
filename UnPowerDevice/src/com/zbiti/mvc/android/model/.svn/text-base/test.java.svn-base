package com.zbiti.mvc.android.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zbiti.util.StaticPro;

import net.sf.json.JSONObject;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		WorkOrderSaveInfo I = new WorkOrderSaveInfo();
//		I.setStaffId("zhao");
//		I.setOrderId("192200000041193030");
//		I.setEvent("新装");
//		I.setArea("21");
//		PortRfidInfo ri = new PortRfidInfo();
//		ri.setDevice_id("128795039774");
//		ri.setPhy_port_id("1209785734664");
//		ri.setNew_fiber_rf_id("132029422312");
//		ri.setNotes("测试1");
//		ri.setStaffId("zhao");
//		ri.setPhy_port_opr(StaticPro.STR_BANDING);
//		ri.setArea("21");
//		
//
//		PortRfidInfo ri2 = new PortRfidInfo();
//		ri2.setDevice_id("128795032245");
//		ri2.setPhy_port_id("120978572366");
//		ri2.setNew_fiber_rf_id("132029423123");
//		ri2.setNotes("测试2");
//		ri2.setStaffId("zhao");
//		ri2.setArea("21");
//		ri2.setPhy_port_opr(StaticPro.STR_BANDING);
//		
//
//		PortRfidInfo ri3 = new PortRfidInfo();
//		ri3.setDevice_id("128795034123");
//		ri3.setPhy_port_id("120978575342");
//		ri3.setNew_fiber_rf_id("132029422231");
//		ri3.setNotes("测试3");
//		ri3.setStaffId("zhao");
//		ri3.setArea("21");
//		ri3.setPhy_port_opr(StaticPro.STR_BANDING);
//		List<PortRfidInfo> list = new ArrayList<PortRfidInfo>();
//		list.add(ri);list.add(ri2);list.add(ri3);
//		I.setPorts(list);
		
		BatchBandObject bbo = new BatchBandObject();
		bbo.setArea("70");
		bbo.setStaffId("zhao");
		bbo.setObj("插头");
		bbo.setOpr("巡检");
		HashMap<String, String> m = new HashMap<String, String>();
		for(int i=0 ; i<5;i++){
			m.put("1900312343212"+i, "abc123asdjafjaoijf123"+i+i+i+i);
		}
		bbo.setRelas(m);
		System.out.print(JSONObject.fromObject(bbo).toString());
	}

}
