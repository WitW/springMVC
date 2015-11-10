package com.zbiti.util;

/**
 * 将当前线程需要的数据源放进ThreadLocal中
 * @author zhaoqi
 *
 */
@SuppressWarnings("all")
public class DataSourceSwitch{   
    private static final ThreadLocal contextHolder=new ThreadLocal();   
       
    public static void setDataSourceType(String dataSourceType){   
        contextHolder.set(dataSourceType);   
    }   
       
    public static String getDataSourceType(){   
        return (String) contextHolder.get();   
    }   
       
    public static void clearDataSourceType(){   
        contextHolder.remove();   
    }   
}  