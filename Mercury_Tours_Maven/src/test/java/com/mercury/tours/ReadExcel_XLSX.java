package com.mercury.tours;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;


public class ReadExcel_XLSX {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	
	public String[][] getExcelData(String fileName,String sheetName) throws EncryptedDocumentException,IOException
	{
		String[][] arrayExcelData=null;
		FileInputStream ExcelFile=new FileInputStream(fileName);
		ExcelWBook=new XSSFWorkbook(ExcelFile);
		ExcelWSheet=ExcelWBook.getSheet(sheetName);
		int totalnoofRows=ExcelWSheet.getLastRowNum();
		int totalnoofCols_0=ExcelWSheet.getRow(0).getLastCellNum();
		arrayExcelData=new String[totalnoofRows][totalnoofCols_0];
		ExcelWBook=new XSSFWorkbook(ExcelFile);
		ExcelWSheet=ExcelWBook.getSheet(sheetName);
	
		for(int i=0;i<totalnoofRows;i++)
		{
			int totalnoofCols=ExcelWSheet.getRow(i).getLastCellNum();
			for(int j=0;j<totalnoofCols;j++)
			{
				arrayExcelData[i][j]=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		System.out.println(arrayExcelData);
		return arrayExcelData;
		}
}