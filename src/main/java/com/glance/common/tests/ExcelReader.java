package com.glance.common.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.glance.pageobjects.logs.TestLog;

public class ExcelReader {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelReader(String path) throws IOException {
		try {
			// File src = new File(path);
			FileInputStream fileInputStream = new FileInputStream(path);
			wb = new XSSFWorkbook(fileInputStream);
		}catch (Exception ex) {
			TestLog.log.info("Could not fetch the file " + ex);
		}
	}

	public String getData(String sheetName, int row, int column) {
		sheet = wb.getSheet(sheetName);

		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public int getRowCount(String sheetName) {
		// int rows = wb.getSheetAt(sheetIndex).getLastRowNum();
		// rows = rows+1;
		// return rows;

		int rows = wb.getSheet(sheetName).getPhysicalNumberOfRows();
		return rows;
	}

}
