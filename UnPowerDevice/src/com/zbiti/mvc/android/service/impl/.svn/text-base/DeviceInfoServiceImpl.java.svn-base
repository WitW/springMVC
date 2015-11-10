package com.zbiti.mvc.android.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.DevicePortDao;
import com.zbiti.mvc.android.model.BatchBandObject;
import com.zbiti.mvc.android.model.DevicePortInfo;
import com.zbiti.mvc.android.model.FrameObject;
import com.zbiti.mvc.android.model.PortRfidInfo;
import com.zbiti.mvc.android.model.ShelfObject;
import com.zbiti.mvc.android.model.SlotObject;
import com.zbiti.mvc.android.model.WorkOrderSaveInfo;
import com.zbiti.mvc.android.model.WorkOrderSaveInfoList;
import com.zbiti.mvc.android.service.DeviceInfoService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {
	@Autowired
	@Qualifier("DevicePortDao")
	private DevicePortDao devicePortDaoImpl;

	public DevicePortInfo getPortInfoByDeviceNoAndPortNo(String deviceNo,
			String portNo) {
		DevicePortInfo port = devicePortDaoImpl.getPortInfoByDeviceNoAndPortNo(
				deviceNo, portNo);
		return port;
	}

	public String getPortLocationByPortId(String portId) {
		DevicePortInfo port = devicePortDaoImpl.getPortLocationByPortId(portId);
		if (port != null) {
			return port.getShelfLocation() + "架" + port.getFrameLocation()
					+ "框第" + port.getSlotLocation() + "槽第"
					+ port.getPortLocation() + "端口";
		} else {
			return null;
		}
	}

	public String getPortRfIdByPortId(String portId) {
		DevicePortInfo port = devicePortDaoImpl.getPortRfIdByPortId(portId);
		if (port != null) {
			return port.getPortRfid();
		} else {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public void saveDeviceFiberRfIdList(WorkOrderSaveInfoList workOrderSaveInfoList) throws Exception {
//		String staffId = workOrderSaveInfoList.getStaffId();
//		String area = workOrderSaveInfoList.getArea();
		List<WorkOrderSaveInfo> workOrderSaveInfo = workOrderSaveInfoList.getWorkOrderSaveInfo();//获取所有工单信息
		
		JSONArray jsonArray = JSONArray.fromObject(workOrderSaveInfo);//将工单列表转化为JSON数组
		
		//循环JSON数组，获取相关信息
		for(int i = 0;i < jsonArray.size();i++){
			JSONObject jo = JSONObject.fromObject(jsonArray.get(i));//将JSON数组转化为JSON对象
			String staffId = (String) jo.get("staffId");
			String orderId = (String) jo.get("orderId");
			String orderEvent = (String) jo.get("orderEvent");
			
		
			List<PortRfidInfo> rfs = (List<PortRfidInfo>) jo.get("ports");
			JSONArray portsArray = JSONArray.fromObject(rfs);
			System.out.println(portsArray.size());
			for (int j = 0;j < portsArray.size();j++) {

				JSONObject json = (JSONObject) portsArray.get(j);
				
				String staffID = (String) json.get("staffId"); //操作人
				String area = (String) json.get("area");	//地区
			    String device_id = (String) json.get("device_id");	//操作设备ID
				String phy_port_id = (String) json.get("phy_port_id");		//操作端口ID
				String phy_port_opr = (String) json.get("phy_port_opr");	//操作类型（绑定/解绑）
				String new_port_rf_id = (String) json.get("new_port_rf_id");	//新端口RFID
				String old_port_rf_id = (String) json.get("old_port_rf_id");	//旧端口RFID
				String new_fiber_rf_id = (String) json.get("new_fiber_rf_id");	//新光纤接头RFID
				String old_fiber_rf_id = (String) json.get("old_fiber_rf_id");	//新光纤接头RFID
				String notes = (String) json.get("notes");			//备注
				
				PortRfidInfo ri =  new PortRfidInfo();
				ri.setStaffId(staffID);
				ri.setArea(area);
				ri.setDevice_id(device_id);
				ri.setPhy_port_id(phy_port_id);
				ri.setPhy_port_opr(phy_port_opr);
				ri.setNew_fiber_rf_id(new_fiber_rf_id);
				ri.setNew_port_rf_id(new_port_rf_id);
				ri.setOld_fiber_rf_id(old_fiber_rf_id);
				ri.setOld_port_rf_id(old_port_rf_id);
				ri.setNotes(notes);
				
				// 保存映射关系
				if (ri.getNew_fiber_rf_id() != null
						//&& !StaticPro.STR_RFID_NONE.equals(ri.getNew_fiber_rf_id())
						&& (StaticPro.STR_BANDING.equals(ri.getPhy_port_opr()) || StaticPro.STR_UNBANDING
								.equals(ri.getPhy_port_opr()))) {
					devicePortDaoImpl.saveFiberRfId(ri);
					// 保存日志
					devicePortDaoImpl.saveRfIdLog(staffId, orderId, orderEvent, ri);
				}
				if(StaticPro.STR_UNBANDING.equals(ri.getPhy_port_opr())){
					devicePortDaoImpl.deleteFiberRfId(ri);
					// 保存日志
					devicePortDaoImpl.saveRfIdLog(staffId, orderId, orderEvent, ri);
				}
			}
			
			
		}
		
		
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveDeviceFiberRfId(WorkOrderSaveInfo ports) throws Exception {
		String staffId = ports.getStaffId();
		String orderId = ports.getOrderId();
		String orderEvent = ports.getEvent();
		List<PortRfidInfo> rfs = ports.getPorts();
		for (PortRfidInfo ri : rfs) {
			// 保存映射关系
			if (ri.getNew_fiber_rf_id() != null
					//&& !StaticPro.STR_RFID_NONE.equals(ri.getNew_fiber_rf_id())
					&& (StaticPro.STR_BANDING.equals(ri.getPhy_port_opr()) || StaticPro.STR_UNBANDING
							.equals(ri.getPhy_port_opr()))) {
				devicePortDaoImpl.saveFiberRfId(ri);
				// 保存日志
				devicePortDaoImpl.saveRfIdLog(staffId, orderId, orderEvent, ri);
			}
			if(StaticPro.STR_UNBANDING.equals(ri.getPhy_port_opr())){
				devicePortDaoImpl.deleteFiberRfId(ri);
				// 保存日志
				devicePortDaoImpl.saveRfIdLog(staffId, orderId, orderEvent, ri);
			}
		}
	}
//
//	public boolean checkLockRfid(String staffId, String rfId) {
//		List result = devicePortDaoImpl.checkLockRfid(staffId, rfId);
//		if (result == null || result.size() == 0) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//
//	public void saveLockLog(String staffId, String rfId, String opr) {
//		devicePortDaoImpl.saveLockLog(staffId, rfId, opr);
//
//	}
    //架-列框-模块-端口
	@SuppressWarnings("all")
	public ShelfObject getPortsInfoByDeviceNo(String deviceNo,String deviceRfid) {
		//获取设备下所有端口信息
		List<Map> result = devicePortDaoImpl.getPortsInfoByDeviceNo(deviceNo,deviceRfid);
		//模块
		Map<String, SlotObject> slotList = new LinkedHashMap<String, SlotObject>();
		//列框
		Map<String, FrameObject> frameList = new LinkedHashMap<String, FrameObject>();
		//架
		ShelfObject shelf = new ShelfObject();
		for (Map m : result) {
			DevicePortInfo dpi = new DevicePortInfo();
			dpi.setDeviceId(Util.convertStr(m.get("PHY_EQP_ID")));
			dpi.setDeviceNo(Util.convertStr(m.get("PHY_EQP_NO")));
			dpi.setDeviceName(Util.convertStr(m.get("PHY_EQP_NAME")));
			dpi.setDeviceType(Util.convertStr(m.get("PHY_EQP_SPEC")));
			dpi.setGlNo(Util.convertStr(m.get("GL_NO")));
			dpi.setPortId(Util.convertStr(m.get("PHY_PORT_ID")));
			dpi.setPortNo(Util.convertStr(m.get("PHY_PORT_NO")));
			dpi.setPortRfid(Util.convertStr(m.get("PHY_PORT_RFID")));
			dpi.setPortLocation(Util.convertStr(m.get("PHY_PORT_SEQ")));
			dpi.setJointRfid(Util.convertStr(m.get("PHY_FIBER_RFID")));
			dpi.setSlotLocation(Util.convertStr(m.get("SLOT_SEQ")));
			dpi.setFrameLocation(Util.convertStr(m.get("FRAME_SEQ")));
			dpi.setShelfLocation(Util.convertStr(m.get("SHELF_SEQ")));
			
			if(Util.convertStr(m.get("RES_SPEC_ID")).equals("1131")){
				dpi.setInPort(true);
			}
			
			Set keys = slotList.keySet();
			if (!keys.contains(Util.convertStr(m.get("SLOT_NO")))) {
				// 如果slotList中不存在这个模块号，则加入
				SlotObject so = new SlotObject();
				so.setId(Util.convertStr(m.get("SLOT_ID")));
				so.setName(Util.convertStr(m.get("SLOT_NO")));
				so.setSeq(Util.convertStr(m.get("SLOT_SEQ")));
				so.setRfId(Util.convertStr(m.get("SLOT_RFID")));
				so.setPorts(new LinkedList<DevicePortInfo>());
				so.getPorts().add(dpi);
				slotList.put(Util.convertStr(m.get("SLOT_NO")), so);
			} else {
				slotList.get(Util.convertStr(m.get("SLOT_NO"))).getPorts().add(
						dpi);
			}
		}
		// 遍历模块Map添加进对应的列框
		Set keys = slotList.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String slot_no = it.next();
			for (Map m : result) {
				if (slot_no.equals(Util.convertStr(m.get("SLOT_NO")))) {
					String frame_no = Util.convertStr(m.get("FRAME_NO"));
					String frame_seq = Util.convertStr(m.get("FRAME_SEQ"));
					Set frame_keys = frameList.keySet();
					if (!frame_keys.contains(frame_no)) {
						FrameObject fo = new FrameObject();
						fo.setName(frame_no);
						fo.setSeq(frame_seq);
						fo.setSlots(new LinkedList<SlotObject>());
						fo.getSlots().add(slotList.get(slot_no));
						frameList.put(Util.convertStr(m.get("FRAME_NO")), fo);
					} else {
						frameList.get(frame_no).getSlots().add(
								slotList.get(slot_no));
					}
					break;
				}
			}
		}

		// 遍历列框Map添加进架
		Set frame_key = frameList.keySet();
		Iterator<String> frame_it = frame_key.iterator();
		while (frame_it.hasNext()) {
			String frame_no = frame_it.next();
			for (Map m : result) {
				if (frame_no.equals(Util.convertStr(m.get("FRAME_NO")))) {
					String shelf_no = Util.convertStr(m.get("SHELF_NO"));
					String shelf_seq = Util.convertStr(m.get("SHELF_SEQ"));
					shelf.setName(shelf_no);
					shelf.setSeq(shelf_seq);
					if (shelf.getFrames() == null) {
						shelf.setFrames(new LinkedList<FrameObject>());
					}
					shelf.getFrames().add(frameList.get(frame_no));
					break;
				}
			}
		}
		return shelf;
	}

	public DevicePortInfo getPortInfoByFiberRfId(String fiberRfid) {
		return devicePortDaoImpl.getPortInfoByFiberRfId(fiberRfid);
	}

	public String getOtherPortByPortId(String portId) {
		return devicePortDaoImpl.getOtherPortByPortId(portId);
	}

	public DevicePortInfo getPortInfoByFiberPortId(String portId) {
		return devicePortDaoImpl.getPortInfoByFiberPortId(portId);
	}

	public Map getGlInfoByPorts(String otherPortId, String portId) {
		return devicePortDaoImpl.getGlInfoByPorts(otherPortId, portId);
	}

	@Transactional(rollbackFor = Exception.class)
	public void batchBand(BatchBandObject bbo) throws Exception {
		// 根据批量绑定对象bbo获取 对应关系 Map<端口ID,RFID>
		Map<String, String> relas = bbo.getRelas();
		String staffId = bbo.getStaffId();
		String area = bbo.getArea();
		//端口/插头
		String obj = bbo.getObj();
		//绑定/解绑/巡检
		String opr = bbo.getOpr();
		
		//设备RFID
		String deviceRfid = bbo.getDeviceRfid();
		//设备ID
		String deviceId = bbo.getDeviceId();

		Set<String> s = relas.keySet();
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			String portId = it.next();
			//端口RFID 信息
			PortRfidInfo ri = new PortRfidInfo();
			ri.setStaffId(staffId);
			ri.setArea(area);
			ri.setPhy_port_opr(obj + opr);
			ri.setPhy_port_id(portId);
			if (StaticPro.OBJ_PORT.equals(obj)) {
				// 操作对象：端口
				if (relas.get(portId) != null && !"".equals(relas.get(portId))
						&& (StaticPro.STR_BANDING.equals(opr))
						) {
						//&& !StaticPro.STR_RFID_NONE.equals(relas.get(portId))) {//测试空白的覆盖功能
					//ri.setNew_fiber_rf_id(relas.get(portId));
					ri.setNew_port_rf_id(relas.get(portId).equals(StaticPro.STR_RFID_NONE) ? "" : relas.get(portId));
					// 绑定操作
					devicePortDaoImpl.savePortRfId(ri);
					// 保存日志
					devicePortDaoImpl.saveRfIdLog(staffId,
							StaticPro.STR_BATCH_ORDER_ID,
							StaticPro.STR_BATCH_BAND, ri);
					
				}
				if (relas.get(portId) != null && !"".equals(relas.get(portId))
						&& (StaticPro.STR_UNBANDING.equals(opr))) {
					ri.setOld_port_rf_id(relas.get(portId));
					// 解绑操作
					devicePortDaoImpl.deletePortRfId(ri);
					// 保存日志
					devicePortDaoImpl.saveRfIdLog(staffId,
							StaticPro.STR_BATCH_ORDER_ID,
							StaticPro.STR_BATCH_UNBAND, ri);
				}

			}
			if (StaticPro.OBJ_FIBER.equals(obj)) {
				// 操作对象：光纤插头
				if (relas.get(portId) != null && !"".equals(relas.get(portId))
						&& (StaticPro.STR_BANDING.equals(opr))
				) {
						//&& !StaticPro.STR_RFID_NONE.equals(relas.get(portId))) { //测试空白的覆盖功能
					//ri.setNew_fiber_rf_id(relas.get(portId));
					ri.setNew_fiber_rf_id(relas.get(portId).equals(StaticPro.STR_RFID_NONE) ? "" : relas.get(portId));
					devicePortDaoImpl.saveFiberRfId(ri);
					// 保存日志
					devicePortDaoImpl.saveRfIdLog(staffId,
							StaticPro.STR_BATCH_ORDER_ID,
							StaticPro.STR_BATCH_BAND, ri);
				}

				if (relas.get(portId) != null && !"".equals(relas.get(portId))
						&& (StaticPro.STR_UNBANDING.equals(opr))) {
					ri.setOld_fiber_rf_id(relas.get(portId));
					// 解绑操作
					devicePortDaoImpl.deleteFiberRfId(ri);
					// 保存日志
					devicePortDaoImpl.saveRfIdLog(staffId,
							StaticPro.STR_BATCH_ORDER_ID,
							StaticPro.STR_BATCH_UNBAND, ri);
				}
			}

		}
		

		//模块操作
		//根据批量绑定对象bbo获取模块RFID
		Map<String, String> solts = bbo.getRelasS();
		if(solts != null){
			for(Map.Entry<String, String> m:solts.entrySet()){
				
				Map<String, String> map=new HashMap<String,String>();
				
				map.put("OBJ_ID",m.getKey());
				map.put("AREA_ID",area);
				map.put("VALUE", m.getValue());
				map.put("STAFF_NBR", staffId);
				map.put("PROP_SPEC_ID", StaticPro.PROP_SPEC_ID_SLOT);
				
				
				Map<String, String> logs=new HashMap<String,String>();

				logs.put("staffId", staffId);
				logs.put("orderId", StaticPro.STR_BATCH_ORDER_ID);
				
				logs.put("device_id", deviceId);
				logs.put("phy_port_id", m.getKey());
				
				logs.put("phy_port_opr", StaticPro.OBJ_SLOT+opr);
				logs.put("new_fiber_rf_id", m.getValue());
				logs.put("old_fiber_rf_id", m.getValue());
				
				
				//绑定操作
				if (StaticPro.OBJ_PORT.equals(obj) && (StaticPro.STR_BANDING.equals(opr)) && !StaticPro.STR_RFID_NONE.equals(m.getKey())){
					logs.put("orderEvent", StaticPro.STR_BATCH_BAND);
					devicePortDaoImpl.saveSlotRfid(map);
					devicePortDaoImpl.saveMaplog(logs);
				}
				// 解绑操作
				if(StaticPro.OBJ_PORT.equals(obj) && (StaticPro.STR_UNBANDING.equals(opr)) && !StaticPro.STR_RFID_NONE.equals(m.getKey())){
					logs.put("orderEvent", StaticPro.STR_BATCH_UNBAND);
					devicePortDaoImpl.deleteSlotRfid(map);
					devicePortDaoImpl.saveMaplog(logs);
					
				}
			}
		}
		
		Map<String, String> devs=new HashMap<String,String>();
		
		devs.put("OBJ_ID",deviceId);
		devs.put("AREA_ID",area);
		devs.put("VALUE", deviceRfid);
		devs.put("STAFF_NBR", staffId);
		devs.put("PROP_SPEC_ID", StaticPro.PROP_SPEC_ID_DEV);
		
		Map<String, String> devLogs=new HashMap<String,String>();
		
		devLogs.put("staffId", staffId);
		devLogs.put("orderId", StaticPro.STR_BATCH_ORDER_ID);
		devLogs.put("orderEvent", StaticPro.STR_BATCH_BAND);
		devLogs.put("device_id", deviceId);
		devLogs.put("phy_port_id",deviceId);
		devLogs.put("phy_port_opr", StaticPro.OBJ_DEVICE+opr);
		devLogs.put("new_fiber_rf_id", deviceRfid);
		devLogs.put("old_fiber_rf_id", deviceRfid);
		
		//设备绑定操作
		if (StaticPro.OBJ_PORT.equals(obj) && (StaticPro.STR_BANDING.equals(opr)) && !StaticPro.STR_RFID_NONE.equals(deviceRfid)){
			devicePortDaoImpl.saveSlotRfid(devs);
			devicePortDaoImpl.saveMaplog(devLogs);
		}
		// 解绑操作
		if(StaticPro.OBJ_PORT.equals(obj) && (StaticPro.STR_UNBANDING.equals(opr)) && !StaticPro.STR_RFID_NONE.equals(deviceRfid)){
			
			devLogs.put("orderEvent", StaticPro.STR_BATCH_UNBAND);
			devicePortDaoImpl.deleteSlotRfid(devs);
			devicePortDaoImpl.saveMaplog(devLogs);
			
		}
		
		
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveCheckResult(BatchBandObject bbo) throws Exception {
		// 对应关系 Map<端口ID,RFID>
		Map<String, String> relas = bbo.getRelas();
		String staffId = bbo.getStaffId();
		String area = bbo.getArea();
		String obj = bbo.getObj();//端口/插头
		String opr = bbo.getOpr();//绑定/解绑/巡检

		//判断是否为 “巡检” 
		if ((StaticPro.STR_CHECK.equals(opr))) {
			Set<String> s = relas.keySet();
			Iterator<String> it = s.iterator();
			while (it.hasNext()) {
				String portId = it.next();
				//端口RFID 信息
				PortRfidInfo ri = new PortRfidInfo();
				ri.setStaffId(staffId);
				ri.setArea(area);
				ri.setPhy_port_opr(obj + opr);
				ri.setPhy_port_id(portId);
				//端口的RFID存在
				if (relas.get(portId) != null && !"".equals(relas.get(portId))) {
					ri.setNew_fiber_rf_id(relas.get(portId));
					//保存巡检结果
					devicePortDaoImpl.saveCheckResult(ri);

				}

			}
		}
	}

	public String getDevsPortCount(String deviceNo, String portNo) {
		
		return devicePortDaoImpl.getDevsPortCount(deviceNo, portNo);
	}

	public List<Map<String, String>> listDevsInfoByArea(String staffId) {
		
		return devicePortDaoImpl.listDevsInfoByArea(staffId);
	}

	public List<DevicePortInfo> getDeviceInfolistPage(Map<String, String> map,
			Page page) {
		
		return devicePortDaoImpl.getDeviceInfolistPage(map, page);
	}

	public List<Map<String, String>> getDevPosition(String deviceNo) {
		
		return devicePortDaoImpl.getDevPosition(deviceNo);
	}

	public void insertDevPosition(Map<String, String> map) {
		
		devicePortDaoImpl.insertDevPosition(map);
	}

	public String getDeviceCount(String deviceNo) {
		
		return devicePortDaoImpl.getDeviceCount(deviceNo);
	}

	
}
