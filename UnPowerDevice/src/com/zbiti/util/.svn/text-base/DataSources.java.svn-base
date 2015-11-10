package com.zbiti.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;   

/**
 * 获取当前数据源
 * @author zhaoqi
 *
 */
public class DataSources extends AbstractRoutingDataSource{ 

	protected final Log logger = LogFactory.getLog(this.getClass());
  
    @Override  
    protected Object determineCurrentLookupKey() {  
    	logger.info("---------------------当前数据源 "+DataSourceSwitch.getDataSourceType()+"----------------------");
        return DataSourceSwitch.getDataSourceType();   
    }   
  
} 