package dataprovider.readingFromExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	public String path;
	public ExcelUtility(String path) {
		this.path=path;
	}
	public int getRowCount(String sheetName) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
		
	}
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
	}
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter= new DataFormatter();//returns the formatted value of the 
													//cell as String regardless of 
		String data;
		try {
		data=formatter.formatCellValue(cell);
		}
		catch (Exception e) {
		data="";
		}
		workbook.close();
		fi.close();
		return data;
		}
	public void setCellData(String sheetName, int rownum, int colnum, String data) 
								throws IOException {
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet =workbook.getSheet(sheetName);
	
	row=sheet.getRow(rownum);
	cell=row.createCell(colnum);
	cell.setCellValue(data);
	
	fo=new FileOutputStream(path);
	workbook.write(fo);
	workbook.close();
	fi.close();
	fo.close();
}
	public void fillGreenColor(String sheetName, int rownum, int colnum) 
								throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet =workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
}
}
