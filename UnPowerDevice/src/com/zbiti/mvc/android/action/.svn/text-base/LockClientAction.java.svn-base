package com.zbiti.mvc.android.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.mvc.android.service.LockOperateService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

@Controller
@RequestMapping("lockClient")
@SuppressWarnings("all")
public class LockClientAction {
	
	@Autowired
	private LockOperateService lockOperateServiceImpl;

	/**
	 * 获取门状态、开关记录
	 * @param request
	 * @param response
	 */
	@RequestMapping("getOperationInfo")
	public void getOperationInfo(HttpServletRequest request,HttpServletResponse response){
		
		Map result = new HashMap();
		
		String param = Util.getParam(request);
		
		//param =  "{\"deviceNo\":\"WJ.TDZT/GJ001\",\"twoDimCode\":\"http://WJ.TDZT/GJ001\",\"lockRfid\":\"3000E2002076990F0162214035D6DCFE\"}";
		
		JSONObject jo = JSONObject.fromObject(param);
		
		Map<String,String> map = new HashMap<String,String>();
		
		if(jo.containsKey("deviceNo")){
			map.put("deviceNo", jo.getString("deviceNo"));
		}
		if(jo.containsKey("twoDimCode")){
			map.put("twoDimCode", jo.getString("twoDimCode"));
		}
		if(jo.containsKey("lockRfid")){
			map.put("lockRfid", jo.getString("lockRfid"));
		}
		
		List<Map<String, String>>  list = lockOperateServiceImpl.getOperationInfo(map);
		if(list != null && list.size()>0){
			result.put("resultCode", StaticPro.CODE_SUCCESS);
			result.put("data", list.get(0));
		}else{
			result.put("resultCode", "001");
		}
		
		
		JSONObject rjo = JSONObject.fromObject(result);
		
		Util.sendParam(response, rjo.toString());
	}

}
