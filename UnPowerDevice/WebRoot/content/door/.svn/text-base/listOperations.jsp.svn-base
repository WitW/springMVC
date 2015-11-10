<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zbiti.common.model.table.Page" %>
<%
	Page pg = (Page)request.getAttribute("page");
%>
<script type="text/javascript">
$(function (){
	$("#nppselop").val("<%=pg.getShowCount()%>");
	$("#areaName").val("${areaName}");
});

</script>

<style type="text/css">
	#mySearchBar li{
		float:left;
		width:300px;
		height:30px;
		list-style-type:none;
		/*list-style:none;*/
		
	}
	#mySearchBar{
		width:900px;
	}
</style>
<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/LockOperate/listOperationPage.do">  

			<input type="hidden" name="pageNum" value="1" /><!--【必须】value=1可以写死-->
			<input type="hidden" name="numPerPage" value="${page.showCount}"/>
			<input type="hidden" name="currentPage" value="${page.currentPage}"/>
</form> 

<div class="page unitBox" style="display: block;">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/LockOperate/listOperationPage.do" method="post" rel="pagerForm">
		<div class="searchBar">

			<table class="searchContent">
				<tbody>
					<tr>
						<td>设备编码：<input type="text" name="deviceNo" value="${deviceNo}"/></td>
						<td>设备名称：<input type="text" name="deviceName" value="${deviceName}"/></td>
						<td>账号名称：<input type="text" name="staffNbr" value="${requestScope.staffNbr}"/></td>
						<td>用户姓名：<input type="text" name="staffName" value="${requestScope.staffName}"/></td>
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
					<table class="table" layoutH="113">
						<thead>
							<tr>
								<th style="width: 30px;">序号</th>
								<th style="width: 100px;">账号名称</th>
								<th style="width: 100px;">用户姓名</th>
								<th style="width: 175px;">设备编码</th>
								<th style="width: 200px;">设备名称</th>
								<th style="width: 60px;">操作类型</th>
								<th style="width: 150px;">操作时间</th>
								<th style="width: 200px;">操作说明</th>
								<th style="width: 50px;">照片</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${result}" varStatus="status">  
					            <tr> 
					                <td>${status.count + (page.currentPage-1)*page.showCount}</td>
					                <td>${p.staffNbr}</td>
					                <td>${p.staffName}</td>
					                <td>${p.deviceNo}</td>
					                <td>${p.deviceName}</td>
					                <c:choose>
					                	<c:when test="${p.type=='1'}">
					                		<td>开门</td>
					                	</c:when>
					                	<c:when test="${p.type=='2'}">
					                		<td>关门</td>
					                	</c:when>				                	
					                	<c:otherwise>
					                		<td>异常关门</td>
					                	</c:otherwise>
					                </c:choose>
					                
					                <td>${p.operDate}</td>
					                <td>${p.note}</td>
					                <c:choose>
					                	<c:when test="${p.photoPath!='' && p.photoPath !=null}">
					               			<td>
					                			<a class="btnAttach" title="附件" target="dialog" href="../LockOperate/getPhoto.do?photoPath=${p.photoPath}" width="400" height="550">
					                				附件
					                			</a>
					                		</td>
					                	</c:when>
					                	<c:otherwise>
					                		<td>&nbsp;</td>
					                	</c:otherwise>
					                </c:choose>
					            </tr>
				          	</c:forEach>
						</tbody>
					</table>
		
		<div class="panelBar">
			<div class="pages">
				<span>显示</span>
				<select class="" id="nppselop" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
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