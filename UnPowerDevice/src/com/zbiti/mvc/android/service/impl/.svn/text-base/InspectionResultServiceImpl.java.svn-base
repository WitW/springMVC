package com.zbiti.mvc.android.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.InspectionResultDao;
import com.zbiti.mvc.android.model.BatchBandInfo;
import com.zbiti.mvc.android.model.CheckDeviceInfo;
import com.zbiti.mvc.android.model.CheckPortID_Rfid;
import com.zbiti.mvc.android.model.DevicePortInfo;
import com.zbiti.mvc.android.model.FrameObject;
import com.zbiti.mvc.android.model.ResultCheckInfo;
import com.zbiti.mvc.android.model.ShelfObject;
import com.zbiti.mvc.android.model.SlotObject;
import com.zbiti.mvc.android.service.InspectionResultService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

@Service
@SuppressWarnings("all")
public class InspectionResultServiceImpl implements InspectionResultService {

	@Autowired
	private InspectionResultDao inspectionResultDao;

	public List<Map<String, String>> getInspectionResult(
			Map<String, String> map, Page page) {
		return inspectionResultDao.getInspectionResult(map, page);
	}

	public List<Map<String, String>> getFramelUnitId(Map<String, String> map) {
		return inspectionResultDao.getFramelUnitId(map);
	}

	public List<Map<String, String>> getSlotUnitID(Map<String, String> unit_id) {
		return inspectionResultDao.getSlotUnitID(unit_id);
	}

	public List<Map<String, String>> getUnitId(Map<String, String> umap) {
		return inspectionResultDao.getUnitId(umap);
	}

	public List<Map<String, String>> getAllPortID(Map<String, String> portMap) {
		return inspectionResultDao.getAllPortID(portMap);
	}

	public List<Map<String, String>> get_portID_result(
			Map<String, String> resultMap) {
		return inspectionResultDao.get_portID_result(resultMap);
	}

	public List<Map<String, String>> getSplitterPortID(Map<String, String> map) {
		return inspectionResultDao.getSplitterPortID(map);
	}

	public List<Map<String, String>> getSplitterInPortID(Map<String, String> map) {
		return inspectionResultDao.getSplitterInPortID(map);
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveCheckInfo(BatchBandInfo bbo) {

		String check_result;// 巡检端口表里面巡检结果

		/* 获得传过来的相关数据 */
		List<CheckPortID_Rfid> relas = bbo.getRelas();
		String staffId = bbo.getStaffId();
		String deviceNO = bbo.getDeviceNo();
		/* 取得服务器的时间 */
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = date.format(new Date()).toString();

		int RESULT_ID = 1 ;// 巡检端信息表里面的ID

		int count = 0;// 不匹配数

		Map<String, String> mapID = inspectionResultDao.get_MAX_RESULT_ID();// 获得巡检信息表里面的最大RESULT_ID
		
		/* 给新插入的巡检信息表里的RESULT_ID赋值 */
		if (mapID != null && mapID.size() != 0 ) {
			RESULT_ID =  Integer.parseInt(Util.convertStr(mapID.get("MAX_RESULT_ID"))) + 1 ;
			System.out.println(RESULT_ID);
		} 

		/* 将端口和插头的相关巡检信息存到巡检详细表里 */
		JSONArray jsonArray = JSONArray.fromObject(relas);// 获得传过来的list
		for (int i = 0; i < jsonArray.size(); i++) {

			JSONObject jo = (JSONObject) jsonArray.get(i);
			String portId = (String) jo.get("phy_port_id");
			String oss_rf_id = (String) jo.get("old_fiber_rf_id");
			String new_rf_id = (String) jo.get("new_fiber_rf_id");

			ResultCheckInfo tempCheckInfo = new ResultCheckInfo();
			tempCheckInfo.setPhy_port_id(portId);
			tempCheckInfo.setResult_id(RESULT_ID);
			tempCheckInfo.setOss_rf_id(oss_rf_id);
			tempCheckInfo.setNew_rf_id(new_rf_id);

			/* 判断端口是否是闲置、占用、匹配和不匹配状态 */
			if ("" .equals(new_rf_id) ) {
				if (oss_rf_id .equals(StaticPro.STR_RFID_NONE)) {
					check_result = "0";// 闲置状态
				} else {
					check_result = "1";// 占用状态
				}
			} else {
				if (oss_rf_id.equals(new_rf_id)) {
					check_result = "2";// 匹配状态
				} else {
					check_result = "3";// 不匹配状态
					count = count + 1;
				}
			}
			tempCheckInfo.setCheck_result(check_result);

			inspectionResultDao.saveResultCheckInfo(tempCheckInfo);
		}

		/* 相关巡检信息存入CHECK_INFO表里 */
		CheckDeviceInfo cdi = new CheckDeviceInfo();
		cdi.setStaffId(staffId);
		cdi.setDeviceNO(deviceNO);
		cdi.setResult_id(RESULT_ID);
		cdi.setCreate_date(create_date);
		cdi.setResult_count(count);
		inspectionResultDao.saveCheckInfo(cdi);

	}

	// 架-列框-模块-端口
	@SuppressWarnings("all")
	public ShelfObject getPortsInfoByDeviceNo(String deviceNo) {
		List<Map> result = inspectionResultDao.selectAllDeviceInfo(deviceNo);
		Map<String, SlotObject> slotList = new LinkedHashMap<String, SlotObject>();
		Map<String, FrameObject> frameList = new LinkedHashMap<String, FrameObject>();
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
				slotList.get(Util.convertStr(m.get("SLOT_NO"))).getPorts()
						.add(dpi);
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
						frameList.get(frame_no).getSlots()
								.add(slotList.get(slot_no));
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

	@Override
	public List<Map<String, String>> getAllInspectionResultlistPage(Page page) {
		return inspectionResultDao.getAllInspectionResultlistPage(page);
	}

}
