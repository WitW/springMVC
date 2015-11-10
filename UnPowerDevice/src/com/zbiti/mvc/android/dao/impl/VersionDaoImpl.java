package com.zbiti.mvc.android.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zbiti.mvc.android.dao.VersionDao;
import com.zbiti.mvc.android.mapper.VersionMapper;
import com.zbiti.mvc.android.model.VersionObject;

@Repository
public class VersionDaoImpl implements VersionDao {
	
	@Autowired
	private VersionMapper versionMapper;

	public VersionObject getLastVersion() {
		return versionMapper.getLastVersion();
	}

	public boolean isUpdate(String versionId) {
		String code=versionMapper.getMaxVersionCode();
		if(Integer.parseInt(versionId)<Integer.parseInt(code)){
			return true;
		}
		return false;
	}

	public List<VersionObject> getListVersion(String versionId) {
	
		return versionMapper.getListVersion(versionId);
	}

	public void updateVersionDownloadNum(String soft_version_id) {
		versionMapper.updateVersionDownloadNum(soft_version_id);
		
	}

	public void saveVersionInfo(VersionObject vo) {
		versionMapper.saveVersionInfo(vo);
		
	}

}
