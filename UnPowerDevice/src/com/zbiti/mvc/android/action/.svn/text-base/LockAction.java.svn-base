package com.zbiti.mvc.android.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.mvc.android.service.DeviceInfoService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;


@Controller
@RequestMapping("/lock")
@SuppressWarnings("all")
public class LockAction {

	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private DeviceInfoService deviceInfoServiceImpl;
	
//	/**
//	 * 验证电子锁权限
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping("/unlock")
//	public void unlock(HttpServletRequest request,
//			HttpServletResponse response){
//		String param = Util.getParam(request);
//		logger.debug(param);
//		//String param = "{\"opr\":\"O\",\"rfId\":\"00000000000000000000000000000000\",\"area\":\"00\",\"staffId\":\"zhao\"}";
//		JSONObject jo = JSONObject.fromObject(param);
//
//		String staffId = jo.getString("staffId");
//		String area = jo.getString("area");
//		String rfId = jo.getString("rfId");
//		String opr = jo.getString("opr");
//		
//		Map result = new HashMap();
//		try{
//			boolean b = deviceInfoServiceImpl.checkLockRfid(staffId,rfId);
//			if(b){
//				result.put("resultCode", StaticPro.CODE_SUCCESS);
//				deviceInfoServiceImpl.saveLockLog(staffId,rfId,opr);
//			}else{
//				result.put("resultCode", StaticPro.CODE_LOCK_NONE_PERMISSION);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			result.put("resultCode", StaticPro.CODE_DATABASE_ERROR);
//		}
//		Util.sendParam(response, JSONObject.fromObject(result).toString());
//	}
}
