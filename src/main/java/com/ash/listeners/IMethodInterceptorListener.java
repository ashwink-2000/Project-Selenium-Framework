package com.ash.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.ash.utilites.ReadExcelUtility;

public class IMethodInterceptorListener implements IMethodInterceptor{

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<IMethodInstance> result= new ArrayList<IMethodInstance>();
		List<HashMap<String, String>> list=ReadExcelUtility.getData("testdatafile.xlsx","runmanager");

		for(int i=0;i<methods.size();i++)
		{
			for(int j=0;j<list.size();j++)
			{
				if((methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("test")) && (list.get(j).get("execute").equalsIgnoreCase("yes"))))
				{
					result.add(methods.get(i));
				}
			}
		}
		return result;
	}

}
