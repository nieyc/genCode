package com.github.nyc.util;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;



/**
 * 读取config.properties
 * @author nyc
 * @version 0.1 (2018年2月7日 下午4:16:10)
 * @since 0.1
 * @see
 */
public class AppUtil {

	private static Log logger = LogFactory.getLog(AppUtil.class);
	/**
	 * 存放应用程序的配置,如邮件服务器等
	 */
	public static Map<String, String> configMap = new HashMap<String, String>();

	/**
	 * 文件路径
	 */
	private static String filePath = "";

	/**
	 * 文件最后修改时间
	 */
	private static long fileDate = 0;

	/**
	 * 加载配置文件
	 * 
	 * @param in_servletContext
	 * @throws IOException
	 */
	public static void init() {
		Properties props = new Properties();
		try {
			File file = new File(filePath);
			if (file != null && file.exists()) {
				long tmepFileDate = file.lastModified();
				// 第一次或者修改过的
				if (fileDate == 0L || fileDate != tmepFileDate) {
					fileDate = tmepFileDate;

					FileInputStream fis = new FileInputStream(filePath);
					props.load(fis);
					Iterator it = props.keySet().iterator();
					while (it.hasNext()) {
						String key = it.next().toString();
						Object value = props.get(key);
						if (null != value) {
							configMap.put(key, value.toString());
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	
	public static void init_value() {
		filePath = getSrcPath("property.properties");
		init();// 加载文件
	}

	/**
	 * 根据配置文件的key获取配置
	 * 
	 * @param key
	 * @return
	 */
	public static String getConifg(String key) {
		filePath = getSrcPath("property.properties");
		init();// 加载文件
		return configMap.get(key);
	}

	/**
	 * 获取文件路径
	 * 
	 * @author nieyc
	 * @date 2014年11月3日 上午11:20:59
	 * @param name
	 * @return 
	 * @since 0.1
	 * @see
	 */
	public static String getSrcPath(String name) {
		String result = null;
		URL urlpath = AppUtil.class.getClassLoader().getResource(name);
		String path = urlpath.toString();
		if (path.startsWith("file")) {
			path = path.substring(5);
		}
		path.replace("/", File.separator);
		result = path;
		return result;
	}	

	public static void main(String[] args) {
		System.out.println(getConifg("url"));
		
	}
}
