package com.zbiti.mvc.android.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.UserInfoDao;
import com.zbiti.mvc.android.mapper.UserInfoMapper;
import com.zbiti.mvc.android.model.StaffInfo;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	public Map getUserByName(String staffId) {
		return userInfoMapper.getUserInfoByStaffId(staffId);
	}

	public void updatePassword(String userName, String passWord,
			String newpassWord) {
		userInfoMapper.updatePassword(userName,passWord,newpassWord);
	}

	public void saveAdvice(String staffId, String content) {
		userInfoMapper.saveAdvice(staffId,content);
	}

	public List<StaffInfo> staffInfolistPage(Map<String, String> map, Page page) {
		
		return userInfoMapper.staffInfolistPage(map, page);
	}

	public List<String> getStaffRoleInfo(String staffId) {
		
		return userInfoMapper.getStaffRoleInfo(staffId);
	}

	public void deleteStaffRoleInfo(String staffId) {
		userInfoMapper.deleteStaffRoleInfo(staffId);
	}

	public void insertStaffRoleInfo(String staffId, String roleId) {
		userInfoMapper.insertStaffRoleInfo(staffId, roleId);
	}

	public void deleteStaffInfoById(String staffId) {
		
		userInfoMapper.deleteStaffInfoById(staffId);
	}

	public void insertStaffInfo(StaffInfo staffInfo) {
		
		userInfoMapper.insertStaffInfo(staffInfo);
	}

	public void updateStaffInfo(StaffInfo staffInfo) {
		
		userInfoMapper.updateStaffInfo(staffInfo);
	}

	public List<Map<String,String>> getAreaInfoByStaffNbr(String staffNbr,String staffId) {
		
		return userInfoMapper.getAreaInfoByStaffNbr(staffNbr, staffId);
	}

	public StaffInfo getStaffInfoByStaffId(String staffId) {
		
		return userInfoMapper.getStaffInfoByStaffId(staffId);
	}

	public List<Integer> getStaffRoleValueByStaffNbr(String staffNbr) {
		
		return userInfoMapper.getStaffRoleValueByStaffNbr(staffNbr);
	}

	public List<Integer> getRoleSerValueByStaffNbr(String staffNbr) {
		
		return userInfoMapper.getRoleSerValueByStaffNbr(staffNbr);
	}

	public List<StaffInfo> getStaffInfoInOneArea(String staffNbr) {
		
		return userInfoMapper.getStaffInfoInOneArea(staffNbr);
	}

	public void updateStaffDoorLevel(String staffId) {
		
		userInfoMapper.updateStaffDoorLevel(staffId);
	}

	public String getAreaCodeById(String areaId) {
		
		return userInfoMapper.getAreaCodeById(areaId);
	}

}
