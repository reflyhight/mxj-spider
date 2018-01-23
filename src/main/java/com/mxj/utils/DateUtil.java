package com.mxj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	
	public static Date getDateByStr(String dateStr){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Date  date = null;
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return date;
	}

	public static String getStringByDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		String dateStr = format.format(date); 
		return dateStr;
	}

	/**
	 * 获取指定日期的前一天
	 * @param timeStamp
	 * @return
	 */
	public static Date getBeforeDay(Date timeStamp) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance(); 
		c.setTime(timeStamp); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day-1); 
		return c.getTime(); 
	}
	

}
