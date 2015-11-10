<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/select/selectEqpTable.do">  

</form> 

<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/select/selectEqpTable.do" method="post" rel="pagerForm">
			<input type="hidden" name="pageNum" value="1" />  
			<input type="hidden" name="numPerPage" value="10" />
			  
		<input type="hidden" id="selectedId_demo"/>
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>我的客户：</label>
					<input type="text" name="res_spec_id"/>
				</li>
			</ul>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
					<li><a class="button" href="demo_page6.html" target="dialog" rel="dlg_page1" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
		</form>
	</div>
	
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="demo_page4.html" target="navTab"><span>添加</span></a></li>
				<li><a class="delete" href="#" onclick="alertMsg.confirm('确定要删除吗？')"><span>删除</span></a></li>
				<li><a class="edit" href="demo_page4.html" target="navTab"><span>修改</span></a></li>
				<li class="line">line</li>
			</ul>
		</div>
		<div class="tableList" layoutH="116">
			<table class="list" width="98%">
				<thead>
					<tr>
						<th width="25"></th>
						<th width="80">客户号</th>
						<th width="100">客户名称</th>
						<th width="100">客户划分</th>
						<th>证件号码</th>
						<th align="right" width="100">信用等级</th>
						<th width="100">企业性质</th>
						<th width="100">建档日期</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" name="objectId" value="1"/></td>
						<td>iso127309</td>
						<td>北京市政府咿呀哟</td>
						<td>政府单位</td>
						<td>0-0001027766351528</td>
						<td>四等级</td>
						<td>政府单位</td>
						<td>2009-05-21</td>
					</tr>
				<c:forEach var="p" items="${result}" varStatus="status" >   
		            <tr target="sid" >  
		                <td></td>  
		                <td>${p.deviceId}</td>  
		                <td>${p.deviceNo}</td>  
		                <td></td>  
		                <td></td>  
		            </tr>  
	          	</c:forEach>
	
				</tbody>
			</table>
		</div>
		
		<div class="panelBar" >
			<div class="pages">
				<span>显示</span>
				<select name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
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