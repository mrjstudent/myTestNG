package exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.*;

public class ReadingExcelFile {

	public static void main(String[] args) throws IOException {
		String excelFilePath = ".\\datafiles\\countries.xlsx";
		// below line opens the file
		FileInputStream inputStream = new FileInputStream(excelFilePath);
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

	}

}
