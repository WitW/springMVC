package com.zbiti.mvc.android.model;

/**
 * 版本对象
 * @author dinglvtao
 *
 */
public class VersionObject {
	private String software_version_id; //主键
	
	private String version_num;	//版本号
	
	private String version_code;//版本编码
	
	private String version_info;	//版本信息
	
	private String state;	//版本状态, 测试时将状态置为0 ，发布时置为1
	
	private String create_date;	//版本更新时间
	
	private String file_path;	//文件路径
	
	private String file_name;	//文件名称
	
	private String describe;	//文件描述
	
	private String if_force_update;	//是否强制更新
	
	private String screen_resolution;	//分辨率（TODO）
	
	private String download_num;

	
	public String getVersion_code() {
		return version_code;
	}

	public void setVersion_code(String versionCode) {
		version_code = versionCode;
	}

	public String getSoftware_version_id() {
		return software_version_id;
	}

	public void setSoftware_version_id(String softwareVersionId) {
		software_version_id = softwareVersionId;
	}

	public String getVersion_num() {
		return version_num;
	}

	public void setVersion_num(String versionNum) {
		version_num = versionNum;
	}

	public String getVersion_info() {
		return version_info;
	}

	public void setVersion_info(String versionInfo) {
		version_info = versionInfo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String createDate) {
		create_date = createDate;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String filePath) {
		file_path = filePath;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String fileName) {
		file_name = fileName;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getIf_force_update() {
		return if_force_update;
	}

	public void setIf_force_update(String ifForceUpdate) {
		if_force_update = ifForceUpdate;
	}

	public String getScreen_resolution() {
		return screen_resolution;
	}

	public void setScreen_resolution(String screenResolution) {
		screen_resolution = screenResolution;
	}

	public String getDownload_num() {
		return download_num;
	}

	public void setDownload_num(String download_num) {
		this.download_num = download_num;
	}
	
}
