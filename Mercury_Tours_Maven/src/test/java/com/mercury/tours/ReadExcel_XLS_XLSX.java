package com.mercury.tours;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_XLS_XLSX {
	public String[][] getExcelData(String fileName,String sheetName) throws EncryptedDocumentException, IOException
	{
		 XSSFSheet ExcelWSheet;
		XSSFWorkbook ExcelWBook;
		String[][] arrayExcelData=null;
		FileInputStream ExcelFile=new FileInputStream(fileName);
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		
		if(fileExtensionName.equals(".xlsx")){
			ExcelWBook=new XSSFWorkbook(ExcelFile);
			ExcelWSheet=ExcelWBook.getSheet(sheetName);
		int totalNoOfRows=ExcelWSheet.getLastRowNum();
		int totalNoOfCols_0=ExcelWSheet.getRow(0).getLastCellNum();
		arrayExcelData=new String[totalNoOfRows][totalNoOfCols_0];
		for(int i=0;i<totalNoOfRows;i++)
		{
			int totalNoOfCols=ExcelWSheet.getRow(i).getLastCellNum();
			for(int j=0;j<totalNoOfCols;j++)
			{
				arrayExcelData[i][j]=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		System.out.println(arrayExcelData);
		}
		
		else if(fileExtensionName.equals(".xls")){
			Workbook ExcelWBook1;
			Sheet ExcelWSheet1;
			ExcelWBook1=WorkbookFactory.create(ExcelFile);
			ExcelWSheet1=ExcelWBook1.getSheet(sheetName);
			int totalNoOfRows=ExcelWSheet1.getLastRowNum();
			int totalNoOfCols_0=ExcelWSheet1.getRow(0).getLastCellNum();
			arrayExcelData=new String[totalNoOfRows][totalNoOfCols_0];
			for(int i=0;i<totalNoOfRows;i++)
			{
				int totalNoOfCols=ExcelWSheet1.getRow(i).getLastCellNum();
				for(int j=0;j<totalNoOfCols;j++)
				{
					arrayExcelData[i][j]=ExcelWSheet1.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			System.out.println(arrayExcelData);
		}
		
		
		return arrayExcelData;
	}
}
