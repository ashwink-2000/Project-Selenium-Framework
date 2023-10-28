package com.ash.utilites;

public final class DynamicLocatorUtility {

	private  DynamicLocatorUtility()
	{
		
	}
	
	public static String getXpath(String xpath ,String value)
	{
		return String.format(xpath,value);
	}
}
