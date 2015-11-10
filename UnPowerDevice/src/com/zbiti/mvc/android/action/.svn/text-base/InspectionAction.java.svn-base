package com.zbiti.mvc.android.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.BatchBandInfo;
import com.zbiti.mvc.android.model.Check_result;
import com.zbiti.mvc.android.model.ShelfObject;
import com.zbiti.mvc.android.service.InspectionResultService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

@Controller
@SuppressWarnings("all")
@RequestMapping("/inspection")
public class InspectionAction {

	protected final Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private InspectionResultService inspectionResultService;

	/**
	 * 保存巡检结果
	 * @param request
	 * @param response
	 */
	@RequestMapping("/saveCheckResultInfo")
	public void deviceCheckResultInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String param = Util.getParam(request);
		logger.debug(param);
//		 String param =
//		 "{\"relas\":[{\"phy_port_id\":\"19800002188253\",\"new_fiber_rf_id\":\"abc123asdjafjaoijf1232222\",\"old_fiber_rf_id\":\"abc123asdjafjaoijf1234444\"},{\"phy_port_id\":\"19800002188245\",\"new_fiber_rf_id\":\"abc123asdjafjaoijf1230000\",\"old_fiber_rf_id\":\"abc123asdjafjaoijf1233333\"}],\"deviceNo\":\"WJ.TDZT/GJ001\",\"staffId\":\"10000000000005\"}";

		JSONObject jo = JSONObject.fromObject(param);
		BatchBandInfo bbo = (BatchBandInfo) jo.toBean(jo, BatchBandInfo.class);// 将JSON数组转化位对象

		// JSONObject jo = JSONObject.fromObject(param);
		//
		// JSONArray array = jo.getJSONArray("relas");
		//
		// List<CheckPortID_Rfid> list = new ArrayList<CheckPortID_Rfid>();
		//
		// for(int i = 0;i < array.size();i++){
		// JSONObject object_relas = (JSONObject) array.get(i);
		// CheckPortID_Rfid cpir = (CheckPortID_Rfid)
		// object_relas.toBean(object_relas, CheckPortID_Rfid.class);
		// if(cpir != null){
		// list.add(cpir);
		// }
		//
		// }
		//
		// BatchBandInfo bbo = (BatchBandInfo)
		// jo.toBean(jo,BatchBandInfo.class);

		Map result = new HashMap();

		try {
			inspectionResultService.saveCheckInfo(bbo);// 保存巡检结果
			result.put("resultCode", StaticPro.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("resultCode", StaticPro.CODE_SAVE_FAIL);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());
	}



	/**
	 * 进入巡检结果展示页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */

	@RequestMapping("/checkInspection")
	public String inspectionLisrPage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		return "listInspection";
	}

	

	/**
	 * 查询巡检结果
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/inspectionPage")
	public String listInspectionResult(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		Page page = new Page();

		String currentPage = (String) request.getParameter("currentPage");

		// 设置查询的参数
		Map<String, String> map = new HashMap<String, String>();

		if (request.getParameter("deviceNo") != null) {
			map.put("deviceNo", (String) request.getParameter("deviceNo")
					.trim());
			model.put("deviceNo", (String) request.getParameter("deviceNo")
					.trim());
		}

		// 获得查询条件的时间范围
		if (request.getParameter("inspectionTime1") != null
				&& request.getParameter("inspectionTime2") != null) {
			map.put("inspectionTime1", request.getParameter("inspectionTime1")
					.toString());
			model.put("inspectionTime1", request
					.getParameter("inspectionTime1"));
			map.put("inspectionTime2", request.getParameter("inspectionTime2")
					.toString());
			model.put("inspectionTime2", request
					.getParameter("inspectionTime2"));
		}

		// 判断分页参数
		if (request.getParameter("pageNum") != null) {
			String pageNum = (String) request.getParameter("pageNum");
			page.setCurrentPage(Integer.parseInt(pageNum));
		}
		if (request.getParameter("numPerPage") != null) {
			String showCount = (String) request.getParameter("numPerPage");
			page.setShowCount(Integer.parseInt(showCount));
		}

		List<Map<String, String>> inspectionResultInfo = inspectionResultService
				.getInspectionResult(map, page);
		model.put("page", page);
		model.put("inspectionResultInfo", inspectionResultInfo);

		return "listInspectionResult";
	}

	/**
	 * 查看巡检端口结果
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */

	@RequestMapping("/inspectionDetail")
	public String listPortDetailInfo(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		// 设置查询的参数
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> resultMap = new HashMap<String, String>();

		if (request.getParameter("PHY_EQP_ID") != null) {
			map.put("PHY_EQP_ID", (String) request.getParameter("PHY_EQP_ID"));
		}
		String RESULT_ID = (String) request.getParameter("RESULT_ID");
		List<Map<String, String>> result_portID = new ArrayList<Map<String, String>>();// 存放结果表信息
		int temp = 1;

		/* 查询结果表，获得端口ID和巡检结果 */
		if (RESULT_ID != null) {
			resultMap.put("RESULT_ID", RESULT_ID);
			result_portID = inspectionResultService
					.get_portID_result(resultMap);
		}

		String deviceNo = request.getParameter("DEVICENO").toString();

		ShelfObject result = inspectionResultService
				.getPortsInfoByDeviceNo(deviceNo);
		List<List<List<Check_result>>> slot_unit_port_list = new ArrayList<List<List<Check_result>>>();

		for (int i = 0; i < result.getFrames().size(); i++)// 循环列框
		{
			List<List<Check_result>> unit_port_list = new ArrayList<List<Check_result>>();
			for (int m = 0; m < result.getFrames().get(i).getSlots().size(); m++)// 循环模块
			{
				List<Check_result> crlist = new ArrayList<Check_result>();
				for (int n = 0; n < result.getFrames().get(i).getSlots().get(m)
						.getPorts().size(); n++)// 循环每个模块的端口
				{
					Check_result cr = new Check_result();
					cr.setPHY_PORT_ID(result.getFrames().get(i).getSlots()
							.get(m).getPorts().get(n).getPortId());
					for (int k = 0; k < result_portID.size(); k++)// 循环结果表
					{
						if (Util.convertStr(
								result.getFrames().get(i).getSlots().get(m)
										.getPorts().get(n).getPortId()).equals(
								Util.convertStr(result_portID.get(k).get(
										"PHY_PORT_ID")))) {
							cr.setResult_check(Util.convertStr(result_portID
									.get(k).get("CHECK_RESULT")));
						}
					}
					crlist.add(cr);// 将一个模块下的每个端口存在crlist中
				}
				/* 获得一个模块有多少端口，作为端口序号用 */
				if (temp == 1) {
					model.put("size", crlist.size());
					temp = 0;
				}
				unit_port_list.add(crlist);
			}
			slot_unit_port_list.add(unit_port_list);
		}

		model.put("slot_unit_port_list", slot_unit_port_list);

		return "tempResultShow";
	}
	
	
	/**
	 * 分光器展示
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/splitterShow")
	public String splitterShowInfo(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> resultMap = new HashMap<String, String>();

		if (request.getParameter("PHY_EQP_ID") != null) {
			map.put("PHY_EQP_ID", (String) request.getParameter("PHY_EQP_ID"));
		}
		String RESULT_ID = (String) request.getParameter("RESULT_ID");

		List<Map<String, String>> splitterPortInfo = inspectionResultService
				.getSplitterPortID(map);// 查询分光器下面的out端口信息
		

		List<Map<String, String>> splitterInPortInfo = inspectionResultService
				.getSplitterInPortID(map);// 分光器的IN端口信息  PHY_PORT_ID=11116014

		List<Map<String, String>> result_portID = new ArrayList<Map<String, String>>();// 存放结果表信息

		/* 查询结果表，获得端口ID和巡检结果 */
		if (RESULT_ID != null) {
			resultMap.put("RESULT_ID", RESULT_ID);
			result_portID = inspectionResultService
					.get_portID_result(resultMap);
		}


		/* 查看IN端口的巡检结果 */
		List<Check_result> inPortCheckResultInfo = new ArrayList<Check_result>();
		for (int m = 0; m < splitterInPortInfo.size(); m++) {
			Check_result incr = new Check_result();
			incr.setPHY_PORT_ID(Util.convertStr(splitterInPortInfo.get(m).get(
					"PHY_PORT_ID")));
			for (int n = 0; n < result_portID.size(); n++) {
				if (Util.convertStr(
						splitterInPortInfo.get(m).get("PHY_PORT_ID")).equals(
								Util.convertStr(result_portID.get(n).get("PHY_PORT_ID")))) {
					incr.setResult_check(Util.convertStr(result_portID.get(n)
							.get("CHECK_RESULT")));
					break;
				}
			}
			inPortCheckResultInfo.add(incr);
		}

		System.out.println(inPortCheckResultInfo.get(0).getResult_check()+ "   .............");
		
		/* 查看OUT端口的巡检情况 */
		List<Check_result> outPortCheckResultInfo = new ArrayList<Check_result>();
		for (int k = 0; k < splitterPortInfo.size(); k++) {
			Check_result out_cr = new Check_result();
			out_cr.setPHY_PORT_ID(Util.convertStr(splitterPortInfo.get(k).get(
					"PHY_PORT_ID")));

			for (int l = 0; l < result_portID.size(); l++) {
				if (Util.convertStr(splitterPortInfo.get(k).get("PHY_PORT_ID"))
						.equals(Util.convertStr(result_portID.get(l).get(
								"PHY_PORT_ID")))) {
					out_cr.setResult_check(Util.convertStr(result_portID.get(l)
							.get("CHECK_RESULT")));
				}
			}
			outPortCheckResultInfo.add(out_cr);
		}

		model.put("inPortCheckResultInfo", inPortCheckResultInfo);// IN端口信息

		List<Check_result> _outPortCheckResultInfo = new ArrayList<Check_result>();
		List<List<Check_result>> list_outPortCheckResultInfo = new ArrayList<List<Check_result>>();

		for (int h = 0; h < outPortCheckResultInfo.size(); h++) {
			_outPortCheckResultInfo.add(outPortCheckResultInfo.get(h));
			if ((h + 1) % 16 == 0) {
				list_outPortCheckResultInfo.add(_outPortCheckResultInfo);
				_outPortCheckResultInfo = new ArrayList<Check_result>();
			}
		}

		model.put("_outPortCheckResultInfo", _outPortCheckResultInfo);
		model.put("size", list_outPortCheckResultInfo.size());
		model.put("list_outPortCheckResultInfo", list_outPortCheckResultInfo);

		return "showSplitterInfo";
	}
	
	// /**
		// * 查看巡检端口结果
		// *
		// * @param request
		// * @param response
		// * @param model
		// * @return
		// */
		//
		//
		// @RequestMapping("/inspectionDetail")
		// public String listPortDetailInfo(HttpServletRequest request,
		// HttpServletResponse response, ModelMap model) {
		// // 设置查询的参数
		// Map<String, String> map = new HashMap<String, String>();
		// Map<String, String> unit_id = new HashMap<String, String>();
		// Map<String, String> umap = new HashMap<String, String>();
		// Map<String, String> portMap = new HashMap<String, String>();
		// Map<String, String> resultMap = new HashMap<String, String>();
		//
		// Date data = new Date();
		//
		// if (request.getParameter("PHY_EQP_ID") != null) {
		// map.put("PHY_EQP_ID", (String) request.getParameter("PHY_EQP_ID"));
		// }
		// String RESULT_ID = (String) request.getParameter("RESULT_ID");
		//
		// List<Map<String, String>> framel_list = inspectionResultService
		// .getFramelUnitId(map);// 根据设备编码查询有多少架
		// List<Map<String, String>> slot_list = null;// 存储框的UNIT_ID
		// List<Map<String, String>> unit_list = null;// 存储模块的UNIT_ID
		// List<Map<String, String>> port_list = null;// 存储端口信息
		//
		// int temp = 1;
		// List<Map<String, String>> result_portID = new ArrayList<Map<String,
		// String>>();// 存放结果表信息
		//
		// /* 查询结果表，获得端口ID和巡检结果 */
		// if (RESULT_ID != null) {
		// resultMap.put("RESULT_ID", RESULT_ID);
		// result_portID = inspectionResultService
		// .get_portID_result(resultMap);
		// }
		//
		//
		// List<List<List<List<Check_result>>>> framel_slot_unit_port_list = new
		// ArrayList<List<List<List<Check_result>>>>();
		//
		// /* 遍历所有的架，查询对应架下面的框的UNIT_ID */
		// for (int i = 0; i < framel_list.size(); i++) {
		//
		// List<List<List<Check_result>>> slot_unit_port_list = new
		// ArrayList<List<List<Check_result>>>();
		//
		// if (Util.convertStr(framel_list.get(i).get("UNIT_ID")) != null) {
		// unit_id.put("slot_id",
		// Util.convertStr(framel_list.get(i).get("UNIT_ID")));
		// slot_list = inspectionResultService.getSlotUnitID(unit_id);// 查询所有框的ID
		//
		// /* 遍历框，查询对应框下的模块UNIT_ID */
		// for (int j = i; j < slot_list.size(); j++) {
		//
		// List<List<Check_result>> unit_port_list = new
		// ArrayList<List<Check_result>>();
		//
		// if (Util.convertStr(slot_list.get(j).get("UNIT_ID")) != null
		// && Util.convertStr(slot_list.get(j).get(
		// "PHY_EQP_ID")) != null) {
		// umap.put("unit_id", Util.convertStr(slot_list.get(j)
		// .get("UNIT_ID")));
		// umap.put(
		// "phy_eqp_id",
		// Util.convertStr(slot_list.get(j).get(
		// "PHY_EQP_ID")));
		// unit_list = inspectionResultService.getUnitId(umap);
		//
		// /* 遍历所有的模块，查询对应模块下的所有端口 */
		// for (int m = 0; m < unit_list.size(); m++) {
		//
		// if (Util.convertStr(unit_list.get(i).get("UNIT_ID")) != null) {
		// portMap.put(
		// "UNIT_ID",
		// Util.convertStr(unit_list.get(m).get(
		// "UNIT_ID")));
		// port_list = inspectionResultService
		// .getAllPortID(portMap);
		//
		//
		// List<Check_result> crlist = new ArrayList<Check_result>();
		//
		//
		// /* 循环每个模块下所有的端口 */
		// for (int q = 0; q < port_list.size(); q++) {
		// // System.out.println(port_list.size());
		// Check_result cr = new Check_result();
		// cr.setPHY_PORT_ID(Util.convertStr(port_list
		// .get(q).get("PHY_PORT_ID")));
		//
		// /* 循环结果表端口，将端口与巡检结果表的端口进行比较 */
		// for (int r = 0; r < result_portID.size(); r++) {
		// if (Util.convertStr(
		// port_list.get(q).get(
		// "PHY_PORT_ID"))
		// .equals(Util
		// .convertStr(result_portID
		// .get(r)
		// .get("PHY_PORT_ID")))) {
		// cr.setResult_check(Util
		// .convertStr(result_portID
		// .get(r)
		// .get("CHECK_RESULT")));
		// }
		// }
		// crlist.add(cr);// 将一个模块下的每个端口存在crlist中
		// }
		//
		// /*获得一个模块有多少端口，作为端口序号用*/
		// if (temp == 1) {
		// model.put("size", crlist.size());
		// temp = 0;
		// }
		// unit_port_list.add(crlist);
		// }
		// }
		// }
		// slot_unit_port_list.add(unit_port_list);
		// }
		// }
		// framel_slot_unit_port_list.add(slot_unit_port_list);
		// }
		//
		// model.put("framel_slot_unit_port_list", framel_slot_unit_port_list);
		//
		// System.out.println("开始时间："+data +"       "+"结束时间:"+new Date());
		// return "tempResultShow";
		// }

}
