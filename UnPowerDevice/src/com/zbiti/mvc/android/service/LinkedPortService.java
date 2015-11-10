package com.zbiti.mvc.android.service;

import java.util.List;
import java.util.Map;

/**
 * 相连端口业务接口
 * @author dlt
 *
 */
public interface LinkedPortService {

	/**
	 * 查询相连端口信息
	 * @param aPort
	 * @param bPort
	 * @return
	 */
	public List<Map<String,String>> getLinePortInfo(String aPort,String zPort);
	
	/**
	 * 修改相连端口信息
	 * @param aPort
	 * @param zPort
	 */
	public void updateLinePort(String aPort,String zPort);
	
	/**
	 * 新增相连端口信息
	 * @param aPort
	 * @param zPort
	 */
	public void insertLinePort(String aPort,String zPort);
	
}
