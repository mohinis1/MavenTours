package com.mercury.tours;

import org.testng.annotations.DataProvider;

public class ApplicationTestData {
	@DataProvider(name="Login")
	public Object[][] getDataFromDataprovider()
	{
		return new Object[][]
				{
			{"http://newtours.demoaut.com/mercurysignon.php?","testing","testing"},
			{"http://newtours.demoaut.com/mercurysignon.php?","dixit","dixit"},
			{"http://newtours.demoaut.com/mercurysignon.php?","testabhi","testabhi"}
				};
	}
	

	
	@DataProvider(name="LoginDataXLS")
	public Object[][] ExcelXLS() throws Exception{
	{
		ReadExcel_XLS excel=new ReadExcel_XLS();
		Object[][] testObjArray=excel.getExcelData("C:\\Users\\user1\\SeleniumTraining\\Workspace\\Mercury_Tours_Maven\\LoginDetails.xls", "LoginDetails");
		System.out.println(testObjArray);
		return testObjArray;

	}
	}
	@DataProvider(name="LoginDataXLSX")
	public Object[][] ExcelXLSX() throws Exception{
		{
			ReadExcel_XLSX excel=new ReadExcel_XLSX();
			Object[][] testObjArray=excel.getExcelData("C:\\Users\\user1\\SeleniumTraining\\Workspace\\Mercury_Tours_Maven\\FlightTestData.xlsx", "TestData");
			System.out.println(testObjArray);
			return testObjArray;

		}
	}
}