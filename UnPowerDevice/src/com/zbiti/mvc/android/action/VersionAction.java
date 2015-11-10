package com.zbiti.mvc.android.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.mvc.android.model.VersionObject;
import com.zbiti.mvc.android.service.VersionService;
import com.zbiti.mvc.android.service.WorkOrderService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

/**
 * 版本管理控制层
 * @author dlt
 *
 */
@Controller
@RequestMapping("/version")
@SuppressWarnings("all")
public class VersionAction {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private VersionService versionServiceImpl;

	/**
	 * 检查版本信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/checkVersion")
	public void checkVersion(HttpServletRequest request,HttpServletResponse response){
		
		//获取客户端参数
		String param = Util.getParam(request);
		
//		param ="{\"curVersion\":\"1\"}";
//		param ="{\"curVersion\":\"3\",\"imsi\":\"46003680080657100\"}";
		
//		if(jo.containsKey("imsi")){
//			num = getPhonenumByImsiServiceImpl.getPhonenumByname(jo.getString("imsi"));
//		}
		//boolean is_update = versionServiceImpl.isUpdate(versionId);
		logger.debug(param);
		
		JSONObject jo = JSONObject.fromObject(param);
		
		String versionCode = jo.getString("versionCode");
		
		//根据客户端的版本编号查询版本信息
		List<VersionObject> list = versionServiceImpl.getListVersion(versionCode);
		HashMap result = new HashMap();
		
		//当客户端版本编号为最新版本，list为空则不需要更新
		if(list.size()>0){
			result.put("isUpdate", StaticPro.IS_UPDATE);
			
			//因为list是根据version_code 倒序排列后的，所以取0表示为最新版本
			VersionObject vo  =  list.get(0);
			HashMap lastVersion = new HashMap();
			lastVersion.put("version_code", vo.getVersion_code());
			lastVersion.put("version_num", vo.getVersion_num());
			lastVersion.put("version_info", vo.getVersion_info());
			
			//是否强制更新标识符
			boolean ifup = false;
			for(VersionObject v:list){
				if(v.getIf_force_update().equals(StaticPro.FORCE_UPDATE_YES)){
					ifup = true;
				}
			}
			if(ifup){
				lastVersion.put("is_force_update", StaticPro.FORCE_UPDATE_YES);
			}else{
				lastVersion.put("is_force_update", StaticPro.FORCE_UPDATE_NOT);
			}
			
			lastVersion.put("file_name", vo.getFile_name());
			
			//result MAP集为最新版本
			result.put("lastVersion",lastVersion);
		}else{
			result.put("isUpdate", StaticPro.NOT_UPDATE);
		}
//		if(jo.containsKey("imsi")){
//			result.put("phone_num", num);
//		}
		
		//Map转为JSON对象
		JSONObject rjo = JSONObject.fromObject(result);
		
		Util.sendParam(response, rjo.toString()); // 传递json参数
		
	}
	
	/**
	 * 版本下载
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/downLoad")
	public void downLoad(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		// 最新版本信息
		VersionObject vo  =  versionServiceImpl.getLastVersion();
		
		String soft_version_id = vo.getSoftware_version_id();
		// 下载的文件路径
		String path = StaticPro.ODN_VERSION_PATH+"/" + vo.getFile_name();
		
		// 系统绝对路径
		File tmpf = new File(request.getSession().getServletContext().getRealPath("/"));
		
		// 组合完整的地址
		path = tmpf.getParentFile().getParentFile().getAbsolutePath().replace("\\", "/") +"/"+ path;
		
        File file = new File(path);
        // 取得文件名。
        String filename = file.getName();
        // 取得文件的后缀名。
        String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

        // 以流的形式下载文件。
        InputStream fis = null;
        OutputStream fos = null;
		try {
			// 清除缓冲区中存在的所有数据以及状态代码和头
	        response.reset();
	        // 设置response的Header
	        response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
	        response.setHeader("Content-Length", "" + file.length());
	        response.setContentType("application/octet-stream");
	        
	        //建立读取文件的输入流
			fis = new BufferedInputStream(new FileInputStream(path));
			//建立写入文件的输出流
			fos = new BufferedOutputStream(response.getOutputStream());
			
			byte[] buffer = new byte[1024];
			
			int read;
			while(-1!=(read = fis.read(buffer,0,buffer.length))){
				// 写入输出流
				fos.write(buffer,0,read);
			}
			//修改下载次数,下载次数加 1
			versionServiceImpl.updateVersionDownloadNum(soft_version_id);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis!=null){
				fis.close();
			}
			if(fos!=null){
				fos.close();
			}
		}
	}

}
