package com.zbiti.mvc.android.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.common.model.DwzReturnObject;
import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.StaffInfo;
import com.zbiti.mvc.android.model.WorkOrderInfo;
import com.zbiti.mvc.android.service.DeviceInfoService;
import com.zbiti.mvc.android.service.UserInfoService;
import com.zbiti.mvc.android.service.WorkOrderService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

/**
 * 工单录入处理Action
 * @author
 *
 */
@Controller
@RequestMapping("/workOrderSer")
public class WorkOrderInputAction {
	
	@Autowired
	WorkOrderService workOrderServiceImpl;
	
	@Autowired
	private DeviceInfoService deviceInfoServiceImpl;
	
	@Autowired
	private UserInfoService userInfoServiceImpl;
	
	/**
	 * 跳转到工单录入页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/workOrderInput")
	public String selectEqpInfo(HttpServletRequest request,ModelMap model){
		
		HttpSession session = request.getSession();
		String staffNbr = (String)session.getAttribute("staffNbr");
		
		//页面选择装维人员
		List<StaffInfo> list = userInfoServiceImpl.getStaffInfoInOneArea(staffNbr);
		
		model.put("staff", list);
	    return "workOrderInput";
	}
	
	/**
	 * 保存工单信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/saveWorkOrder")
	public void saveWorkOrder(HttpServletRequest request, HttpServletResponse response){
		
		DwzReturnObject result=null;
		
		String conNum = (String)request.getParameter("conNum");
		
		StringBuilder  sbd = new StringBuilder("");
		int tmpNum = 0;
		
		for(int i = 1;i <= Integer.parseInt(conNum); i++){
			String deviceNo =  (String)request.getParameter("deviceNo" + i).trim();
			String portNo =  (String)request.getParameter("portNo" + i).trim();
			
			String cont = deviceInfoServiceImpl.getDevsPortCount(deviceNo, portNo);
			if(cont == null || Integer.parseInt(cont) <= 0){
				String rerMsg = "保存失败，设备编码："+deviceNo+"，端子编码："+portNo;
				result= new DwzReturnObject(StaticPro.STATUS_CODE_FAIL,rerMsg,null,"../workOrderSer/workOrderInput.do",StaticPro.CALLBACK_TYPE_FORWARD);
				Util.sendParam(response, JSONObject.fromObject(result).toString());
				return;
			}else{
				if(tmpNum == 0){
					sbd.append(deviceNo + ":" + portNo);
				}else{
					sbd.append("|" + deviceNo + ":" + portNo);
				}
				tmpNum ++;
			}
		}
		
		//工单信息
		WorkOrderInfo wo = new WorkOrderInfo();
		wo.setWorkOrderId(request.getParameter("workOrderId"));
		wo.setTml(request.getParameter("tml"));
		wo.setPonType(request.getParameter("ponType"));
		wo.setStaffNbr(request.getParameter("staffNbr"));
		wo.setBusyType(request.getParameter("busyType"));
		wo.setEvent(request.getParameter("event"));
		wo.setDredgeLevel(request.getParameter("dredgeLevel"));
		wo.setCompleteTime(request.getParameter("completeTime"));
		wo.setCustomer(request.getParameter("customer"));
		wo.setAccessNum(request.getParameter("accessNum"));
		wo.setTelephone(request.getParameter("telephone"));
		wo.setAddress(request.getParameter("address"));
		wo.setNewRes(request.getParameter("newRes"));
		wo.setOldRes(request.getParameter("oldRes"));
		wo.setNewGlNo(request.getParameter("newGlNo"));
		wo.setOldGlNo(request.getParameter("oldGlNo"));
		wo.setDevPortNo(sbd.toString());
		
		
		try{
			//保存工单信息
			workOrderServiceImpl.saveWorkOrder(wo);
			result= new DwzReturnObject(StaticPro.STATUS_CODE_SUCCESS,"保存成功",null,"../workOrderSer/workOrderInput.do",StaticPro.CALLBACK_TYPE_FORWARD);
		}catch(Exception e){
			e.printStackTrace();
			result= new DwzReturnObject(StaticPro.STATUS_CODE_FAIL,"保存失败",null,"../workOrderSer/workOrderInput.do",StaticPro.CALLBACK_TYPE_FORWARD);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());
	}
	
	/**
	 * 分页查询工单列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getWorkOrderInfolistPage")
	public String getWorkOrderInfolistPage(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		Map<String,String> map = new HashMap<String,String>();
		
		if(request.getParameter("orderState") != null){
			map.put("orderState", (String)request.getParameter("orderState"));
			model.put("orderState", (String)request.getParameter("orderState"));
		}
		
		if(request.getParameter("staffNbr") != null){
			map.put("staffNbr", (String)request.getParameter("staffNbr"));
			model.put("staffNbr", (String)request.getParameter("staffNbr"));
		}
		
		Page page = new Page();
		
		if(request.getParameter("pageNum") != null&&request.getParameter("pageNum") != ""){
			String pageNum = (String)request.getParameter("pageNum");
			page.setCurrentPage(Integer.parseInt(pageNum));
		}
		if(request.getParameter("numPerPage") !=null&& request.getParameter("numPerPage")!=""){
			String showCount = (String)request.getParameter("numPerPage");
			page.setShowCount(Integer.parseInt(showCount));
		}
		
		List<WorkOrderInfo> list = workOrderServiceImpl.getWorkOrderInfolistPage(map, page);
		
		model.addAttribute("page", page);
		model.addAttribute("orderList", list);
		
		return "listOrders";
	}
	
}
