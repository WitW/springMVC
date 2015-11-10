package com.zbiti.mvc.android.model;

import java.util.List;

import com.zbiti.util.StaticPro;

/**
 * 工单实体类
 * 
 * @author zhaoqi
 * 
 */
public class WorkOrderInfo {
	private String staffNbr;	//工单操作人

	private String workOrderId;// 工单ID

	private String busyType; // 业务类型

	private String event; // 工程性质

	private String dredgeLevel; // 业务开通级别
	
	private String completeTime;	//预约时间
	
	private String accessNum;
	
	private String tml;		//局向
	
	private String customer; // 客户名称

	private String address; // 装机地址

	private String telephone; // 用户联系方式
	
	private String ponType;		//GPON 类型 EPON/GPON

	private String orderState; // 工单状态

	private String oldRes; // 旧资源信息（文本）

	private String newRes; // 新资源信息（文本）
	
	private String newGlNo;	//新光路编码
	
	private String oldGlNo;	//旧光路编码
	
	private String devPortNo; //设备和端子编码

	private List<DevicePortInfo> oldDeviceInfos; // 旧资源信息

	private List<DevicePortInfo> newDeviceInfos; // 新资源信息

	public String getAccessNum() {
		return accessNum;
	}

	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}

	public String getStaffNbr() {
		return staffNbr;
	}

	public void setStaffNbr(String staffNbr) {
		this.staffNbr = staffNbr;
	}

	public String getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}

	public String getBusyType() {
		return busyType;
	}

	public void setBusyType(String busyType) {
		this.busyType = busyType;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getDredgeLevel() {
		return dredgeLevel;
	}

	public void setDredgeLevel(String dredgeLevel) {
		this.dredgeLevel = dredgeLevel;
	}

	public String getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}

	public String getTml() {
		return tml;
	}

	public void setTml(String tml) {
		this.tml = tml;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPonType() {
		return ponType;
	}

	public void setPonType(String ponType) {
		this.ponType = ponType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<DevicePortInfo> getOldDeviceInfos() {
		//判断旧值是否非解绑
		if (this.oldDeviceInfos != null
				&& this.oldDeviceInfos.size() > 0) {
			//新值为空时，旧值全非解绑
			if (this.newDeviceInfos == null
					|| this.newDeviceInfos.size() == 0) {
				for (DevicePortInfo dp : this.oldDeviceInfos) {
					if(dp!=null){
						dp.setPortOpr(StaticPro.STR_UNBANDING);
					}
				}
			} else {
				//新值不为空，比对新旧值中的端口，如果旧值中的端口在新值中不存在，则解绑，否则不操作
				for (DevicePortInfo dp : this.oldDeviceInfos) {
					boolean b = false;
					for (DevicePortInfo odp : this.newDeviceInfos) {
						if ((odp.getPortId()).equals(odp.getPortId())) {
							b = true;
							break;
						} 
						if (!b) {
							dp.setPortOpr(StaticPro.STR_UNBANDING);
						}
					}
				}
			}
		}
		return oldDeviceInfos;
	}

	public void setOldDeviceInfos(List<DevicePortInfo> oldDeviceInfos) {
		this.oldDeviceInfos = oldDeviceInfos;
	}

	public List<DevicePortInfo> getNewDeviceInfos() {
		//判断新值是否非绑定
		if (this.newDeviceInfos != null
				&& this.newDeviceInfos.size() > 0) {
			if (this.oldDeviceInfos == null
					|| this.oldDeviceInfos.size() == 0) {
				for (DevicePortInfo dp : this.newDeviceInfos) {
					if(dp!=null){
						dp.setPortOpr(StaticPro.STR_BANDING);
					}
				}
			} else {
				//旧值不为空，新值中的端口在旧值中不存在
			
				for (DevicePortInfo dp : this.newDeviceInfos) {
					boolean b = false;
					for (DevicePortInfo odp : this.oldDeviceInfos) {
						if ((odp.getPortId()).equals(odp.getPortId())) {
							b = true;
							break;
						}
						if (!b) {
							dp.setPortOpr(StaticPro.STR_BANDING);
						}
					}
				}
			}
		}
		return newDeviceInfos;
	}

	public void setNewDeviceInfos(List<DevicePortInfo> newDeviceInfos) {
		this.newDeviceInfos = newDeviceInfos;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getNewGlNo() {
		return newGlNo;
	}

	public void setNewGlNo(String newGlNo) {
		this.newGlNo = newGlNo;
	}

	public String getOldGlNo() {
		return oldGlNo;
	}

	public void setOldGlNo(String oldGlNo) {
		this.oldGlNo = oldGlNo;
	}

	public String getOldRes() {
		return oldRes;
	}

	public void setOldRes(String oldRes) {
		this.oldRes = oldRes;
	}

	public String getNewRes() {
		return newRes;
	}

	public void setNewRes(String newRes) {
		this.newRes = newRes;
	}

	public String getDevPortNo() {
		return devPortNo;
	}

	public void setDevPortNo(String devPortNo) {
		this.devPortNo = devPortNo;
	}

}
