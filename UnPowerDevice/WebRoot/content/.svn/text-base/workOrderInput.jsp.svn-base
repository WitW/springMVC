<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
var num=1;
function addCondition(){
	num++;
	var html="<dl><dt>设备编码：</dt><dd>"+
		"<input name='deviceNo"+num+"' class='required' type='text' size='30'/></dd></dl>"+
		"<dl style='width:600px;'><dt>端子编码：</dt><dd>"+
		"<input name='portNo"+num+"' class='required' type='text' size='30'/></dd></dl>";  

	$("#wkodMain").append(html);
	$("#conNum").val(num);
}

function delCondition(){
	//alert(num);
	if(num > 1){
		$("#wkodMain dl:last").remove();
		$("#wkodMain dl:last").remove();
		num--;
		$("#conNum").val(num);
	}
	
}
/**
function validateCon(obj){

	var devNo = $(obj).parents("dl").prev().prev().find("input").val();
	
	var portNo = $(obj).parents("dl").prev().find("input").val();
	
	$.post("<%=request.getContextPath()%>/workOrder/validateCondition.do",{"deviceNo":devNo,"portNo":portNo},function(result){
		
	});
}*/
</script>
<div class="page">
	<div class="pageContent">
		<form method="post" action="<%=request.getContextPath()%>/workOrderSer/saveWorkOrder.do" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56" id="wkodMain">
				<input type="hidden" id="conNum" name="conNum" value="1"/>
				<p>
					<label>工单ID：</label>
					<input name="workOrderId" class="required" type="text" size="30" value="" alt="请输入工单ID"/>
				</p>
				<p>
					<label>局向：</label>
					<input name="tml" type="text" size="30" />	</p>
				<p style="width:300px;">
					<label style="width:80px;">PON类型：</label>
					<select name="ponType" size="30" class="combox" >
						<option value = "EPON" selected="selected">EPON</option>
						<option value = "GPON">GPON</option>
					</select>	</p>
				<p>
					<label>装维人员工号：</label>
					<!-- input name="staffNbr" class="required" type="text" size="30" alt="请输入工号"/ -->
					<select id="staffNbr" name="staffNbr" class="combox">
						<c:forEach var="a" items="${staff}" varStatus="status">
							<option value="${a.staffNbr}">${a.staffNbr}</option>
						</c:forEach>
				   </select>
				   
				</p>
				<p>
					<label>业务类别：</label>
					<input name="busyType" class="required" type="text" size="30" alt="请输入业务类别"/>
				</p>
				<p style="width:300px;">
					<label style="width:80px;">工程性质：</label>
					<input name="event" class="required" type="text" size="30" alt="请输入工程性质"/>
				</p>
				<p>
					<label>服务等级：</label>
					<input name="dredgeLevel" type="text" size="30"/>
				</p>
				<p>
					<label>预约时间：</label>
					<input name="completeTime" type="text" dateFmt="yyyy-MM-dd HH:mm" class="date" size="30" /><a class="inputDateButton" href="#">选择</a>
				</p>
				<p style="width:300px;">
					<label style="width:80px;">客户名称：</label>
					<input name="customer" type="text" class="required"  size="30" alt="请输入客户名称"/>
				</p>
				<p>
					<label>接入号：</label>
					<input name="accessNum"type="text" class="required"  size="30" alt="请输入接入号"/>
				</p>
				<p>
					<label>客户联系电话：</label>
					<input name="telephone" type="text" class="required phone"  size="30" alt="请输入客户联系电话"/>
				</p>
				<p style="width:300px;">
					<label style="width:80px;">客户地址：</label>
					<input name="address" type="text" class="required"  size="30" alt="请输入客户地址"/>
				</p>
				<div class="divider"></div>
				<p>
					<label>新光路编码：</label>
					<input name="newGlNo" type="text" size="30"/>
				</p>
				 <div>
					<label>新资源信息：</label>
					<textarea name="newRes" cols="45" rows="5"></textarea>
				</div>
				<div class="divider"></div>
				<p>
					<label>旧光路编码：</label>
					<input name="oldGlNo" type="text" size="30"/>
				</p>
				<div>
					<label>旧资源信息：</label>
					<!-- textarea name="oldRes" cols="45" rows="5" readonly="readonly"></textarea -->
					<textarea name="oldRes" cols="45" rows="5"></textarea>
				</div> 
				<div class="divider"></div>
				
				<dl class="nowrap">
					<dd>
						<div class="buttonActive"><div class="buttonContent"><button type="button" id="addCon" onclick="addCondition()">增加条件</button></div></div>
						<div class="buttonActive"><div class="buttonContent"><button type="button" id="delCon" onclick="delCondition()">删除最后一个条件</button></div></div>
					</dd>
				</dl>
				
				<dl>
					<dt>设备编码：</dt>
					<dd><input name="deviceNo1" class="required" type="text" size="30"/></dd>
				</dl>
				<dl style="width:600px;">
					<dt>端子编码：</dt>
					<dd><input name="portNo1" class="required" type="text" size="30"/></dd>
				</dl>
				
				<!-- dl style="width:60px;">
					<dd style="width:50px;"><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="validateCon(this)">验证</button></div></div></dd>
				</dl -->

				
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>