package com.utilityClasses;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Exception {
		FileInputStream fis = new FileInputStream(UtilityConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		wb.close();
		return data;
	}

	public int getNumericalDataFromExcel(String sheetName, int rowNum, int cellNum) throws Exception {
		FileInputStream fis = new FileInputStream(UtilityConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		double data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		int data1 = (int) data;
		wb.close();
		return data1;
	}

	public String getDataFromPropertiesFiles(String Key) throws Exception {
		FileInputStream fis = new FileInputStream(UtilityConstants.propertyPath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(Key);
		return data;
	}

	public void thread() throws InterruptedException {
		Thread.sleep(3000);
	}
}
