package com.mxj.commons.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpiderConfig implements AbstractConfig {

	// 所有配置定义
	private Map<String, ConfigDefine> configDefines = new HashMap<>();

	// 用户原始配置
	private Map<String, Object> userOriginals;

	// 加载转换后的所有配置（包括用户定义，也包括默认的）
	private Map<String, Object> configMap = new HashMap<>();

	public SpiderConfig() {
		loadProperties(new HashMap<String, Object>());
	}

	public SpiderConfig(Map<?, ?> properties) {
		loadProperties(properties);
	}

	@SuppressWarnings("unchecked")
	private void loadProperties(Map<?, ?> properties) {
		// TODO Auto-generated method stub
		this.userOriginals =(Map<String, Object> ) properties;

		ConfigDefine[] values = ConfigDefine.values();
		for (ConfigDefine def : values) {
			configDefines.put(def.conf_name, def);
		}

		for (String key : userOriginals.keySet()) {
			if (!configDefines.containsKey(key))
				throw new RuntimeException("Unknown configuration");
		}

		for (String key : configDefines.keySet()) {

			Object value = null;

			if (userOriginals.containsKey(key)) {
				value = userOriginals.get(key);
			} else {
				value = configDefines.get(key).default_value;
			}

			configMap.put(key, parseType(value, key, configDefines.get(key).type));
		}

	}

	public Object parseType(Object value, String conf_name, ConfigType type) {
		if (value == null)
			return null;

		String trimmed = null;
		if (value instanceof String)
			trimmed = ((String) value).trim();

		switch (type) {
		case CHAR:
			if (value instanceof Character)
				return value;
			else if (value instanceof String && trimmed.length() == 1)
				return trimmed.charAt(0);
			else
				throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));

		case STRING:
			if (value instanceof String)
				return trimmed;
			else
				throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));

		case INT:
			if (value instanceof Number)
				return ((Number) value).intValue();
			else if (value instanceof String)
				return Integer.parseInt(trimmed);
			else
				throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));

		case LONG:
			if (value instanceof Number)
				return ((Number) value).longValue();
			else if (value instanceof String)
				return Long.parseLong(trimmed);
			else
				throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));

		case SHORT:
			if (value instanceof Number)
				return ((Number) value).shortValue();
			else if (value instanceof String)
				return Short.parseShort(trimmed);
			else
				throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));

		case DOUBLE:
			if (value instanceof Number)
				return ((Number) value).doubleValue();
			else if (value instanceof String)
				return Double.parseDouble(trimmed);
			else
				throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));

		case BOOLEAN:
			if (value instanceof Boolean)
				return value;
			else if (value instanceof String) {

				if (trimmed.toLowerCase().equals("true"))
					return true;
				else if (trimmed.toLowerCase().equals("false"))
					return false;
			} else
				throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));

		case LIST:
			if (value instanceof List)
				return (List<?>) value;
			else if (value instanceof String) {

				if (trimmed.isEmpty())
					return Collections.emptyList();
				else
					return Arrays.asList(trimmed.split("\\s*,\\s*"));
			} else
				throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));

		case CLASS:
			if (value instanceof Class<?>)
				return (Class<?>) value;
			else if (value instanceof String)
				try {
					return Class.forName(trimmed);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));
				}
			else
				throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));

		default:
			throw new RuntimeException(String.format("Unknown configuration type:%s", conf_name));

		}

	}

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		if (!configMap.containsKey(key))
			throw new RuntimeException(String.format("Unknown configuration '%s'", key));
		return configMap.get(key);
	}

	@Override
	public Short getShort(String key) {
		// TODO Auto-generated method stub

		return (Short) get(key);
	}

	@Override
	public Integer getInt(String key) {
		// TODO Auto-generated method stub
		return (Integer) get(key);
	}

	@Override
	public Long getLong(String key) {
		// TODO Auto-generated method stub
		return (Long) get(key);
	}

	@Override
	public Double getDouble(String key) {
		// TODO Auto-generated method stub
		return (Double) get(key);
	}

	@Override
	public String getString(String key) {
		// TODO Auto-generated method stub
		return (String) get(key);
	}

	@Override
	public Boolean getBoolen(String key) {
		// TODO Auto-generated method stub
		return (Boolean) get(key);
	}

	@Override
	public List<String> getList(String key) {
		// TODO Auto-generated method stub
		return (List<String>) get(key);
	}

	@Override
	public Class<?> getClass(String key) {
		// TODO Auto-generated method stub
		return (Class<?>) get(key);
	}

	@Override
	public Short getShort(ConfigDefine def) {
		// TODO Auto-generated method stub
		return (Short) get(def.conf_name);
	}

	@Override
	public Integer getInt(ConfigDefine def) {
		// TODO Auto-generated method stub
		return (Integer) get(def.conf_name);
	}

	@Override
	public Long getLong(ConfigDefine def) {
		// TODO Auto-generated method stub
		return (Long) get(def.conf_name);
	}

	@Override
	public Double getDouble(ConfigDefine def) {
		// TODO Auto-generated method stub
		return (Double) get(def.conf_name);
	}

	@Override
	public String getString(ConfigDefine def) {
		// TODO Auto-generated method stub
		return (String) get(def.conf_name);
	}

	@Override
	public Boolean getBoolen(ConfigDefine def) {
		// TODO Auto-generated method stub
		return (Boolean) get(def.conf_name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getList(ConfigDefine def) {
		// TODO Auto-generated method stub
		return (List<String>) get(def.conf_name);
	}

	@Override
	public Class<?> getClass(ConfigDefine def) {
		// TODO Auto-generated method stub
		return (Class<?>) get(def.conf_name);
	}

	@Override
	public Character getChar(String key) {
		// TODO Auto-generated method stub
		return (Character) get(key);
	}

	@Override
	public Character getChar(ConfigDefine def) {
		// TODO Auto-generated method stub
		return (Character) get(def.conf_name);
	}

}
