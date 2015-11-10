package com.zbiti.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 工具类
 * 
 * @author zhaoqi
 * 
 */
public class Util {

	protected static final Log logger = LogFactory.getLog(Util.class);

	/**
	 * 将数据库字段转换成String
	 * 
	 * @param o
	 * @return
	 */
	public static String convertStr(Object o) {
		try {
			return ((BigDecimal) o).toString();
		} catch (Exception e) {
			try {
				return (String) o;
			} catch (Exception e2) {
				return o.toString();
			}
		}
	}

	/**
	 * 获取手机客户端中传入的参数
	 * 
	 * @param request
	 * @return
	 */
	public static String getParam(HttpServletRequest request) {
		String param = "";
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			StringBuffer sb = new StringBuffer();
			is = request.getInputStream();
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			param = sb.toString();
			param = URLDecoder.decode(param, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return param;
	}

	/**
	 * 向手机客户端发送参数
	 * 
	 * @param response
	 * @param param
	 * @return
	 */
	public static boolean sendParam(HttpServletResponse response, String param) {
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(param);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 判断当前时间是否在start和end中间
	 * 
	 * @param start
	 *            格式：HH:mm
	 * @param end
	 *            格式：HH:mm
	 * @return
	 */
	public static boolean compareNowTime(String start, String end) {
		Calendar now = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));

		Calendar stcal = Calendar
				.getInstance(TimeZone.getTimeZone("GMT+08:00"));

		String hour = start.split(":")[0];
		String min = start.split(":")[1];
		stcal.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
				now.get(Calendar.DAY_OF_MONTH), Integer.parseInt(hour),
				Integer.parseInt(min));

		Calendar endcal = Calendar.getInstance(TimeZone
				.getTimeZone("GMT+08:00"));

		hour = end.split(":")[0];

		min = end.split(":")[1];

		endcal.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
				now.get(Calendar.DAY_OF_MONTH), Integer.parseInt(hour),
				Integer.parseInt(min));

		if (stcal.before(now) && endcal.after(now))
			return true;
		else
			return false;

	}

	/**
	 * 切换数据源
	 * 
	 * @param loc
	 */
	public static void changeDataSource(String loc) {
		try {

			for (Location l : Location.values()) {
				// 遍历Enum 如果参数中的地区编码在配置中，则设置该本地网的数据源
				if ((loc.toUpperCase()).equals((l.name()))) {
					loc = loc.toUpperCase() + "DataSource";
					DataSourceSwitch.setDataSourceType(loc);
					logger.info("--------------切换数据源成功，当前数据源" + loc
							+ "------------");
					return;
				}
			}

			logger.info("--------------参数错误，切换数据源失败，使用默认数据源SZDataSource------------");
			DataSourceSwitch.setDataSourceType(DataSourceInstance.SZDataSource);
		} catch (Exception e) {
			logger.info("--------------参数错误，切换数据源失败，使用默认数据源SZDataSource------------");
			DataSourceSwitch.setDataSourceType(DataSourceInstance.SZDataSource);
		}
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}
}
