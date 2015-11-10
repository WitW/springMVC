package com.zbiti.filter;

import java.util.ArrayList;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.handler.AbstractHandler;

import com.zbiti.util.DataSourceInstance;
import com.zbiti.util.DataSourceSwitch;
import com.zbiti.util.Location;

/**
 * webservice拦截器 ， 根据条件中不同的地区设置不同的数据源
 * 
 * @author zhaoqi
 * 
 */
public class WebserviceDynamicDataSourceHandler extends AbstractHandler {

	protected final Log logger = LogFactory.getLog(this.getClass());

	public void invoke(MessageContext context) throws Exception {
		ArrayList handler = (ArrayList) context.getInMessage().getBody();
		if (handler != null && handler.size() > 0) {
			try {
				String json = (String) handler.get(0);
				JSONObject jo = JSONObject.fromObject(json);
				for(Location l :Location.values()){
					//遍历Enum 如果参数中的地区编码在配置中，则设置该本地网的数据源
					if((jo.getString("loc").toUpperCase()).equals((l.name()))){
						String loc = jo.getString("loc").toUpperCase() + "DataSource";
						DataSourceSwitch.setDataSourceType(loc);
						logger.info("--------------切换数据源成功，当前数据源"+loc+"------------");
						return;
					}
				}
				logger.info("--------------参数错误，切换数据源失败，使用默认数据源SZDataSource------------");
				DataSourceSwitch
						.setDataSourceType(DataSourceInstance.SZDataSource);
			} catch (Exception e) {
				logger.info("--------------参数错误，切换数据源失败，使用默认数据源SZDataSource------------");
				DataSourceSwitch
						.setDataSourceType(DataSourceInstance.SZDataSource);
			}
		}
	}

}
