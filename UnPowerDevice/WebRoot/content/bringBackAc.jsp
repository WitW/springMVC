<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<label>客户端功能</label><br>
<div layoutH="60" style="margin-left:20px;">
	<ul>
		<c:forEach var="a" items="${listAc}" varStatus="status" > 
			<li><input type="checkbox" name="acId" value="{id:'${a.actionId}', name:'${a.actionName}',actype='${a.actionType}'}" />${a.actionName}</li>
		</c:forEach>
	</ul>
</div>
<div style="margin-right:20px;">
	<div class="buttonActive"><div class="buttonContent"><button type="button" multLookup="acId">确定</button></div></div>
</div>


