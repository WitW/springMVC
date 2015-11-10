<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zbiti.common.model.table.Page" %>
<%@ page import="com.zbiti.mvc.android.model.DevicePortInfo" %>
<%
	Page pg = (Page)request.getAttribute("page");
	
	List<String> li = (List)request.getAttribute("listDev");
	
	List<DevicePortInfo> result = (List)request.getAttribute("result");	
	
%>
<script type="text/javascript">
$(function (){
	$("#nppseld").val("<%=pg.getShowCount()%>");
	$("#areaId").val("${areaId}");
});

$.fn.extend({
 selectedTodo: function(){
 
			function _getIds(selectedIds, targetType){
				var ids = "";
				var $box = targetType == "dialog" ? $.pdialog.getCurrent() : navTab.getCurrentPanel();
				$box.find("input:checked").filter("[name='"+selectedIds+"']").each(function(i){
					var val = $(this).val();
					ids += i==0 ? val : ","+val;
				});
				return ids;
			}
			
		  return this.each(function(){
				var $this = $(this);
				var selectedIds = $this.attr("rel") || "ids";
				var postType = $this.attr("postType") || "map";

				$this.click(function(){
					var targetType = $this.attr("targetType");
					var ids = _getIds(selectedIds, targetType);
					
					//if (!ids) {
					//	alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
					//	return false;
					//}
					
					var _callback = $this.attr("callback") || (targetType == "dialog" ? dialogAjaxDone : navTabAjaxDone);
					if (! $.isFunction(_callback)) _callback = eval('(' + _callback + ')');
					
					function _doPost(){
						$.ajax({
							type:'POST', url:$this.attr('href'), dataType:'json', cache: false,
							data: function(){
								if (postType == 'map'){
									return $.map(ids.split(','), function(val, i) {
										return {name: selectedIds, value: val};
									})
								} else {
									var _data = {};
									_data[selectedIds] = ids;
									return _data;
								}
							}(),
							success: _callback,
							error: DWZ.ajaxError
						});
					}
					var title = $this.attr("title");
					if (title) {
						alertMsg.confirm(title, {okCall: _doPost});
					} else {
						_doPost();
					}
					return false;
				});
				
			});
}

});

</script>
<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/accessControl/getDeviceInfo.do">  

			<input type="hidden" name="pageNum" value="1" /><!--【必须】value=1可以写死-->
			<input type="hidden" name="numPerPage" value="${page.showCount}"/>
			<input type="hidden" name="currentPage" value="${page.currentPage}"/>
</form> 

<div class="page">
	<div class="pageHeader">
		<form onsubmit="return dwzSearch(this, 'dialog');" action="<%=request.getContextPath()%>/accessControl/getDeviceInfo.do" method="post" rel="pagerForm">
		<input type="hidden" name="staffId" value="${staffId}"/>
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>设备编码：</label>
					<input type="text" name="deviceNo" value="${deviceNo}"/>
				</li>
				<!-- <li><label>地区：</label><select id="areaId" name="areaId" class="combox">
								<option value="">--请选择--</option>
								<c:forEach var="a" items="${area}" varStatus="status">
									<option value="${a.AREA_ID}">${a.NAME}</option>
								</c:forEach>
							</select></li> -->
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
					<li><a class="icon" href="<%=request.getContextPath()%>/accessControl/saveStaffDevice.do?staffId=${staffId}" rel="devids" postType="string" targetType="dialog" target="selectedTodo"><span style="background:url(<%=request.getContextPath()%>/js/dwz/themes/default/images/save.jpg) no-repeat;background-position:0 4px;">保存</span></a></li>
				</ul>
			</div>
			<table class="table" layoutH="147">
				<thead>
					<tr>
						<th width="30"><input class="checkboxCtrl" type="checkbox" group="devids"></th>
						<th width="50">序号</th>
						<th width="200">设备编码</th>
						<th width="200">设备名称</th>
					</tr>
				</thead>
				<tbody>
	          	<%
	          		for(int i=0; i < result.size(); i++){
	          			DevicePortInfo info = result.get(i);
	          			
	          			boolean flag=false;
		            	for(String id : li){
		            		if(id.equals(info.getDeviceId())){
		            			flag = true;
		            		}
		            	} 
		            	if(flag){%>
		            	 <tr target="ids" rel="${p.deviceId}">
		            		<td><input type="checkbox" name="devids" value="<%=info.getDeviceId()%>" checked="checked"/></td>
		            	<%}else{%>
		            	 <tr target="ids" rel="${p.deviceId}">
		            		<td><input type="checkbox" name="devids" value="<%=info.getDeviceId()%>"/></td>
		            	<%}%>
	          	   <td><%=i+1%></td>
	               <td><%=info.getDeviceNo()%></td>
		           <td><%=info.getDeviceName()%></td>
		           </tr>
	          	<%}%>
	          	
				</tbody>
			</table>
		<div class="panelBar" >
			<div class="pages">
				<span>显示</span>
				<select class="" id="nppseld" name="numPerPage" onchange="dialogPageBreak({numPerPage:this.value})">
					<option value="15">15</option>
					<option value="20">20</option>
					<option value="50">50</option>
					<option value="100">100</option>
					<option value="200">200</option>
				</select>
				<span>条，共${page.totalResult}条</span>
			</div>
			<div class="pagination" targetType="dialog" totalCount="${page.totalResult}" numPerPage="${page.showCount}" pageNumShown="10" currentPage="${page.currentPage}">
			</div>
		</div>
	</div>
</div>