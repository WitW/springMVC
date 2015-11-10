<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.zbiti.common.model.table.Page" %>
<%
	Page pg = (Page)request.getAttribute("page");
	
%>
<script type="text/javascript">

$(function (){
	$("#nppselMap").val("<%=pg.getShowCount()%>");
});

	var mapList = new Array();
	mapList = JSON.parse('${maps}');
	var point=null;
	if(mapList.length>=1){
		point = new BMap.Point(mapList[0].longitude, mapList[0].latitude);
	}else{
		point = new BMap.Point("118.749503", "31.986120");	
	}

	var map = new BMap.Map("containerDevice");
	//var point = new BMap.Point("118.749503", "31.986120");
	map.centerAndZoom(point, 13);
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.OverviewMapControl());
	map.addControl(new BMap.MapTypeControl());
	map.setCurrentCity("南京"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用 
	map.enableScrollWheelZoom(); //启用滚轮放大缩小，默认禁用
	map.enableContinuousZoom(); //启用地图惯性拖拽，默认禁用
	
	//添加3个点
	//	var point1 = new BMap.Point(118.749503, 31.986120);
	//	var point2 = new BMap.Point(118.781347, 31.972684);
	//	var point3 = new BMap.Point(118.781347, 31.983222);
	//	var point4 = new BMap.Point(118.755326, 31.970322);
	//	var points = [ point1, point2, point3, point4 ];

	var marker = new Array(mapList.length);
	var infotxt = new Array(mapList.length);
	for ( var i = 0; i < mapList.length; i++) {
		var mapBean = mapList[i];
		var imgPath = '<%=request.getContextPath()%>/js/dwz/themes/default/images/icon_off_2.png';
		var devState = "异常关门";
		if(mapBean.state == 1){
			imgPath = '<%=request.getContextPath()%>/js/dwz/themes/default/images/icon_on.png';
			devState = "开门";
		}else if(mapBean.state == 2){
			imgPath = '<%=request.getContextPath()%>/js/dwz/themes/default/images/icon_off.png';
			devState = "关门";
		} 
		var icon = new BMap.Icon(
				imgPath,
				new BMap.Size(44, 44), 
				{
					anchor : new BMap.Size(20, 15)
				});
		var ponit = new BMap.Point(mapBean.longitude, mapBean.latitude);
		marker[i] = new BMap.Marker(ponit, {
			icon : icon
		}); // 创建标注
		var txt = mapBean.deviceNo;
		var label = new BMap.Label(txt, {
			offset : new BMap.Size(35, 0)
		});
		label.setStyle( { //给label设置样式，任意的CSS都是可以的
					color : "red", //颜色
					fontSize : "14px", //字号
					border : "1",
					textAlign : "center", //文字水平居中显示
					cursor : "pointer",
					background : "#FFFFFF"

				});
		marker[i].setLabel(label);//标注上添加文字
		var staffNbr= mapBean.staffNbr==null?"":mapBean.staffNbr;
		var opdate=mapBean.operDate==null?"":mapBean.operDate;
		infotxt[i] = "<p style='font-size:14px;height:25;line-height:25px;'>设备编码："+mapBean.deviceNo+"</p>"
				+ "<p style='font-size:14px;height:25;line-height:25px;'>设备名称："+mapBean.deviceName+"</p>"
				+ "<p style='font-size:14px;height:25;line-height:25px;'>设备状态：" + devState + "</p>"
				+ "<p style='font-size:14px;height:25;line-height:25px;'>最后操作用户："+staffNbr+"</p>"
				+ "<p style='font-size:14px;height:25;line-height:25px;'>最后操作时间："+opdate+"</p>"
				+ "<p style='font-size:12px;color:#00CC33;height:15;'>经度："
				+ mapBean.longitude
				+ "&nbsp;&nbsp;纬度："
				+ mapBean.latitude
				+ "</p>";
		marker[i].addEventListener("click", function(e) {
			test(e);
		});// 将标注添加到地图中
		map.addOverlay(marker[i]);
	
	}
	//	function showInfo(e){
	//alert(e.point.lng + ", " + e.point.lat);
	//}
	//map.addEventListener("click", showInfo);
	function test(e) {
		for ( var i = 0; i < marker.length; i++) {
			//alert(mapList[i].NO);
			if (e.target == marker[i]) {
				e.target.openInfoWindow(new BMap.InfoWindow(infotxt[i]));
			}
		}
	}

	function makeMaker(marker, map, infoWindow) {
		marker.openInfoWindow(infoWindow);
	}
</script>
<form id="pagerForm" method="post" action="<%=request.getContextPath()%>/accessControl/devicePositionMap.do">  

			<input type="hidden" name="pageNum" value="1" /><!--【必须】value=1可以写死-->
			<input type="hidden" name="numPerPage" value="${page.showCount}"/>
			<input type="hidden" name="currentPage" value="${page.currentPage}"/>
</form>
<div style="display: block;" class="page unitBox" id="mainDiv">
	<div style="height: 136px; overflow: auto;"
		class="pageContent sortDrag" selector="h1" layouth="0">
		<div class="panel collapse" defh="35">
			<h1>检索条件</h1>
			<div>
				<div class="searchBar">
					<form action="<%=request.getContextPath()%>/accessControl/devicePositionMap.do" method="post" class="pageForm required-validate" onsubmit="return divSearch(this, 'mainDiv');">
						<table class="searchContent">
							<tbody>
								<tr>
									<td>设备编码：<input class="textInput" type="text" name="deviceNo" value="${deviceNo}"></input></td>
		    						<td>
		    							<div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div>
		    						</td>
	    						</tr>
	    					</tbody>
	    				</table>
    				</form>
				</div>
			</div>
		</div>
		<div class="panel collapse" defh="475">
			<h1>设备坐标</h1>
			<div>
				<div id="containerDevice" style="height: 470px; width: 100%;"></div>
			</div>
		</div>
		<div class="panel collapse" defh="450">
			<h1>数据列表</h1>
			<div style="height: 100%; width: 97.455%;">
			<table class="table" layoutH="178" >
				<thead>
					<tr>
						<th width="50">序号</th>
						<th width="80">设备编码</th>
						<th width="80">设备名称</th>
						<th width="100">门禁状态</th>
						<th width="100">经度</th>
						<th width="130">纬度</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="p" items="${DeviceMap}" varStatus="status" >   
		            <tr>  
		                <td>${status.count + (page.currentPage-1)*page.showCount}</td>
		                <td>${p.deviceNo}</td>
		                <td>${p.deviceName}</td>
					    <c:choose>
					    	<c:when test="${p.state=='1'}">
					                <td>开门</td>
					        </c:when>
					        <c:when test="${p.state=='2'}">
					                <td>关门</td>
					        </c:when>				                	
					        <c:otherwise>
					               <td>异常关门</td>
					        </c:otherwise>
					    </c:choose>		                
		                <td>${p.longitude}</td>
		                <td>${p.latitude}</td>
		            </tr>
	          	</c:forEach>
				</tbody>
			</table>
			<div class="panelBar" >
					<div class="pages">
						<span>显示</span>
						<select class="" id="nppselMap" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
							<option value="15">15</option>
							<option value="20">20</option>
							<option value="30">30</option>
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
	</div>
</div>

