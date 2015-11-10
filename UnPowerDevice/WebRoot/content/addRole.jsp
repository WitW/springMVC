<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加角色信息</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<div class="pageContent" style="width: 400px;">
	  	<form id="addRoleForm" action="<%=request.getContextPath()%>/authority/addRoleInfo.do" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
	  		<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
	  			<br>
	  			<p>
					<label>角色名称：</label>
					<input size="30" name="roleName" value="" class="required"></input>
				</p>
				<p>&nbsp;</p>
				<!-- p>
					<label>角色功能：</label>
					<select name="roleValue">
						<c:forEach var="a" items="${listAc}" varStatus="status" > 
							<option value="${a.actionType}">${a.actionName}</option>
						</c:forEach>
					</select>
				</p -->
		        
	  		</div>
			<div class="formBar" align="right">
				<ul>
				    <li><div class="buttonActive"><div class="buttonContent">
				    	<button type="submit">保存</button></div></div>
				    </li>
					    <li>
					    	<div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div>
					    </li>
				    </ul>
    		</div>
	  	</form>
  	</div>
  	
  </body>
</html>
