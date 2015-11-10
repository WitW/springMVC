<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
//String path = request.getContextPath();
//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>修改用户信息</title>
<script type="text/javascript">
$(function(){
	var a="${staff.areaName}";
	$("#areaID option").each(function(){
		if($(this).text() == a){
			$(this).attr("selected", true);
		}
	});
});
</script>
  </head>
  <body>
	<div class="pageContent" style="width: 566px;">
		<form action="<%=request.getContextPath()%>/authority/updateStaffInfo.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);" method="post" novalidate="novalidate">
			<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
				<input size="30" name="staffId" value="${staff.staffId}" type="hidden"></input>
				<p>
					<label>账户名称：</label>
					<input size="30" name="staffNbr" value="${staff.staffNbr}" class="textInput readonly" readonly="true"></input>
				</p>
				<p>
					<label>账户密码：</label>
					<input size="30" name="password" value="${staff.password}"></input>
				</p>
				<p>
					<label>用户姓名：</label>
					<input size="30" name="staffName" value="${staff.staffName}"></input>
				</p>
				<p>
					<label>机构名称：</label>
					<input size="30" name="org" value="${staff.org}"></input>
				</p>
				<p>
					<label>地区名称：</label>
					
					<select id="areaID" name="areaID" class="combox">
						<c:forEach var="a" items="${areaList}" varStatus="status" > 
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
