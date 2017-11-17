package com.mxj.commons.config;

public enum ConfigDefine {
	
	LUCENE_INDEX_DIR("lucene.index.dir","index",ConfigType.STRING),
	REDIS_CLUSTER_HOSTS("redis.cluster.hosts","hado88,hado89",ConfigType.LIST),
	INT_TEST("int.test",Integer.MAX_VALUE,ConfigType.INT),
	LONG_TEST("long.test",Long.MAX_VALUE,ConfigType.LONG),
	DOUBLE_TEST("double.test",2.3,ConfigType.DOUBLE)
	;
	

	String conf_name = "";
	Object default_value = "";
	ConfigType type;
	
	private ConfigDefine(String conf_name,Object default_value,ConfigType type) {
		this.conf_name=conf_name;
		this.default_value=default_value;
		this.type=type;
	}

}
