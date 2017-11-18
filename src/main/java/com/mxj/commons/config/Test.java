package com.mxj.commons.config;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * 测试配置文件装配
 * @author Rob Jiang
 * @dat 2017年11月18日
 * @email jh624haima@126.com
 * @blog blog.mxjhaima.com
 */
public class Test {
	
	public static void main(String[] args) {
		/*BOOLEAN, STRING, INT, SHORT, LONG, DOUBLE, LIST, CLASS,CHAR*/
		
		Properties properties=new Properties();
		try {
			properties.load(Test.class.getClassLoader().getResourceAsStream("spider.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		SpiderConfig config= new SpiderConfig(properties);
		SpiderConfig config= new SpiderConfig();
		
		
		Boolean boolen_test = config.getBoolen(ConfigDefine.BOOLEN_TEST);
		String string_test = config.getString(ConfigDefine.STRING_TEST);
		Integer int_test = config.getInt(ConfigDefine.INT_TEST);
		Short short_test = config.getShort(ConfigDefine.SHORT_TEST);
		Long long_test = config.getLong(ConfigDefine.LONG_TEST);
		Double double_test = config.getDouble(ConfigDefine.DOUBLE_TEST);
		List<String> list_test = config.getList(ConfigDefine.LIST_TEST);
		Class<?> claz = config.getClass(ConfigDefine.CLASS_TEST);
		Character char_test = config.getChar(ConfigDefine.CHAR_TEST);
		
		System.out.println("00");
		
	}

}
