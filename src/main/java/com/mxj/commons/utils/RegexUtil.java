package com.mxj.commons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Rob Jiang
 * @date 2017年9月4日
 * @email rob@entgroup.cn
 * @company www.entgroup.cn
 */
public class RegexUtil {

	/**
	 * @param targetUrl
	 * @param regex
	 * @param group
	 * @return
	 */
	public static String extractGroup(String targetUrl, String regex, int group) {
		// TODO Auto-generated method stub
		Pattern p= Pattern.compile(regex);
		Matcher matcher = p.matcher(targetUrl);
		if(matcher.find()){
			return matcher.group(group);
		}else{
			return null;
		}
		
	}
	
	/**
	 * 
	 * @param htmltext
	 * @param string
	 * @param i
	 * @return
	 */
	public static List<String> extractGroupList(String targetUrl, String regex, int group) {
		// TODO Auto-generated method stub
		Pattern p= Pattern.compile(regex);
		Matcher matcher = p.matcher(targetUrl);
		List<String> list= new  ArrayList<>();
		while(matcher.find()){
			list.add(matcher.group(group));
		}
		
		return list;
	}
	
	
	
	
	/**
	 * 
	 * @param targetUrl
	 * @param regex
	 * @return
	 */
	public static String extract(String targetUrl, String regex){
		return extractGroup(targetUrl, regex, 0);
	}

	/**
	 * 
	 * @param targetUrl
	 * @param regex
	 * @return
	 */
	public static boolean matches(String targetUrl, String regex) {
		// TODO Auto-generated method stub
		return Pattern.matches(regex, targetUrl);
	}

	public static List<String> matchesList(String targetUrl, String regex) {
		// TODO Auto-generated method stub
		Pattern p= Pattern.compile(regex);
		Matcher matcher = p.matcher(targetUrl);
		List<String> list= new  ArrayList<>();
		while(matcher.find()){
			list.add(matcher.group());
		}
		
		return list;
	}

	

	
	
}
