package com.Selenium.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Gaurav
 */

public class ExcelUtility {
	/**
	 * This method will read String Data from excel file.
	 * 
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return string value
	 * @throws IOException
	 */
	public String getStringDataFromExcel(String sheetName, int rowIndex, int colIndex) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Test_Data/Test_Script.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();

	}
	public boolean getBooleanDataFromExcel(String sheetName, int rowIndex, int colIndex) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Test_Data/Test_Script.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();

	}
	public LocalDateTime getDateandTimeFromExcel(String sheetName, int rowIndex, int colIndex) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Test_Data/Test_Script.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();


	
}
}
