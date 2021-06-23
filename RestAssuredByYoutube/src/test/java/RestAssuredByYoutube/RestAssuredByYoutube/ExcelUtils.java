package RestAssuredByYoutube.RestAssuredByYoutube;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	XSSFWorkbook workbook;
	 XSSFSheet sheet;
	
	
	public ExcelUtils() {
		
	}
public ExcelUtils(String excelPath, String sheetName) {
	try {
	 this.workbook = new XSSFWorkbook(excelPath);
	  this.sheet = workbook.getSheet(sheetName);
	}catch(Exception e){
		System.out.println(e.getMessage());
		System.out.println(e.getCause());
		e.printStackTrace();
	}
	}
	
	public int getRowCount()  {
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
		}
	
//	public Object getCellData(int rowNum, int colNum) {
//          DataFormatter formatter = new DataFormatter();
//		  Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
//		 return value;
//	}
	
	
	
	
	
	
}
