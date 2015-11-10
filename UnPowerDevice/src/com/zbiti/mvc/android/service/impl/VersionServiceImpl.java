package com.zbiti.mvc.android.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbiti.mvc.android.dao.VersionDao;
import com.zbiti.mvc.android.model.VersionObject;
import com.zbiti.mvc.android.service.VersionService;

@Service
@SuppressWarnings("all")
public class VersionServiceImpl implements VersionService {
	
	@Autowired
	private VersionDao versionDaoImpl;

	public VersionObject getLastVersion() {
		
		return versionDaoImpl.getLastVersion();
	}

	public boolean isUpdate(String versionId) {
		
		return versionDaoImpl.isUpdate(versionId);
	}

	public List<VersionObject> getListVersion(String versionId) {
		
		return versionDaoImpl.getListVersion(versionId);
	}

	public void updateVersionDownloadNum(String soft_version_id) {
		versionDaoImpl.updateVersionDownloadNum(soft_version_id);
		
	}

	public void saveVersionInfo(VersionObject vo) {
		versionDaoImpl.saveVersionInfo(vo);
		
	}

}
