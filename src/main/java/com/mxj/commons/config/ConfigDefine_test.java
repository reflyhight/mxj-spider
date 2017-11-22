package com.mxj.commons.config;

public enum ConfigDefine_test {
	
	BOOLEN_TEST("boolen.test",true,ConfigType.BOOLEAN),
	;
	

	String conf_name = "";
	Object default_value = "";
	ConfigType type;
	
	private ConfigDefine_test(String conf_name,Object default_value,ConfigType type) {
		this.conf_name=conf_name;
		this.default_value=default_value;
		this.type=type;
	}

}
