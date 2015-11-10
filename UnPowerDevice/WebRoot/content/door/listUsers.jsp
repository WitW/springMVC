<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zbiti.common.model.table.Page" %>
<%
	Page pg = (Page)request.getAttribute("page");
%>
<script type="text/javascript">
$(function (){
	$("#nppseldu").val("<%=pg.getShowCount()%>");
	$("#areaName").val("${areaName}");
});

</script>
<style>
<!--
	#douSerch li{
		float:left;
		width:230px;
		height:30px;
		/*list-style-type:none;*/
		list-style:none;
		
	}
	#douSerch{
		width:690px;
		height:60;
	}
-->
</style>
<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/accessControl/authorityPage.do">  

			<input type="hidden" name="pageNum" value="1" /><!--【必须】value=1可以写死-->
			<input type="hidden" name="numPerPage" value="${page.showCount}"/>
			<input type="hidden" name="currentPage" value="${page.currentPage}"/>
</form> 

<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/accessControl/authorityPage.do" method="post" rel="pagerForm">
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
	
	<div class="pageContent">
			<table class="table" width="98%" layoutH="115">
				<thead>
					<tr>
						<th width="30">序号</th>
						<th width="100">账号名称</th>
						<th width="100">用户姓名</th>
						<th width="200">机构名称</th>
						<th width="100">地区名称</th>
						<th width="100">门禁权限</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="p" items="${result}" varStatus="status" >   
		            <tr target="staffIds" rel="${p.staffId}" height="25px">  
		                <td>${status.count + (page.currentPage-1)*page.showCount}</td>
		                <td>${p.staffNbr}</td>
		                <td>${p.staffName}</td>
		                <td>${p.org}</td>
		                <td>${p.areaName}</td>
		                <td>
		                    <a href="<%=request.getContextPath()%>/accessControl/getDeviceInfo.do?staffId=${p.staffId}" target="dialog" rel="dlg_page_${status.count}" class="btnEdit" mask="true" title="门禁权限" width="700" height="450">
		                		<span>门禁权限</span>
		                	</a>
		                </td>
		            </tr>  
	          	</c:forEach>
				</tbody>
			</table>
		
		
		<div class="panelBar" >
			<div class="pages">
				<span>显示</span>
				<select class="" id="nppseldu" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
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