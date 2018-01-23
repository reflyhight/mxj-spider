package com.mxj.scheduler;

import us.codecraft.webmagic.Task;

/**
 * Redis队列keys
 * @author Rob Jiang
 * @dat 2018年1月20日
 * @email jh624haima@126.com
 * @blog blog.mxjhaima.com
 */
public class RedisKeys {
	

	//URL队列
	private static final String QUEUE_PREFIX = "queue_";

	//去重队列
	private static final String SET_PREFIX = "set_";

	//request对象序列化队列
	private static final String ITEM_PREFIX = "item_";
	
	//工厂队列
	private static final String FACTORY_PREFIX = "factory_";
	

	public static String getSetKey(Task task) {
		return SET_PREFIX + task.getUUID();
	}

	public static String getQueueKey(Task task) {
		return QUEUE_PREFIX + task.getUUID();
	}

	public static String getItemKey(Task task) {
		return ITEM_PREFIX + task.getUUID();
	}
	
	public static String getFactoryKey(Task task) {
		return FACTORY_PREFIX + task.getUUID();
	}
	
	
}
