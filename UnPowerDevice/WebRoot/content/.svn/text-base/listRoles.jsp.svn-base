<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zbiti.common.model.table.Page" %>
<%
	Page pg = (Page)request.getAttribute("page");
%>
<script type="text/javascript">
$(function (){
	$("#nppselr").val("<%=pg.getShowCount()%>");
});

</script>

<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/authority/listRolesInfo.do">  

			<input type="hidden" name="pageNum" value="1" /><!--【必须】value=1可以写死-->
			<input type="hidden" name="numPerPage" value="${page.showCount}"/>
			<input type="hidden" name="currentPage" value="${page.currentPage}"/>
</form> 

<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/authority/listRolesInfo.do" method="post" rel="pagerForm">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>角色名称：</label>
					<input type="text" name="roleName" value="${roleName}"/>
				</li>
			</ul>
			<div class="subBar" >
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;</li>
				</ul>
			</div>
		</div>
		</form>
	</div>
	
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="<%=request.getContextPath()%>/authority/addRolePage.do" target="dialog" title="添加角色信息" width="420"><span>添加</span></a></li>
				<li><a class="delete" href="<%=request.getContextPath()%>/authority/deleteRoleInfo.do" rel="roleIds" posttype="string"  target="selectedTodo" title="确实要删除吗?"><span>删除</span></a></li>
				<li><a class="edit" href="<%=request.getContextPath()%>/authority/updateRolePage.do?roleId={roleIds}" target="dialog" title="修改角色信息"  width="420"><span>修改</span></a></li>
				<li class="line">line</li>
			</ul>
		</div>
			<table class="table" width="98%" layoutH="136">
				<thead>
					<tr>
						<th width="25"><input class="checkboxCtrl" type="checkbox" group="roleIds"></input></th>
						<th width="80">序号</th>
						<th width="200">角色名称</th>
						<th width="100">客户端权重</th>
						<th width="100">服务端权重</th>
						<th width="100">客户端资源</th>
						<th>服务端资源</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="p" items="${result}" varStatus="status" >   
		            <tr target="roleIds" rel="${p.roleId}" style="height:25px;">  
		                <td><input type="checkbox" name="roleIds" value="${p.roleId}"/></td> 
		                <td>${status.count + (page.currentPage-1)*page.showCount}</td>
		                <td>${p.roleName}</td>
		                <td>${p.roleValue}</td>
		                <td>${p.serValue}</td>
		                <td>
		                	<a href="<%=request.getContextPath()%>/authority/getAllActionInfo.do?roleId=${p.roleId}&roleValue=${p.roleValue}" target="dialog" rel="dlg_page_${status.count}" style="color:#8175EE;" mask="true" title="功能窗口" width="400" height="480">分配客户端资源</a>
		                </td>
		                <td>
		                	<a href="<%=request.getContextPath()%>/authority/getAllServerActionInfo.do?roleId=${p.roleId}&serValue=${p.serValue}" target="dialog" rel="dlg_page_${status.count}" mask="true" title="功能窗口" width="400" height="480" style="color:#8175EE;l">分配服务端资源</a>
		                </td>
		            </tr>
	          	</c:forEach>
				</tbody>
			</table>
		
		<div class="panelBar" >
			<div class="pages">
				<span>显示</span>
				<select class="" id="nppselr" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
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