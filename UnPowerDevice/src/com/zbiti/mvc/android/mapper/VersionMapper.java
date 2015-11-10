package com.zbiti.mvc.android.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zbiti.mvc.android.model.VersionObject;

public interface VersionMapper {
	
	/**
	 * 获取最大的版本code
	 * @return
	 */
	public String getMaxVersionCode();
	
	/**
	 * 根据版本编码获取版本信息
	 * @param versionId
	 * @return
	 */
	public VersionObject getLastVersion();
	
	
	/**
	 * 查询版本信息
	 * @param versionId
	 * @return
	 */
	public List<VersionObject> getListVersion(@Param("versionId")String versionId);
	
	/**
	 * 修改下载次数
	 * @return
	 */
	public void updateVersionDownloadNum(@Param("soft_version_id")String soft_version_id);
	
	/**
	 * 保存版本信息
	 * @param vo
	 */
	public void saveVersionInfo(VersionObject vo);
	
}
