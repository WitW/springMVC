<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zbiti.common.model.table.Page" %>
<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="<%=request.getContextPath()%>/inspection/inspectionPage.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>设备编码：</label>
				    <input type="text" name="deviceNo" alt="输入设备编码" />
				</li>
				<li>
					<label>巡检时间：</label>
				    <input name="inspectionTime1" type="text" dateFmt="yyyy/MM/dd" class="date" size="30"/><a class="inputDateButton" href="#">选择</a>
				</li>
				<li>
				<label>&nbsp;&nbsp;&nbsp;&nbsp;到</label>
				  <input name="inspectionTime2" type="text" dateFmt="yyyy/MM/dd" class="date" size="30"/><a class="inputDateButton" href="#">选择</a>
				</li>
			</ul>
			<div class="subBar" >
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
					<li>&nbsp;&nbsp;</li>
				</ul>
			</div>
		</div>
		</form>
	</div>
	
	<div class="pageContent">
			<table class="table" width="98%" layoutH="136">
				<thead>
					<tr>
						<!-- <th width="25"><input class="checkboxCtrl" type="checkbox" group="roleIds"></input></th> -->
						<th width="25">序号</th>
						<th width="100">设备编码</th>
						<th width="100">巡检人员</th>
						<th width="100">不匹配数量</th>
						<th width="100">巡检时间</th>
						<th width="100">查看巡检结果</th>
						<!-- <th width="100">模块地址</th> -->
					</tr>
				</thead>
				
			</table>
	</div>
</div>