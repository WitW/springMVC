package com.zbiti.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zbiti.mvc.android.service.UserInfoService;
import com.zbiti.util.DataSourceInstance;
import com.zbiti.util.DataSourceSwitch;
import com.zbiti.util.Location;
import com.zbiti.util.Util;


/**
 * 处理session过期  和 数据源切换
 * @author dlt
 *
 */
public class SessionControlFilter implements Filter {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UserInfoService userInfoService;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		 HttpServletRequest req=(HttpServletRequest) request;
		 HttpServletResponse res=(HttpServletResponse)response;
		
		 HttpSession session = req.getSession(false);
		 String uri = req.getRequestURI();
	     String ctx=req.getContextPath();  

	     uri = uri.substring(ctx.length());
		 
		  if(session == null){
			  boolean flag = true;
			  for(int i =0;i < CommonStatic.VISIT_PATH.length;i++)
			  {
				  if(getLuJinMatchResult(CommonStatic.VISIT_PATH[i], uri))
				  {
					  //TODO 数据源切换
//					  if(i>1){
//							String param = Util.getParam(req);
//							
//							JSONObject jo = JSONObject.fromObject(param);
//							if(jo.getString("area") != null){
//								String areaCode = userInfoService.getAreaCodeById(jo.getString("area"));
//								if(areaCode != null){
//									Util.changeDataSource(areaCode);
//								}
//							}
//					  }
						
					  chain.doFilter(request, response);
					  flag = false;
					  break;
				  }
			  }
			  
			  if(flag)
			  {
			  res.sendRedirect(ctx+CommonStatic.RETURN_LOGIN_PAGE);
			  }
		  }
		  else
		  {
			//TODO 数据源切换
//			  System.out.println("ssssss:"+uri);
//			  Map<String,String> user=(Map<String, String>) session.getAttribute("userInfo");
//			  if(user != null && user.get("AREACODE") != null){
//				  System.out.println(user.get("AREACODE"));
//				  Util.changeDataSource(user.get("AREACODE"));
//				  //this.changeDataSource("");
//			  }
			  
			  chain.doFilter(request, response);
		  }


	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}
	
	/**
	 * 判断url是否匹配，匹配返回true，否则返回false
	 */
	private boolean getLuJinMatchResult(String str,String uri)
	{
		boolean flag = false;
		if(str.indexOf("*") != -1)
		{
			str = str.substring(0, str.indexOf("*"));
			flag = uri.indexOf(str)==0;
			return flag;
		}
		else
		{
			flag = str.equals(uri);
		}
		return  flag;
	}
	
}
