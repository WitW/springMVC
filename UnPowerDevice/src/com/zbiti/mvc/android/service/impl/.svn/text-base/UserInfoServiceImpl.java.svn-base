package com.zbiti.mvc.android.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.UserInfoDao;
import com.zbiti.mvc.android.model.StaffInfo;
import com.zbiti.mvc.android.service.UserInfoService;

@Service
@SuppressWarnings("all")
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDaoImpl ;

	public Map getUserInfoByStaffNbr(String userName) {
		Map user = userInfoDaoImpl.getUserByName(userName);
		return user;
	}

	public void updatePassword(String userName, String passWord,
			String newpassWord) {
		userInfoDaoImpl.updatePassword(userName,passWord,newpassWord);
	}

	public void saveAdvice(String staffId, String content) {
		userInfoDaoImpl.saveAdvice(staffId,content);
	}

	public List<StaffInfo> staffInfolistPage(Map<String, String> map, Page page) {
		
		return userInfoDaoImpl.staffInfolistPage(map, page);
	}

	public List<String> getStaffRoleInfo(String staffId) {
		
		return userInfoDaoImpl.getStaffRoleInfo(staffId);
	}

	public void deleteStaffRoleInfo(String staffId) {
		userInfoDaoImpl.deleteStaffRoleInfo(staffId);
	}

	public void insertStaffRoleInfo(String staffId, String roleId) {
		userInfoDaoImpl.insertStaffRoleInfo(staffId, roleId);
	}

	public void deleteStaffInfoById(String staffId) {
		
		userInfoDaoImpl.deleteStaffInfoById(staffId);
	}

	
	public void insertStaffInfo(StaffInfo staffInfo) {
		userInfoDaoImpl.insertStaffInfo(staffInfo);
	}

	public void updateStaffInfo(StaffInfo staffInfo) {
		
		userInfoDaoImpl.updateStaffInfo(staffInfo);
	}

	public List<Map<String,String>> getAreaInfoByStaffNbr(String staffNbr,String staffId) {
		
		return userInfoDaoImpl.getAreaInfoByStaffNbr(staffNbr, staffId);
	}

	public StaffInfo getStaffInfoByStaffId(String staffId) {
		
		return userInfoDaoImpl.getStaffInfoByStaffId(staffId);
	}

	public List<Integer> getStaffRoleValueByStaffNbr(String staffNbr) {
		
		return userInfoDaoImpl.getStaffRoleValueByStaffNbr(staffNbr);
	}

	public List<Integer> getRoleSerValueByStaffNbr(String staffNbr) {
		
		return userInfoDaoImpl.getRoleSerValueByStaffNbr(staffNbr);
	}

	public List<StaffInfo> getStaffInfoInOneArea(String staffNbr) {
		
		return userInfoDaoImpl.getStaffInfoInOneArea(staffNbr);
	}

	public void updateStaffDoorLevel(String staffId) {
		
		userInfoDaoImpl.updateStaffDoorLevel(staffId);
	}

	public String getAreaCodeById(String areaId) {
		
		return userInfoDaoImpl.getAreaCodeById(areaId);
	}
	
}
