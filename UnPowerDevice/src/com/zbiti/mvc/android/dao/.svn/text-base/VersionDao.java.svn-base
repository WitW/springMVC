package com.zbiti.mvc.android.dao;

import java.util.List;

import com.zbiti.mvc.android.model.VersionObject;

/**
 * 版本处理Dao接口
 * @author dlt
 *
 */
public interface VersionDao {

	
	public boolean isUpdate(String versionId);
	
	/**
	 * 获取最新版本信息
	 * @return
	 */
	public VersionObject getLastVersion();
	
	
	/**
	 * 查询版本信息
	 * @param versionId
	 * @return
	 */
	public List<VersionObject> getListVersion(String versionId);
	
	/**
	 * 修改下载次数
	 * @return
	 */
	public void updateVersionDownloadNum(String soft_version_id);
	
	/**
	 * 保存版本信息
	 * @param vo
	 */
	public void saveVersionInfo(VersionObject vo);
}
