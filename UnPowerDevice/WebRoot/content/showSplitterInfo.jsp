<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.zbiti.common.model.table.Page"%>
<%@ page import="com.zbiti.util.Util"%>

<style>
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

.cTrueIN {
	text-align: center;
	font-size: 20px;
}

.cFalseIN {
	text-align: center;
	font-size: 20px;
}
</style>

<div class="page">

	<div class="true_false">
		<table>
			<tr>
				<td style="width: 45px;">&nbsp;&nbsp;</td>
				<td style="text-align: right;">匹配:</td>
				<td class="cTrue"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/true.png"></td>
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


	<div class="content">
		<table>
			<tr>
				<td>
					<table>
						<c:forEach items="${inPortCheckResultInfo}" var="p">
							<tr>
								<c:choose>
									<c:when test="${p.result_check == 0}">
										<td style="font-size: 20px;">
										<div>&nbsp;</div>
										<div>IN:</div>
										</td>
										<td >
										<div>&nbsp;</div>
										<div class="xianzhi">
										<img  height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/setAside.png">
										</div>
										</td>
										<td width="50px">&nbsp;</td>
									</c:when>
									<c:when test="${p.result_check == 1}">
										<td style="font-size: 20px;">
										<div>&nbsp;</div>
										<div>IN:</div>
										</td>
										<td>
										<div>&nbsp;</div>
										<div class="zhanyong">
										<img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/divine.png">
										</div>
										</td>
										<td width="50px">&nbsp;</td>
									</c:when>
									<c:when test="${p.result_check == 2}">
										<td style="font-size: 20px;">
										<div>&nbsp;</div>
										<div>IN:</div>
										</td>
										<td>
										<div>&nbsp;</div>
										<div class="cTrue">
										<img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/true.png">
										</div>
										</td>
										<td width="50px">&nbsp;</td>
									</c:when>
									<c:otherwise>
										<td style="font-size: 20px;">
										<div>&nbsp;</div>
										<div>IN:</div>
										</td>
										<td>
										<div>&nbsp;</div>
										<div class="cFalseIN">
										<img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/false.png">
										</div>
										</td>
										<td width="50px">&nbsp;</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</table></td>
				<td>
					<table>
						<c:choose>
							<c:when test="${size == 0 }">
								<tr>
									<c:forEach var="p" items="${_outPortCheckResultInfo}"
										varStatus="pstatus">
										<c:choose>
											<c:when test="${p.result_check == 0}">
												<td>
													<div>${pstatus.count}</div>
													<div class="xianzhi"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/setAside.png"></div></td>
											</c:when>
											<c:when test="${p.result_check == 1}">
												<td>
													<div>${pstatus.count}</div>
													<div class="zhanyong"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/divine.png"></div></td>
											</c:when>
											<c:when test="${p.result_check == 2}">
												<td>
													<div>${pstatus.count}</div>
													<div class="cTrue"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/true.png"></div></td>
											</c:when>
											
											<c:otherwise>
												<td>
													<div>${pstatus.count}</div>
													<div class="cFalse"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/false.png"></div></td>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="p" items="${list_outPortCheckResultInfo}"
									varStatus="pstatus">
									<tr>
										<c:forEach var="m" items="${p}" varStatus="mstatus">
											<c:choose>
											
												<c:when test="${m.result_check == 0}">
													<td><c:choose>
															<c:when test="${pstatus.count  == 1}">
																<div>${mstatus.count}</div>
															</c:when>
															<c:when test="${pstatus.count  == 2}">
																<div>${mstatus.count+16}</div>
															</c:when>
															<c:when test="${pstatus.count  == 3}">
																<div>${mstatus.count+32}</div>
															</c:when>
															<c:otherwise>
																<div>${mstatus.count+48}</div>
															</c:otherwise>
														</c:choose>
														<div class="xianzhi"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/setAside.png"></div></td>
												</c:when>
												
												<c:when test="${m.result_check == 1}">
													<td><c:choose>
															<c:when test="${pstatus.count  == 1}">
																<div>${mstatus.count}</div>
															</c:when>
															<c:when test="${pstatus.count  == 2}">
																<div>${mstatus.count+16}</div>
															</c:when>
															<c:when test="${pstatus.count  == 3}">
																<div>${mstatus.count+32}</div>
															</c:when>
															<c:otherwise>
																<div>${mstatus.count+48}</div>
															</c:otherwise>
														</c:choose>
														<div class="zhanyong"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/divine.png"></div></td>
												</c:when>
												
												<c:when test="${m.result_check == 2}">
													<td><c:choose>
															<c:when test="${pstatus.count  == 1}">
																<div>${mstatus.count}</div>
															</c:when>
															<c:when test="${pstatus.count  == 2}">
																<div>${mstatus.count+16}</div>
															</c:when>
															<c:when test="${pstatus.count  == 3}">
																<div>${mstatus.count+32}</div>
															</c:when>
															<c:otherwise>
																<div>${mstatus.count+48}</div>
															</c:otherwise>
														</c:choose>
														<div class="cTrue"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/true.png"></div></td>
												</c:when>
												
												<c:otherwise>
													<td><c:choose>
															<c:when test="${pstatus.count  == 1}">
																<div>${mstatus.count}</div>
															</c:when>
															<c:when test="${pstatus.count  == 2}">
																<div>${mstatus.count+16}</div>
															</c:when>
															<c:when test="${pstatus.count  == 3}">
																<div>${mstatus.count+32}</div>
															</c:when>
															<c:otherwise>
																<div>${mstatus.count+48}</div>
															</c:otherwise>
														</c:choose>
														<div class="cFalse"><img height="25.6px" width="22.4px" src="<%=request.getContextPath()%>/js/dwz/themes/default/images/false.png"></div></td>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									<tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
					</td>
			</tr>
		</table>
	</div>

</div>
