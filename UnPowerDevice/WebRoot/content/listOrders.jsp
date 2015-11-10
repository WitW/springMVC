<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zbiti.common.model.table.Page" %>
<%
	Page pg = (Page)request.getAttribute("page");
%>
<script type="text/javascript">
$(function (){
	$("#nppselor").val("<%=pg.getShowCount()%>");
	$("#orderState").val("${orderState}");
});

</script>

<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/workOrderSer/getWorkOrderInfolistPage.do">  

			<input type="hidden" name="pageNum" value="1" /><!--【必须】value=1可以写死-->
			<input type="hidden" name="numPerPage" value="${page.showCount}"/>
			<input type="hidden" name="currentPage" value="${page.currentPage}"/>
</form> 

<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/workOrderSer/getWorkOrderInfolistPage.do" method="post" rel="pagerForm">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>工单状态：</label>
					<select id="orderState" name="orderState" class="combox">
						<option value="">--请选择--</option>
						<option value="W">未完成</option>
						<option value="C">已完成</option>
					</select>
				</li>
				<li>
					<label>装维人员工号:</label>
					<input type="text" name="staffNbr" value="${requestScope.staffNbr}" />
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
			<table class="table" width="98%" layoutH="110">
				<thead>
					<tr>
						<th width="30">序号</th>
						<th width="100">装维人员工号</th>
						<th width="130">业务类别</th>
						<th width="50">PON类型</th>
						<th width="80">工程性质</th>
						<th width="50">服务等级</th>
						<th width="100">接入号</th>
						<th width="80">客户名称</th>
						<th width="100">客户联系电话</th>
						<th width="100">客户地址</th>
						<th width="50">工单状态</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="p" items="${orderList}" varStatus="status" >   
		            <tr target="roleIds" rel="${p.workOrderId}" style="height:25px;">  
		                <td>${status.count + (page.currentPage-1)*page.showCount}</td>
		                <td>${p.staffNbr}</td>
		                <td>${p.busyType}</td>
		                <td>${p.ponType}</td>
		                <td>${p.event}</td>
		                <td>${p.dredgeLevel}</td>
		                <td>${p.accessNum}</td>
		                <td>${p.customer}</td>
		                <td>${p.telephone}</td>
		                <td>${p.address}</td>
		                <c:choose>
						    <c:when test="${p.orderState=='W'}">
						    	<td>未完成</td>            		
						    </c:when>			                	
						    <c:otherwise>
						        <td>已完成</td>           		
						    </c:otherwise>
					    </c:choose>
		            </tr>
	          	</c:forEach>
				</tbody>
			</table>
		
		<div class="panelBar" >
			<div class="pages">
				<span>显示</span>
				<select class="" id="nppselor" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
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