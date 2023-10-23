package com.ash.utilites;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.ash.frameworkconstants.FrameworkConstants;

public final class DataProviderUtility {

	private DataProviderUtility()
	{

	}

	@DataProvider(name="loginpagedata",parallel=false)
	public static Object[] getData(Method m)
	{
		String testName = m.getName();
		List<HashMap<String,String>>list= ReadExcelUtility.getData(FrameworkConstants.getDataSheetName());
		List<HashMap<String,String>> resultlist = new ArrayList<HashMap<String,String>>();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).get("testname").equalsIgnoreCase(testName) && list.get(i).get("execute").equalsIgnoreCase("yes"))
			{
				resultlist.add(list.get(i));
			}
		}
		return resultlist.toArray();
	}
}
