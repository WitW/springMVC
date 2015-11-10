package com.zbiti.mvc.android.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.mvc.android.model.WorkOrderInfo;
import com.zbiti.mvc.android.service.WorkOrderService;
import com.zbiti.util.Util;

/**
 * 工单列表查询 控制类
 * @author dlt
 *
 */
@Controller
@RequestMapping("/workorder")
@SuppressWarnings("all")
public class WorkOrderAction {
	protected final Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private WorkOrderService workOrderServiceImpl;
	
	/**
	 * 获取工单列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getWorkOrderList")
	public void getWorkOrderList(HttpServletRequest request ,HttpServletResponse response){
		
		String param = Util.getParam(request);//获取客户端传来的参数
		logger.debug(param);
		//param = "{\"staffId\":\"suyin\",\"area\":\"21\"}";
		JSONObject jo = JSONObject.fromObject(param);//将参数转化为JSON对象
		
		String staffId = jo.getString("staffId");
		//获取工单列表
		List<WorkOrderInfo> workOrders = workOrderServiceImpl.getWorkOrderListByStaffID(staffId);

		Map m = new HashMap();
		m.put("orders", workOrders);
		
		System.out.println(JSONObject.fromObject(m).toString());
		
		Util.sendParam(response, JSONObject.fromObject(m).toString());//将响应传给客户端
		
	}
	
	
}
