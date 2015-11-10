<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

	<!--时间段管理-->
<div class="page">
	<div class="pageContent">
		<form action="<%=request.getContextPath()%>/accessControl/updateOperateTime.do" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layouth="56">
			<div style="height: 350px; width:800px; overflow: auto;">
			<input size="30" name="opTimeId"  type="hidden" value="${opt.opTimeId}" class="required"></input>
				<dl class="nowrap">
					<dt>名称：</dt>
					<dd><input size="30" name="name" value="${opt.name}" class="required"></input></dd>
				</dl>
				<dl class="nowrap"></dl>
				<p><label></label>开始时间</p>
				<p>结束时间</p>
				<p>
					<label>星期一：</label>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="monStartTime" value="${opt.monStartTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<p>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="monEndTime" value="${opt.monEndTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>

				<p>
					<label>星期二：</label>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="tuesStartTime" value="${opt.tuesStartTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<p>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="tuesEndTime" value="${opt.tuesEndTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>

				<p>
					<label>星期三：</label>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="wedStartTime" value="${opt.wedStartTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<p>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="wedEndTime" value="${opt.wedEndTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>

				<p>
					<label>星期四：</label>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="thurStartTime" value="${opt.thurStartTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<p>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="thurEndTime" value="${opt.thurEndTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<p>
					<label>星期五：</label>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="friStartTime" value="${opt.friStartTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<p>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="friEndTime" value="${opt.friEndTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				
				<p>
					<label>星期六：</label>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="satStartTime" value="${opt.satStartTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<p>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="satEndTime" value="${opt.satEndTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				
				<p>
					<label>星期日：</label>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="sunStartTime" value="${opt.sunStartTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<p>
					<input class="date textInput readonly valid required" type="text" readonly="true" mmstep="15" datefmt="HH:mm" name="sunEndTime" value="${opt.sunEndTime}"></input>
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>			    
    			</div>
			</div>
			<div class="formBar">
				<ul>
				    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div>
				    </li>
					    <li>
					    	<div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div>
					    </li>
				    </ul>
    		</div>
		</form>
	</div>
</div>
