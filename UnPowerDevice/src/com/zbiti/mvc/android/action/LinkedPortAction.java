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

import com.zbiti.mvc.android.service.LinkedPortService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

/**
 * 相连端口 控制层
 * @author dlt
 *
 */
@Controller
@RequestMapping("linkedPort")
public class LinkedPortAction {
	
	@Autowired
	private LinkedPortService linkedPortServiceImpl;

	/**
	 * 保存相连端口信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/saveLinePort")
	public void saveLinePort(HttpServletRequest request,HttpServletResponse response){
		Map<String,String> result = new HashMap<String,String>();
		
		String param = Util.getParam(request);
		
		//param = "{\"aPort\":\"8\",\"zPort\":\"9\"}";
		
		JSONObject jo = JSONObject.fromObject(param);
		
		String aPort = jo.getString("aPort");
		String zPort = jo.getString("zPort");
		
		try{
			List<Map<String,String>> list = linkedPortServiceImpl.getLinePortInfo(aPort, zPort);
			if(list != null && list.size() > 1){
				//上传的参数错误，可以查到多条数据
				result.put("result", StaticPro.LINE_PORT_ERROR);
				
			}else if(list != null && list.size() == 1){
				//端口重复，更新
				linkedPortServiceImpl.updateLinePort(aPort, zPort);
			}else{
				//不存在，新增
				linkedPortServiceImpl.insertLinePort(aPort, zPort);
			}
		}catch(Exception e){
			e.printStackTrace();
			result.put("result", StaticPro.CODE_DATABASE_ERROR);
		}
		
		result.put("result", StaticPro.CODE_SUCCESS);

		JSONObject rjo = JSONObject.fromObject(result);

		Util.sendParam(response, rjo.toString()); // 传递json参数
	} 
	
	/**
	 * 获取相连端口信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getLinePortInfo")
	public void getLinePortInfo(HttpServletRequest request,HttpServletResponse response){
		
		Map<String,String> result = new HashMap<String,String>();
		
		String param = Util.getParam(request);
		//param = "{\"aPort\":\"1\"}";
		JSONObject jo = JSONObject.fromObject(param);
		
		String aPort = jo.containsKey("aPort")? jo.getString("aPort") : null;

		List<Map<String,String>> list = linkedPortServiceImpl.getLinePortInfo(aPort,null);
		
		if(list==null || list.size() < 1 ){
			//没查到相连端口
			result.put("result", StaticPro.LINE_PORT_ERROR);
		}else{
			result.put("result", StaticPro.CODE_SUCCESS);
			if(aPort.equals(list.get(0).get("Z_LINE_PORT"))){
				result.put("zPort", list.get(0).get("A_LINE_PORT"));
			}else{
				result.put("zPort", list.get(0).get("Z_LINE_PORT"));
			}
			
		}
		
		JSONObject rjo = JSONObject.fromObject(result);

		System.out.println("...."+rjo.toString());
		Util.sendParam(response, rjo.toString()); // 传递json参数
		
	}
	
}
