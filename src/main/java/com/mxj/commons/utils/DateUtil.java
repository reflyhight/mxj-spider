package com.mxj.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Rob Jiang
 * @dat 2017年11月22日
 * @email jh624haima@126.com
 * @blog blog.mxjhaima.com
 */
public class DateUtil {
	
	
	//yyyy-MM-dd HH:mm:ss
	public static String format(Date date, String pattern) {
		if(date==null) return null;
		if (StringUtils.isBlank(pattern)) {
			pattern = "yyyy-MM-dd";
		}
		return new SimpleDateFormat(pattern).format(date);
	}
	
	public static String format(Date date) {
		if(date==null) return null;
		String pattern = "yyyy-MM-dd";
		return new SimpleDateFormat(pattern).format(date);
	}
	
	public static Date parse(String date, String pattern) {
		if(date==null) return null;
		if (StringUtils.isBlank(pattern)) {
			pattern = "yyyy-MM-dd";
		}
		try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}
