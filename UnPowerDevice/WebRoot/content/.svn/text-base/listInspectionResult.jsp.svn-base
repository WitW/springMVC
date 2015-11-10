<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zbiti.common.model.table.Page" %>
<%
	Page pg = (Page)request.getAttribute("page");
%>
<script type="text/javascript">
$(function (){
	$("#nppsel").val("<%=pg.getShowCount()%>");
});

</script>

<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/inspection/inspectionPage.do">  

			<input type="hidden" name="pageNum" value="1" /><!--【必须】value=1可以写死-->
			<input type="hidden" name="numPerPage" value="${page.showCount}"/>
			<input type="hidden" name="currentPage" value="${page.currentPage}"/>
</form> 

<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/inspection/inspectionPage.do" method="post" rel="pagerForm">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>设备编码：</label>
				    <input type="text" name="deviceNo" value="${deviceNo}"/>
				</li>
				<li>
					<label>巡检时间：</label>
				     <input name="inspectionTime1" type="text" dateFmt="yyyy/MM/dd HH:mm:ss" class="date" size="30" value="${inspectionTime1}" />
				</li>
				<li>
				<label>&nbsp;&nbsp;&nbsp;&nbsp;到</label>
				  <input name="inspectionTime2" type="text" dateFmt="yyyy/MM/dd HH:mm:ss" class="date" size="30" value="${inspectionTime2}"/>
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
				<li>&nbsp;</li>
				<li>&nbsp;</li>
				<li>&nbsp;</li>
				<li>&nbsp;</li>
			</ul>
		   </div>
			<table class="table" width="98%" layoutH="136">
				<thead>
					<tr>
						<th width="25">序号</th>
						<th width="200">设备编码</th>
						<th width="200">巡检人员</th>
						<th width="200">不匹配数量</th>
						<th width="50">巡检时间</th>
						<th width="200">查看巡检结果</th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach var="p" items="${inspectionResultInfo}" varStatus="status" >   
		            <tr style="height:25px;">  
		                <td>${status.count + (page.currentPage-1)*page.showCount}</td>
		                <td>${p.NO}</td>
		                <td>${p.STAFFID}</td>
		                <td>${p.RESULT_COUNT}</td>
		                <td>${p.CREATE_DATE}</td>
		                <c:choose>
		                	<c:when test="${p.RES_SPEC_ID == '2530'}">
		                		<td><a href="<%=request.getContextPath()%>/inspection/splitterShow.do?DEVICENO=${p.NO}&PHY_EQP_ID=${p.PHY_EQP_ID}&RESULT_ID=${ p.RESULT_ID} " target="dialog" rel="dlg_page_${status.count}"  mask="true" title="巡检结果" width="700" height="450" style="color:#8175EE;">
		                	<span>查看巡检详情</span>
		                </a> </td>
		                	</c:when>
		                	<c:otherwise>
		                		<td><a href="<%=request.getContextPath()%>/inspection/inspectionDetail.do?DEVICENO=${p.NO}&PHY_EQP_ID=${p.PHY_EQP_ID}&RESULT_ID=${ p.RESULT_ID} " target="dialog" rel="dlg_page_${status.count}"  mask="true" title="巡检结果" width="700" height="450" style="color:#8175EE;">
		                	<span>查看巡检详情</span>
		                </a> </td>
		                	</c:otherwise>
		                </c:choose>
		                
		              <!--   <td>${p.ASSEMBLE_NAME}</td>  -->
		            </tr>
	          	</c:forEach> 
				</tbody>
			</table>
		
		<div class="panelBar" >
			<div class="pages">
				<span>显示</span>
				<select class="" id="nppsel" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
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