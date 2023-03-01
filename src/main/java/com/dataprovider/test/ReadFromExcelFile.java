package com.dataprovider.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcelFile {

	public static String[][] getDataFromExcel(String sheetName) throws IOException {
//		String excelFilePath = "C:\\Users\\Jamaly\\eclipse-workspace\\TestNgFramework\\src\\main\\java\\com\\dataprovider\\test\\DataProvider.xlsx";
		File f = new File(System.getProperty(
				"user.id" + "\\src\\main\\java\\com\\dataprovider\\test\\DataProvider\\DataProvider.xlsx"));
		// below line opens the file
		FileInputStream inputStream = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);// XSSFSheet sheet=workbook.getSheet("Sheet1");
		// using for loop
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
//		for (int r = 0; r < rows; r++) {
//			XSSFRow row = sheet.getRow(r);// 0
//
//			for (int c = 0; c < cols; c++) {
//				XSSFCell cell = row.getCell(c);
		// using iterator
		String testData[][] = new String[rows][cols];
		Iterator iterator = sheet.rowIterator();
		while (iterator.hasNext()) {
			XSSFRow row = (XSSFRow) iterator.next();
			Iterator celliterator = row.cellIterator();
			while (celliterator.hasNext()) {
				XSSFCell cell = (XSSFCell) celliterator.next();
				switch (cell.getCellType()) {

				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;

				}
				System.out.print("|");
			}
			System.out.println();
		}
		return testData;

	}
}
