<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String code="0";
	int newCode=1;
	if(request.getAttribute("code")!=null && !request.getAttribute("code").equals("")){
		code = (String)request.getAttribute("code");
		newCode = Integer.parseInt(code) + 1;
	}
 %>
<html>
  <head>
    <title>版本上传页面</title>
  </head>
  
<body>
<div class="page"><div align="left"> 
	</div><div class="pageContent"><div align="left"> 
		</div><form method="post" action="<%=request.getContextPath()%>/upload/uploadVersion.do" class="pageForm required-validate" onsubmit="return iframeCallback(this, navTabAjaxDone);" enctype="multipart/form-data"><div align="left"> 
			</div><div class="pageFormContent" layoutH="56"><div align="left"><br> 
				</div><table>
					<tr height="35px">
						<td style="text-align:right;"><label>版本Code：</label></td>
						<td><input name="versionCode" type="text" size="30" value="<%=newCode%>" class="required"/></td>
						<td align="right"><label>当前版本Code：</label></td>
						<td><%=code%></td>
					</tr>
					<tr height="35px">
						<td align="right"><label>版本号：</label></td>
						<td colspan="3"><input name="versionNum" type="text" size="30" value="" alt="请输入版本号" class="required"/></td>
					</tr>
					<tr>
						<td align="right"><label>版本信息：</label></td>
						<td colspan="3"><textarea name="versionInfo" cols="45" rows="5"></textarea></td>
					</tr>
					<tr height="35px">
						<td align="right"><label>是否强制更新：</label></td>
						<td colspan="3" style="text-align:left;"><input type="radio" name="isForceUpdate" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="isForceUpdate" value="0" checked="checked" />否</td>
					</tr>
					<tr height="35px">
						<td align="right"><label>分辨率：</label></td>
						<td colspan="3">
							<select name="screenResolution" class="combox">
								<option value = "480x800" >480*800</option>
								<option value = "320x480">320*480</option>
								<option value = "540x960">540*960</option>
								<option value = "480x854">480*854</option>
							</select>
						</td>
					</tr>
					<tr height="35px">
						<td align="right"><label>上传文件：</label></td>
						<td colspan="3"  align="left"><input name="upload" type="file" class="required"/></td>
					</tr>
					<tr>
						<td align="right"><label>描述：</label></td>
						<td colspan="3"><textarea name="describe" cols="45" rows="5"></textarea></td>
					</tr>													
				</table>
				
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
 </body>
</html>
