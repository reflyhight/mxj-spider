package com.mxj.commons.config;

public enum ConfigDefine_test {
	
	 /*BOOLEAN, STRING, INT, SHORT, LONG, DOUBLE, LIST, CLASS,CHAR*/
	
		BOOLEN_TEST("boolen.test",true,ConfigType.BOOLEAN),
		
		STRING_TEST("string.test","rob jiang",ConfigType.STRING),
		
		INT_TEST("int.test",Integer.MAX_VALUE,ConfigType.INT),
		
		SHORT_TEST("short.test",11,ConfigType.SHORT),
		
		LONG_TEST("long.test",Long.MAX_VALUE,ConfigType.LONG),
		
		DOUBLE_TEST("double.test",2.3,ConfigType.DOUBLE),
		
		LIST_TEST("list.test","hado88,hado89",ConfigType.LIST),
		
		CLASS_TEST("class.test",Test.class,ConfigType.CLASS),
		
		CHAR_TEST("char.test",'A',ConfigType.CHAR),
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
