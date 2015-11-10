<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.zbiti.common.model.table.Page"%>
<%@ page import="com.zbiti.util.Util"%>

<style>
.table1 {
	text-align: center;
}

.table2 {
	text-align: center;
}

.div {
	text-align: center;
	height: 350px;;
	overflow: auto;
	padding-top: 0px;
}

.true_false {
	text-align: center;
}

.content {
	text-align: center;
}

.cTrue {
	text-align: center;
}

.cFalse {
	text-align: center;
}

.xianzhi {
	text-align: center;
}

.zhanyong {
	text-align: center;
}
</style>

<div class = "page">

	<div class = "true_false">
		<table style="border: 0px;">
			<tr>
				<td style="text-align: right; border: 0px;">匹配:</td>
				<td class="cTrue" ><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/true.png"></td>
				<td style="width: 30px;">&nbsp;</td>
				<td style="text-align: right;">不匹配:</td>
				<td class="cFalse"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/false.png"></td>
				<td style="width: 30px;">&nbsp;</td>
				<td style="text-align: right;">闲置:</td>
				<td class="xianzhi"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/setAside.png"></td>
				<td style="width: 30px;">&nbsp;</td>
				<td style="text-align: right;">占用:</td>
				<td class="zhanyong"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/divine.png"></td>
			</tr>
		</table>
	</div>


	<div class = "content">
		<div class = "table1">
			<table style = "border: 0px" >
				<tr>
					<td
						style="font-size: 20px;text-align: center;width: 15px;height: 25.6px; border: 0px;"></td>
					<c:forEach var = "p" varStatus = "pstatus" begin = "1" end = "${size}"
						step = "1">
						<td
							style = "font-size: 20px;text-align: center;width: 22.4px;height: 25.6px;">${pstatus.count}</td>
					</c:forEach>
				</tr>
			</table>
		</div>
		
		
		<div class = "div">
			<c:forEach var = "p" items = "${slot_unit_port_list }" varStatus = "pstatus">
				<div class = "table2">
					<c:forEach var = "a" items="${p}" varStatus = "astatus">
						<table style = "border: 1px">
								<tr style = "border: 1px">
									<c:choose>
										<c:when test = "${astatus.count <= 9}">
											<td style = "font-size: 18px;text-align: center;width: 22.4px;">U0${astatus.count}</td>
										</c:when>
										<c:otherwise>
											<td style = "font-size: 18px;text-align: center;width: 22.4px;">U${astatus.count}</td>
										</c:otherwise>
									</c:choose>
									<c:forEach var = "c" items = "${a}" varStatus = "cstatus">
										<c:choose>
											<c:when test = "${c.result_check == 0}">
												<td class = "xianzhi"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/setAside.png"></td>
											</c:when>
											
											<c:when test = "${c.result_check == 1}">
												<td class = "zhanyong"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/divine.png"></td>
											</c:when>
											
											<c:when test = "${c.result_check == 2}">
												<td class = "cTrue"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/true.png"></td>
											</c:when>
											
											<c:otherwise>
												<td class = "cFalse"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/false.png"></td>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</tr>
						</table>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
		
	</div>

</div>
