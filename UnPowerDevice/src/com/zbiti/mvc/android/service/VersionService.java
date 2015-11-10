package com.zbiti.mvc.android.service;

import java.util.List;

import com.zbiti.mvc.android.model.VersionObject;

public interface VersionService {
	
	/**
	 * 是否有版本可以更新
	 * @param versionId
	 * @return
	 */
	public boolean isUpdate(String versionId);
	
	/**
	 * 获取最新的版本信息
	 * @param versionId
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
