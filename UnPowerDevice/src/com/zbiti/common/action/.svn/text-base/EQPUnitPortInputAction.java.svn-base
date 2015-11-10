package com.zbiti.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbiti.common.model.DwzReturnObject;
import com.zbiti.common.service.EQPUnitPortInputService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

/**
 * 设备资源录入
 * @author dlt
 *
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/EQPUnitPort")
public class EQPUnitPortInputAction {
	
	@Autowired
	private EQPUnitPortInputService eQPUnitPortInputServiceImpl;
	
	/**
	 * 跳转到新增设备页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/saveEQPUnitPortPage")
	public String saveEQPUnitPortPage(HttpServletRequest request,
			HttpServletResponse response,ModelMap model){
		
		List<Map<String, String>>  list = eQPUnitPortInputServiceImpl.getPrefectureArea();
		
		model.put("areaList", list);
		String parentAreaId = Util.convertStr(list.get(0).get("AREA_ID"));
		List<Map<String, String>>  subArea = eQPUnitPortInputServiceImpl.getAreaByParentId(parentAreaId);
		
		model.put("subArea", subArea);
		return "device/addPhyPage";
	}

	/**
	 * 录入
	 * @param request
	 * @param response
	 */
	@RequestMapping("/saveEQPUnitPortInfo")
	public void saveEQPUnitPortInfo(HttpServletRequest request, HttpServletResponse response){
		
		DwzReturnObject result=null;
		
		//设备名称
		String deviceName = request.getParameter("deviceName");
		
		//设备编码
		String deviceNo = request.getParameter("deviceNo");
		
		//设备类型
		String deviceType = request.getParameter("deviceType");
		
		//设备地址
		String address = request.getParameter("address");
		
		//地区
		String area = request.getParameter("area");
		String parentArea = request.getParameter("parentArea");

		
		Map<String, String> map = new HashMap<String,String>();
		map.put("NAME", deviceName);
		map.put("NO", deviceNo);
		map.put("RES_SPEC_ID", deviceType);
		map.put("AREA_ID", area);
		
		map.put("ADDRESS", address);
		try{
		
		if(deviceType.equals("411")){ //ODF
			map.put("LONG_OR_LOCAL_ID", "80000113");
			map.put("MNT_STYLE_ID", null);
			
			String frameNum = request.getParameter("frameNum");
			String moduleNum = request.getParameter("moduleNum");
			String portNum = request.getParameter("portNum");
			
			eQPUnitPortInputServiceImpl.saveAllEQPUnitInfo(map, Integer.parseInt(frameNum), Integer.parseInt(moduleNum), Integer.parseInt(portNum));
			
		}else if(deviceType.equals("703")){//光交箱
			map.put("LONG_OR_LOCAL_ID", null);
			map.put("MNT_STYLE_ID", null);
			
			String frameNum = request.getParameter("frameNum");
			String moduleNum = request.getParameter("moduleNum");
			String portNum = request.getParameter("portNum");
			
			eQPUnitPortInputServiceImpl.saveAllEQPUnitInfo(map, Integer.parseInt(frameNum), Integer.parseInt(moduleNum), Integer.parseInt(portNum));
			
		}else if(deviceType.equals("704")){//分纤箱
			String portNum = request.getParameter("gfportNum");
			map.put("LONG_OR_LOCAL_ID", null);
			map.put("MNT_STYLE_ID", "80000105");
			eQPUnitPortInputServiceImpl.saveAllEQPUnitInfo(map, 1, 1, Integer.parseInt(portNum));
			
		}else if(deviceType.equals("2530")){//分光器
			String unitNo = request.getParameter("unitNo");;//分光器所在列框
			
			String eqpNo =  request.getParameter("eqpNo");  ;//分光器所在设备
			
			String posType = request.getParameter("posType");//分光器类型
			
			if(eqpNo !=null && unitNo != null){
				Map<String, String>  ids = eQPUnitPortInputServiceImpl.getUnitIdByNo(eqpNo,unitNo);
				map.put("INSTALL_UNIT_ID", Util.convertStr(ids.get("PARENT_UNIT_ID")));
				
				map.put("LONG_OR_LOCAL_ID", null);
				map.put("MNT_STYLE_ID", "80000105");
				
				eQPUnitPortInputServiceImpl.saveFGUnitPortInfo(map, posType, Util.convertStr(ids.get("UNIT_ID")));
			}
		}		
			result= new DwzReturnObject(StaticPro.STATUS_CODE_SUCCESS,"保存成功",null,"../EQPUnitPort/saveEQPUnitPortPage.do",StaticPro.CALLBACK_TYPE_FORWARD);
		}catch(Exception e){
			e.printStackTrace();
			result= new DwzReturnObject(StaticPro.STATUS_CODE_FAIL,"保存失败",null,"../EQPUnitPort/saveEQPUnitPortPage.do",StaticPro.CALLBACK_TYPE_FORWARD);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());
	}
	
	/**
	 * 获取地区信息
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getAreaInfo", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String,String>> getAreaInfo(ModelMap model,HttpServletRequest request, HttpServletResponse response){
		
		String parentAreaId = request.getParameter("parentArea");
		
		
		List<Map<String,String>> list =  new ArrayList<Map<String,String>>();
		
		list = eQPUnitPortInputServiceImpl.getAreaByParentId(parentAreaId);
	
		model.put("list", list);
		return list;
	}
}
