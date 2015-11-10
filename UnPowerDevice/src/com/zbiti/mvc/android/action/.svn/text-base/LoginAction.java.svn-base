package com.zbiti.mvc.android.action;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.mvc.android.model.PortRfidInfo;
import com.zbiti.mvc.android.model.WorkOrderSaveInfo;
import com.zbiti.mvc.android.service.UserInfoService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

/**
 * 客户端登陆 控制类
 * @author dlt
 *
 */
@Controller
@RequestMapping("/androidLogin")
@SuppressWarnings("all")
public class LoginAction {
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 客户端登录
	 * @param request
	 * @param response
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request,
			HttpServletResponse response){
		String param = Util.getParam(request);//从手机客户端获得json数组格式的参数
		
		//String param = "{\"userName\":\"zhao\",\"passWord\":\"123456\"}";
		logger.debug(param);
		//String param = "{\"userName\":\"zhao\",\"passWord\":\"123452\"}";
		JSONObject jo = JSONObject.fromObject(param);//将参数转化为json对象

		String userName = jo.getString("userName");//获得用户名
		String passWord = jo.getString("passWord");//获得密码
		
		Map<String,String> user = userInfoService.getUserInfoByStaffNbr(userName);//根据用户名获得用户信息
		Map<String,String> result = new HashMap<String, String>();
		if(user ==null ||user.size()==0){
			//用户不存在
			result.put("resultCode",StaticPro.CODE_NONE_USER);
		}else{
			//用户存在，并获取用户的相关信息
			String r_pwd = Util.convertStr(user.get("PASSWORD"));
			String staffname = Util.convertStr(user.get("STAFF_NAME"));
			String area = Util.convertStr(user.get("AREA"));
			if(passWord.equals(r_pwd)){
				//密码正确
				result.put("resultCode",StaticPro.CODE_SUCCESS);
				result.put("staffname",staffname);
				result.put("area",area);
				
				//Util.changeDataSource(user.get("AREACODE"));
				
				List<Integer>  list= userInfoService.getStaffRoleValueByStaffNbr(userName);
				result.put("staffValue", String.valueOf(StaticPro.getStaffValue(list)));
				
			}else{
				//密码错误
				result.put("resultCode",StaticPro.CODE_ERROR_PASSWORD);
			}
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());//将响应传给手机客户端
	}
	
	/**
	 * 客户端，修改密码
	 * @param request
	 * @param response
	 */
	@RequestMapping("/editPassword")
	public void editPassword(HttpServletRequest request,
			HttpServletResponse response){
		String param = Util.getParam(request);//接受手机客户端传来的参数
		//String param = "{\"userName\":\"zhaoqi\",\"passWord\":\"654321\",\"newPassWord\":\"123456\",\"area\":\"21\"}";

		JSONObject jo = JSONObject.fromObject(param);//将参数转化为json对象

		String userName = jo.getString("userName");//获得用户名
		String passWord = jo.getString("passWord");//获取旧密码
		String NewpassWord = jo.getString("newPassWord");//获取新密码
		
		Map<String,String> user = userInfoService.getUserInfoByStaffNbr(userName);//根据用户名查看用户信息
		Map<String,String> result = new HashMap<String, String>();
		if(user ==null ||user.size()==0){
			//用户不存在
			result.put("resultCode",StaticPro.CODE_NONE_USER);
		}else{
			//用户存在，获取相关用户信息
			String r_pwd = Util.convertStr(user.get("PASSWORD"));
			String staffname = Util.convertStr(user.get("STAFFNAME"));
			String area = Util.convertStr(user.get("AREA"));
			if(passWord.equals(r_pwd)){
				//密码正确
				try{
				userInfoService.updatePassword(userName,passWord,NewpassWord);//更新用户名的密码
				result.put("resultCode",StaticPro.CODE_SUCCESS);
				}catch(Exception e){
					e.printStackTrace();
					result.put("resultCode",StaticPro.CODE_DATABASE_ERROR);
				}
			}else{
				//密码错误
				result.put("resultCode",StaticPro.CODE_ERROR_PASSWORD);
			}
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());//将响应传给手机客户端
	}
	
}
