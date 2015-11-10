package com.zbiti.util;

import java.util.List;

public class StaticPro {
	public static String CODE_SUCCESS = "000";//成功
	public static String CODE_SAVE_FAIL = "2001";//保存失败
	public static String CODE_FOUND_NO_DEVICE = "2002";//未找到设备
	public static String CODE_NONE_USER = "1001";
	public static String CODE_ERROR_PASSWORD = "1002";
	public static String CODE_LOCK_NONE_PERMISSION = "3001";
	public static String CODE_DATABASE_ERROR = "9999";
	

	public static String OBJ_PORT = "端口";
	public static String OBJ_FIBER = "插头";
	public static String OBJ_SLOT="模块";
	public static String OBJ_DEVICE="设备";
	
	public static String STR_BANDING = "绑定";
	public static String STR_UNBANDING = "解绑";
	public static String STR_CHECK = "巡检";
	public static String STR_NONE_UNBANDING = "拆机不解绑";
	public static String STR_RFID_NONE = "00000000000000000000000000000000";
	public static String STR_BATCH_BAND = "批量绑定";
	public static String STR_BATCH_UNBAND = "批量解绑";
	public static String STR_BATCH_ORDER_ID = "0";
	
	public static String STATUS_CODE_SUCCESS = "200";
	public static String STATUS_CODE_TIMEOUT = "301";
	public static String STATUS_CODE_FAIL = "300";

	public static String CALLBACK_TYPE_CLOSE ="closeCurrent";
	public static String CALLBACK_TYPE_FORWARD ="forward";
	
	//模块PROP_SPEC_ID
	public static String PROP_SPEC_ID_SLOT="80002004";  
	//设备PROP_SPEC_ID
	public static String PROP_SPEC_ID_DEV="80002003";
	
	//版本更新
	public static String IS_UPDATE = "1";
	
	//版本更新
	public static String NOT_UPDATE = "0";
	//强制更新
	public static String FORCE_UPDATE_YES = "1";
	// 不强制更新
	public static String FORCE_UPDATE_NOT = "0";

	//导航栏树节点ID，角色节点ID
	public static String LEFT_TREEID_ROLE = "31";
	
	//导航栏树节点ID，用户节点ID
	public static String LEFT_TREEID_STAFF = "32";
	
	/**
	 * 导航栏树节点ID，门禁权限管理
	 */
	public static String LEFT_TREEID_DOOR = "42";
	
	/**
	 * 版本存放路径
	 */
	public static String ODN_VERSION_PATH = "ODNversion";
	
	/**
	 * 照片存放路径
	 */
	public static String ODN_PHOTO_PATH = "/ODNphoto";
	
	/**
	 * 开门
	 */
	public static String DOOR_OPEN = "1";
	
	/**
	 *  关门
	 */
	public static String DOOR_CLOSE = "2";
	
	/**
	 *  异常关门
	 */
	public static String DOOR_CLOSE_Exc = "3";
	
	/**
	 * 门禁时间段ID
	 */
	public static String TIME_RANG_ID = "1"; 
	
	/**
	 * 不在时间段内 0
	 */
	public static String DOOR_CHANGE_NOTIME = "0";
	
	/**
	 * 权限改变，在时间段内 1
	 */
	public static String DOOR_CHANGE_Y_TIME = "1";
	
	/**
	 * 权限不改变，在时间段内 2
	 */
	public static String DOOR_CAHNGE_N_TIME = "2";
	
	/**
	 * 查看设备坐标成功
	 */
	public static String LOC_CODE_SUC = "1";
	
	/**
	 * 设备不存在
	 */
	public static String LOC_CODE_NODEV = "2";
	
	/**
	 * 设备存在，坐标不存在
	 */
	public static String LOC_CODE_NOPOS = "3";
	
	/**
	 * 根据工单赋设备权限  2
	 */
	public static String DEV_TYPE_ORDER = "2";
	
	/**
	 * 设备权限，工单和区域同时赋权限 3
	 */
	public static String DEV_TYPE_BOTH = "3";
	
	/**
	 * 相连端口，参数错误
	 */
	public static String LINE_PORT_ERROR = "001";
	
	/**
	 * rfid和二维码都重复
	 */
	public static String ALL_DOUBLE = "201";
	
	/**
	 * rfid重复
	 */
	public static String RFID_DOUBLE = "202";
	
	
	/**
	 * 二维码重复
	 */
	public static String CODE_DOUBLE = "203";
	
	
	/**
	 * 获取用户权限
	 * @param list
	 * @return
	 */
	public static Integer getStaffValue(List<Integer> list){
		
		if(list == null){
			return 0;
		}else if(list.size() == 1){
			return list.get(0);
		}else if(list.size() > 1){
			int temp = list.get(0);
			for(int i = 0;i < list.size();i++){
				temp = temp | list.get(i);
			}
			return  temp;
		}else{
			return 0;
		}
	}
}
