<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>通鼎智能ODN管理平台</title>

<link href="<%=request.getContextPath()%>/js/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath()%>/js/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=request.getContextPath()%>/js/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="<%=request.getContextPath()%>/js/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="<%=request.getContextPath()%>/js/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="<%=request.getContextPath()%>/js/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/xheditor/xheditor-1.1.14-zh-cn.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dwz/chart/raphael.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dwz/chart/g.raphael.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dwz/chart/g.bar.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dwz/chart/g.line.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dwz/chart/g.pie.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dwz/chart/g.dot.js"></script>

<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.print.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/json2.js" type="text/javascript"></script>

<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script type="text/javascript"
		src="http://api.map.baidu.com/api?v=1.5&ak=5a2f7a97cf059bfa876735349e3639c0"></script>
			
<script src="<%=request.getContextPath()%>/js/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("<%=request.getContextPath()%>/js/dwz/dwz.frag.xml", {
		loginUrl:"/login/loginIn.do", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"<%=request.getContextPath()%>/js/dwz/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});
//清理浏览器内存,只对IE起效，FF不需要
if ($.browser.msie) {
	window.setInterval("CollectGarbage();", 10000);
}
</script>
</head>


<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="#">标志</a>
				<ul class="nav">
					<li><a>${sessionScope.staffNbr}，&nbsp;欢迎您!&nbsp;&nbsp;|&nbsp;&nbsp;</a><a href="<%=request.getContextPath()%>/login/logoff.do" target="_top">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
				
					<c:if test="${liStr !=null && liStr!=''}">
						<div class="accordionHeader">
							<h2><span>Folder</span>工单操作</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">
								${liStr}
							</ul>
						</div>
					</c:if>
					
					<c:if test="${liVers !=null && liVers!=''}">
						<div class="accordionHeader">
							<h2><span>Folder</span>版本管理</h2>
						</div>
					
						<div class="accordionContent">
							<ul class="tree treeFolder">
								${liVers}
							</ul>
						</div>
					</c:if>
					
					<c:if test="${liAuts !=null && liAuts!=''}">
						<div class="accordionHeader">
							<h2><span>Folder</span>权限管理</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">
								${liAuts}
							</ul>
						</div>
					</c:if>
					
					<c:if test="${doorAccess !=null && doorAccess!=''}">
						<div class="accordionHeader">
								<h2><span>Folder</span>门禁管理</h2>
							</div>
							<div class="accordionContent">
								<ul class="tree treeFolder">
									${doorAccess}
								</ul>
						</div>
					</c:if>
					
					<c:if test="${inspection !=null && inspection!=''}">
						<div class="accordionHeader">
								<h2><span>Folder</span>巡检结果</h2>
							</div>
							<div class="accordionContent">
								<ul class="tree treeFolder">
									${inspection}
								</ul>
						</div>
					</c:if>

					<!-- div class="accordionHeader">
						<h2><span>Folder</span>典型页面</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder treeCheck">
							<li><a href="demo_page1.html" target="navTab" rel="demo_page1">查询我的客户</a></li>
							<li><a href="demo_page1.html" target="navTab" rel="demo_page2">表单查询页面</a></li>
							<li><a href="demo_page4.html" target="navTab" rel="demo_page4">表单录入页面</a></li>
							<li><a href="demo_page5.html" target="navTab" rel="demo_page5">有文本输入的表单</a></li>
							<li><a href="javascript:;">有提示的表单输入页面</a>
								<ul>
									<li><a href="javascript:;">页面一</a></li>
									<li><a href="javascript:;">页面二</a></li>
								</ul>
							</li>
							<li><a href="javascript:;">选项卡和图形的页面</a>
								<ul>
									<li><a href="javascript:;">页面一</a></li>
									<li><a href="javascript:;">页面二</a></li>
								</ul>
							</li>
							<li><a href="javascript:;">选项卡和图形切换的页面</a></li>
							<li><a href="javascript:;">左右两个互动的页面</a></li>
							<li><a href="javascript:;">列表输入的页面</a></li>
							<li><a href="javascript:;">双层栏目列表的页面</a></li>
						</ul>
					</div-->
					
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						
					</div>
				</div>
			</div>
		</div>

	</div>

<!--	<div id="footer">Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">DWZ团队</a> Tel：010-52897073</div> -->


</body>
</html>