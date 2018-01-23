package com.mxj.spider.dbs;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisPool {
	private static JedisPool jedisPool;

	public static JedisPool init() {
		// 初始化 Jedis 连接池
		if (jedisPool == null) {
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			//  设置最大连接数为默认值的 5 倍
			poolConfig.setMaxTotal(GenericObjectPoolConfig.DEFAULT_MAX_TOTAL * 5);
			//  设置最大空闲连接数为默认值的 3 倍
			poolConfig.setMaxIdle(GenericObjectPoolConfig.DEFAULT_MAX_IDLE * 3);
			//  设置最小空闲连接数为默认值的 2 倍
			poolConfig.setMinIdle(GenericObjectPoolConfig.DEFAULT_MIN_IDLE * 2);
			//  设置开启 jmx 功能
			poolConfig.setJmxEnabled(true);
			//  设置连接池没有连接后客户端的最大等待时间 ( 单位为毫秒 )
			poolConfig.setMaxWaitMillis(6000);
			jedisPool = new JedisPool(poolConfig, "210.14.157.136", 6379);
		}
		return jedisPool;
	}

	public static Jedis get() {
		Jedis jedis = null;
		jedisPool = init();
		try {
			jedis = jedisPool.getResource();
			jedis.auth("redispwd");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			if (jedis != null) {
				jedis.close();
				return jedis;
			}
		}
		return jedis;
	}
}
