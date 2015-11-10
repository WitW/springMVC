package com.zbiti.mvc.android.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zbiti.common.model.DwzReturnObject;
import com.zbiti.mvc.android.model.VersionObject;
import com.zbiti.mvc.android.service.VersionService;
import com.zbiti.mvc.android.service.WorkOrderService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.UUID;
import com.zbiti.util.Util;

/**
 * 文件上传
 * @author dlt
 *
 */
@Controller
@RequestMapping("/upload")
@SuppressWarnings("all")
public class FileUploadAction {
	
	@Autowired
	private VersionService versionServiceImpl;
	
	/**
	 * 跳转到版本上传页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/uploadPage")
	public String pageToUpload(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		//获取最新的版本信息
		VersionObject vo = versionServiceImpl.getLastVersion();
		if(vo != null){
			//返回版本code
			model.put("code", vo.getVersion_code());
		}
		return "uploadPage";
	}
	
	/**
	 * 版本上传
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/uploadVersion")
	public void uploadVersion(HttpServletRequest request,HttpServletResponse response) {
		
		//版本编码
		String versionCode = (String)request.getParameter("versionCode");
		//版本号
		String versionNum = (String)request.getParameter("versionNum");
		//版本信息
		String versionInfo = (String)request.getParameter("versionInfo");
		//是否强制更新
		String isForceUpdate = (String)request.getParameter("isForceUpdate");
		//分辨率
		String screenResolution = (String)request.getParameter("screenResolution");
		//描述
		String describe = (String)request.getParameter("describe");
		
		
		File tmpf=new File(request.getSession().getServletContext().getRealPath("/"));
		
		String folderPath = tmpf.getParentFile().getParentFile().getAbsolutePath().replace("\\", "/") +"/" +StaticPro.ODN_VERSION_PATH;
		
		VersionObject vo = new VersionObject();
		try {
			
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
         	CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("upload");
			
			vo.setVersion_code(versionCode);
			vo.setVersion_num(versionNum);
			vo.setVersion_info(versionInfo);
			vo.setSoftware_version_id(UUID.randomUUID().toString().replace("-", ""));
			vo.setDescribe(describe);
			
			
			vo.setFile_name(file.getOriginalFilename());
			
			//TODO 测试时将状态置为0 ，发布时置为1
			vo.setState("1");
			vo.setIf_force_update(isForceUpdate);
			vo.setScreen_resolution(screenResolution.replace("x", "*"));
			
			// 保存文件
			File dir = new File(folderPath);
			// 如果这个目录不存在就创建它
			if (!dir.exists()) {
				dir.mkdir();
			}
			vo.setFile_path(folderPath + "/");
			File desFile = new File(folderPath + "/" + file.getOriginalFilename());
			
			byte[] bytes = file.getBytes();
			FileCopyUtils.copy(bytes, desFile);
			
		} catch (IOException e) {
				e.printStackTrace();
		}
			
			DwzReturnObject result=null;
			try{
				//保存版本信息
				versionServiceImpl.saveVersionInfo(vo);
				result= new DwzReturnObject(StaticPro.STATUS_CODE_SUCCESS,"success",null,"../upload/uploadPage.do",StaticPro.CALLBACK_TYPE_FORWARD);
			}catch(Exception e){
				e.printStackTrace();
				result= new DwzReturnObject(StaticPro.STATUS_CODE_FAIL,"error",null,"../upload/uploadPage.do",StaticPro.CALLBACK_TYPE_FORWARD);
			}
			Util.sendParam(response, JSONObject.fromObject(result).toString());
			
	}
}
