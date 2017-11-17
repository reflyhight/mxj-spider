package com.mxj.commons.config;

import java.util.List;

/**
 * 抽象配置文件方法
 * 
 * @author Rob Jiang
 * @dat 2017年11月17日
 * @email jh624haima@126.com
 * @blog blog.mxjhaima.com
 */
public interface AbstractConfig {

	
	public Object get(String key);

	public Short getShort(String key);

	public Integer getInt(String key);

	public Long getLong(String key);

	public Double getDouble(String key);

	public String getString(String key);

	public Boolean getBoolen(String key);

	public List<String> getList(String key);

	public Class<?> getClass(String key);

	public Short getShort(ConfigDefine def);

	public Integer getInt(ConfigDefine def);

	public Long getLong(ConfigDefine def);

	public Double getDouble(ConfigDefine def);

	public String getString(ConfigDefine def);

	public Boolean getBoolen(ConfigDefine def);

	public List<String> getList(ConfigDefine def);

	public Class<?> getClass(ConfigDefine def);

}
