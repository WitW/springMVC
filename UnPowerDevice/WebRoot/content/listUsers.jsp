<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zbiti.common.model.table.Page" %>
<%
	Page pg = (Page)request.getAttribute("page");
%>
<script type="text/javascript">
$(function (){
	$("#nppselu").val("<%=pg.getShowCount()%>");
	$("#areaName").val("${areaName}");
});

</script>
<style>
<!--
	#userSerch li{
		float:left;
		width:230px;
		height:30px;
		/*list-style-type:none;*/
		list-style:none;
		
	}
	#userSerch{
		width:690px;
		height:60;
	}
-->
</style>
<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/authority/staffInfolistPage.do">  

			<input type="hidden" name="pageNum" value="1" /><!--【必须】value=1可以写死-->
			<input type="hidden" name="numPerPage" value="${page.showCount}"/>
			<input type="hidden" name="currentPage" value="${page.currentPage}"/>
</form> 

<div class="page unitBox">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/authority/staffInfolistPage.do" method="post" rel="pagerForm">
		<div class="searchBar">
				<table class="searchContent">
				<tbody>
					<tr>
						<td>账号名称：<input type="text" name="staffNbr" value="${requestScope.staffNbr}"/></td>
						
						<td>用户姓名：<input type="text" name="staffName"  value="${staffName}"/></td>
						<td>机构名称：<input type="text" name="org" value="${org}"/></td>
    					<td>地区名称：</td><td><select id="areaName" name="areaName" class="combox">
								<option value="">--请选择--</option>
								<c:forEach var="a" items="${area}" varStatus="status">
									<option value="${a.AREA_ID}">${a.NAME}</option>
								</c:forEach>
							</select>
    					</td>
    				</tr>
    			</tbody>
    		</table>
				<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				</ul>
			</div>
		</div>
		</form>
	</div>
	
	<div class="pageContent" >
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="<%=request.getContextPath()%>/authority/addStaffPage.do" target="dialog" title="添加用户信息"><span>添加</span></a></li>
				<li><a class="delete" href="<%=request.getContextPath()%>/authority/deleteStaffInfo.do" rel="staffIds" posttype="string"  target="selectedTodo" title="确实要删除吗?"><span>删除</span></a></li>
				<li><a class="edit" href="<%=request.getContextPath()%>/authority/updateStaffPage.do?staffId={staffIds}" target="dialog" title="修改用户信息"><span>修改</span></a></li>
				<li class="line">line</li>
			</ul>
		</div>
					<!-- table class="list" width="98%" layoutH="146" -->
					<table class="table" width="98%" layoutH="142">
						<thead>
							<tr>
								<th  style="width: 30px;"><input class="checkboxCtrl" type="checkbox" group="staffIds"></th>
								<th style="width: 30px;">序号</th>
								<th style="width: 163px;">账号名称</th>
								<th style="width: 163px;">密码</th>
								<th style="width: 163px;">用户姓名</th>
								<th style="width: 163px;">机构名称</th>
								<th style="width: 163px;">地区名称</th>
								<th style="width: 163px;">分配角色</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${result}" varStatus="status" >   
					            <tr target="staffIds" rel="${p.staffId}" style="height:25px;">  
					                <td style="width: 30px;"><div><input type="checkbox" name="staffIds" value="${p.staffId}"/></div></td> 
					                <td style="width: 30px;"><div>${status.count + (page.currentPage-1)*page.showCount}</div></td>
					                <td style="width: 163px;"><div>${p.staffNbr}</div></td>
					                <td style="width: 163px;"><div>${p.password}</div></td>
					                <td style="width: 163px;"><div>${p.staffName}</div></td>
					                <td style="width: 163px;"><div>${p.org}</div></td>
					                <td style="width: 163px;"><div>${p.areaName}</div></td>
					                <td style="width: 163px;">
					                	<a href="<%=request.getContextPath()%>/authority/getAllRoleInfo.do?staffId=${p.staffId}" target="dialog" rel="dlg_page_${status.count}" mask="true" title="角色窗口" width="400" height="480" style="color:#8175EE;"><span>分配角色</span></a>
					                </td>
					            </tr>  
				          	</c:forEach>
						</tbody>
					</table>
		
		
		<div class="panelBar">
			<div class="pages">
				<span>显示</span>
				<select class="" id="nppselu" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
					<option value="15">15</option>
					<option value="20">20</option>
					<option value="50">50</option>
					<option value="100">100</option>
					<option value="200">200</option>
				</select>
				<span>条，共${page.totalResult}条</span>
			</div>
			<div class="pagination" targetType="navTab" totalCount="${page.totalResult}" numPerPage="${page.showCount}" pageNumShown="10" currentPage="${page.currentPage}">
			</div>
		</div>
	</div>
</div>