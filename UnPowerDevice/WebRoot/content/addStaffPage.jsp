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
    
    <title>添加用户信息</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
	<div class="pageContent" style="width: 566px;">
		<form class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);" action="<%=request.getContextPath()%>/authority/addStaffInfo.do" method="post" novalidate="novalidate">
			<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
				<p>
					<label>账户名称：</label>
					<input size="30" name="staffNbr" value="" class="required alphanumeric"></input>
				</p>
				<p>
					<label>账户密码：</label>
					<input size="30" name="password" value="" class="required"></input>
				</p>
				<p>
					<label>用户姓名：</label>
					<input size="30" name="staffName" value="" class="required"></input>
				</p>
				<p>
					<label>机构名称：</label>
					<input size="30" name="org" value=""></input>
				</p>
				<p>
					<label>地区名称：</label>
					<select name="areaName">
						<c:forEach var="a" items="${area}" varStatus="status" > 
							<option value="${a.AREA_ID}">${a.NAME}</option>
						</c:forEach>
					</select>
				</p>
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
