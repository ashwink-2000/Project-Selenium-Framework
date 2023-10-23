package com.ash.utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.ash.enums.ConfigurationEnum;
import com.ash.exceptions.PropertyFileUsageException;
import com.ash.frameworkconstants.FrameworkConstants;
public final class ConfigurationUtility {

	private static Properties properties =new Properties();
	private static final HashMap<String,String> configurationMap =new HashMap<String,String>();
	
	static 
	{
		try(FileInputStream file = new FileInputStream(FrameworkConstants.configurationFilePath()))
		{
			properties.load(file);
			for(Entry<Object, Object> entry :properties.entrySet())
			{
				configurationMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
			
		} catch (IOException e) {
			System.exit(0);
		}
	}
	
	public static String getValue(ConfigurationEnum key)
	{
		if (Objects.isNull(key) || Objects.isNull(configurationMap.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name " + key + " is not found. Please check config.properties");
		}
		return configurationMap.get(key.name().toLowerCase());	
	}

}
