package com.zbiti.mvc.android.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 相连端口Mapper接口
 * @author dlt
 *
 */
public interface LinkedPortMapper {

	/**
	 * 查询相连端口信息
	 * @param aPort
	 * @param bPort
	 * @return
	 */
	public List<Map<String,String>> getLinePortInfo(@Param("aPort")String aPort,@Param("zPort")String zPort);
	
	/**
	 * 修改相连端口信息
	 * @param aPort
	 * @param zPort
	 */
	public void updateLinePort(@Param("aPort")String aPort,@Param("zPort")String zPort);
	
	/**
	 * 新增相连端口信息
	 * @param aPort
	 * @param zPort
	 */
	public void insertLinePort(@Param("aPort")String aPort,@Param("zPort")String zPort);
}
