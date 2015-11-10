package com.zbiti.mvc.android.action;

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
import com.zbiti.mvc.android.service.UserInfoService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

@Controller
@RequestMapping("/advice")
@SuppressWarnings("all")
public class AdviceAction {

	protected final Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private UserInfoService userInfoServiceImpl;

	/**
	 * 保存反馈信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/saveAdvice")
	public void saveAdvice(HttpServletRequest request,
			HttpServletResponse response){
		String param = Util.getParam(request);
		logger.debug(param);
		//String param = "{\"staffId\":\"zhaoqi\",\"content\":\"我是测试字符串\"}";
		JSONObject jo = JSONObject.fromObject(param);

		String staffId = jo.getString("staffId");
		String content = jo.getString("content");
		
		Map result = new HashMap();
		try{
			userInfoServiceImpl.saveAdvice(staffId,content);
			result.put("resultCode", StaticPro.CODE_SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.put("resultCode", StaticPro.CODE_DATABASE_ERROR);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());
		
	}
}
