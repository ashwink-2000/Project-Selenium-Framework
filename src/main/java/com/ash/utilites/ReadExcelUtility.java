package com.ash.utilites;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public final class ReadExcelUtility {

	private ReadExcelUtility()
	{

	}
	private static Workbook workbook;
	private static Sheet sheet;

	public static List<HashMap<String,String>> getData(String excelFileName,String sheetName)
	{
		List<HashMap<String,String>> list = null;
		try(FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdatafile.xlsx"))
		{
			workbook= new XSSFWorkbook(fis);
			sheet =workbook.getSheet(sheetName);
			int noOfRow =sheet.getLastRowNum();
			int noOfCol=sheet.getRow(0).getLastCellNum();
			HashMap<String,String> map=null;
			list=new ArrayList<HashMap<String,String>>();
			for(int i=1;i<=noOfRow;i++)
			{
				map=new HashMap<String,String>();
				for(int j=0;j<noOfCol;j++)
				{
					String key=sheet.getRow(0).getCell(j).getStringCellValue();
					String value=sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
}
