<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String listCheckedVal = (String)request.getAttribute("listCheckedVal");
	String roleId = (String)request.getAttribute("roleId");
	
	
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>

</head>
<body>
<div class="pageContent" style="width: 400px;">
	<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
		<ul id="roleActTr" class="tree treeCheck" oncheck="checkCallback">
			${actList}
		</ul>
	</div>
	
		<form id="saveRoActForm" action="<%=request.getContextPath()%>/authority/updateRoleInfo.do" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
			<input type="hidden" name="roleId"  id="roleId" value="${roleId}"/>
			<input type="hidden" name="roleValue" id="roleValue" value="${roleValue}"/>
			<div class="formBar" align="right">
				<ul>
				    <li><div class="buttonActive"><div class="buttonContent">
				    	<button type="submit">保存</button></div></div>
				    </li>
					    <li>
					    	<div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div>
					    </li>
				    </ul>
    		</div>
		</form>
</div>
</body>
</html>
<script type="text/javascript">
//JSON.stringify(JSON.parse(result)[0]);

var arr = new Array();
arr=JSON.parse('<%=listCheckedVal%>');

function checkCallback(json){
    	//判断是否是数组
    	if('[object Array]' == Object.prototype.toString.call(json.items)){
    		arr = new Array();
    		for(var i=0; i < json.items.length; i++){
    			if(json.items[i].name!="0"){
    				if(json.checked){
    					arr.push(json.items[i].value);
    				}
    			}
    		}
    	}else{
    		if(json.checked){
    			arr.push(json.items.value);
    		}else{
    			arr = removeItem(arr,json.items.value);
    		}
    	}
    	
    var roleValue = 0;
   // arr=arr.reverse().join(",").match( /([^,]+)(?!.*\1)/ig).reverse();
    
	$.each(arr,function(i,item){
		var tmp=1;
		for(var j=1;j <= item; j++){
			tmp = tmp*2
		}
		roleValue += tmp;
	});
	$("#roleValue").val(roleValue);
} 


/**
*  删除数组中的元素val
**/
function removeItem(ar,val){
	 $.each(ar,function(i,item){
		if(item==val){
			ar.splice(i,1)
		}
 	});
 	return ar;
}
</script>