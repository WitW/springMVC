package com.zbiti.mvc.login.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.common.model.tree.TreeNode;
import com.zbiti.mvc.android.service.UserInfoService;
import com.zbiti.util.StaticPro;

/**
 * 服务端用户登录
 * @author dlt
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 用户登录
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/loginIn")
	public String login(HttpServletRequest request, HttpSession session,
            ModelMap model){
		String userName = request.getParameter("userName");// 用户名
	    String password = request.getParameter("password"); // 密码
	    
	    if((userName==null||"".equals(userName)) && (password==null||"".equals(password))){
	    	model.put("errorMsg", "工号和密码不能为空！");
	    	return "login";
	    }else if(userName==null||"".equals(userName)){
	    	model.put("errorMsg", "工号不能为空！");
	    	return "login";
	    }else if(password==null||"".equals(password)){
	    	model.put("errorMsg", "密码不能为空！");
	    	return "login";
	    }else{
	    	Map<String,String> user = userInfoService.getUserInfoByStaffNbr(userName);
	    	
	    	if(user ==null ||user.size()==0){
	    		model.put("errorMsg", "用户不存在！");
	    		return "login";
	    	}else if(!password.equals(user.get("PASSWORD"))){
	    		
	    		model.put("errorMsg", "密码不正确！");
	    		return "login";
	    	}
	    	
	    	
	    	
	    	//Util.changeDataSource(user.get("AREACODE"));
	    	
	    	   
		    List<Integer> listVal = userInfoService.getRoleSerValueByStaffNbr(userName);
	    	
	    	String binVal = Integer.toBinaryString(StaticPro.getStaffValue(listVal));
	    	
	    	
	    	session.setAttribute("staffNbr", userName);
	    	
	    	session.setAttribute("userInfo", user);
	    	
	    	if("0".equals(binVal)){
	    		model.put("errorMsg", "你没有任何权限，请联系管理员。");
	    		return "login";
	    	}
	    	
	    	if(binVal.substring(binVal.length()-1, binVal.length()).equals("1")){
		    	//工单操作
		    	List<TreeNode> tns = new ArrayList<TreeNode>();
				TreeNode tn = new TreeNode();
				tn.setId("11");
				tn.setHref("../workOrderSer/workOrderInput.do");
				tn.setTitle("工单录入");
				tns.add(tn);
				
				TreeNode tn12 = new TreeNode();
				tn12.setId("12");
				tn12.setHref("../workOrderSer/getWorkOrderInfolistPage.do");
				tn12.setTitle("工单列表");
				tns.add(tn12);
				
				TreeNode tnNew = new  TreeNode(tns);
				model.put("liStr", tnNew.getLiStr());
	    	}

			
	    	if(binVal.length()>1 && binVal.substring(binVal.length()-2, binVal.length()-1).equals("1")){
				// 版本管理模块
				List<TreeNode> verMang = new ArrayList<TreeNode>();
				TreeNode tn2 = new TreeNode();
				tn2.setId("21");
				tn2.setHref("../upload/uploadPage.do");
				tn2.setTitle("版本上传");
				verMang.add(tn2);
				
				TreeNode tnVerMange = new  TreeNode(verMang);
				model.put("liVers", tnVerMange.getLiStr());
	    	}

	    	if(binVal.length()>2 && binVal.substring(binVal.length()-3, binVal.length()-2).equals("1")){
				// 权限管理模块
				List<TreeNode> AutMang = new ArrayList<TreeNode>();
				TreeNode Aut1 = new TreeNode();
				Aut1.setId(StaticPro.LEFT_TREEID_ROLE);
				Aut1.setHref("../authority/listRolesInfo.do");
				Aut1.setTitle("角色管理");
				AutMang.add(Aut1);
				
				TreeNode Aut2 = new TreeNode();
				Aut2.setId(StaticPro.LEFT_TREEID_STAFF);
				Aut2.setHref("../authority/staffInfolistPage.do");
				Aut2.setTitle("用户管理");
				AutMang.add(Aut2);
				TreeNode tnAutMange = new  TreeNode(AutMang);
				model.put("liAuts", tnAutMange.getLiStr());
	    	}
	    	
	    	if(binVal.length()>3 && binVal.substring(binVal.length()-4, binVal.length()-3).equals("1")){
		    	//门禁管理
		    	List<TreeNode> doorMang = new ArrayList<TreeNode>();
		    	
		    	TreeNode dr41 = new TreeNode();
		    	dr41.setId("41");
		    	dr41.setHref("../accessControl/getOperateTime.do");
		    	dr41.setTitle("门禁时间段管理");
		    	doorMang.add(dr41);
		    	
		    	TreeNode dr42 = new TreeNode();
		    	dr42.setId(StaticPro.LEFT_TREEID_DOOR);
		    	dr42.setHref("../accessControl/authorityPage.do");
		    	dr42.setTitle("门禁权限管理");
		    	doorMang.add(dr42);
		    	
		    	
		    	TreeNode dr43 = new TreeNode();
		    	dr43.setId("43");
		    	dr43.setHref("../LockOperate/listOperationPage.do");
		    	dr43.setTitle("操作记录");
		    	doorMang.add(dr43);
		    	
		    	TreeNode dr44 = new TreeNode();
		    	dr44.setId("44");
		    	dr44.setHref("../accessControl/devicePositionMap.do");
		    	dr44.setTitle("设备坐标");
		    	doorMang.add(dr44);
		    	
//		    	TreeNode dr45 = new TreeNode();
//		    	dr45.setId("45");
//		    	dr45.setHref("../EQPUnitPort/saveEQPUnitPortPage.do");
//		    	dr45.setTitle("新增设备");
//		    	doorMang.add(dr45);
		    	
		    	TreeNode door = new TreeNode(doorMang);
		    	
		    	model.put("doorAccess", door.getLiStr());
	    	}
	    	
	    	if(binVal.length()>4 && binVal.substring(binVal.length()-5, binVal.length()-4).equals("1")){
		    	//巡检结果
	    		List<TreeNode> inspectionManager = new ArrayList<TreeNode>();
				TreeNode ipm = new TreeNode();
				ipm.setId("51");
				ipm.setHref("../inspection/inspectionPage.do");
				ipm.setTitle("巡检结果展示");
				inspectionManager.add(ipm);
				
				TreeNode inspection = new  TreeNode(inspectionManager);
				model.put("inspection", inspection.getLiStr());
	    	}
	    	
	    	return "index";
	    }
	}
	/**
	 * 注销
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/logoff")
	public String logoff(HttpServletRequest request, ModelMap model) {

		request.getSession().invalidate(); // 首先将本Session 置无效
		
		return "login";
	}
	
}
