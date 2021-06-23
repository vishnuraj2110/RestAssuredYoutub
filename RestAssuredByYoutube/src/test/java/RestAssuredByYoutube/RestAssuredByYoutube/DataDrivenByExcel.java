package RestAssuredByYoutube.RestAssuredByYoutube;

import org.testng.annotations.Test;

public class DataDrivenByExcel {

	
	@Test
	public void getData() {
		ExcelUtils ex = new ExcelUtils("./Book1","Data");
		ex.getRowCount();
	//	ex.getCellData(1, 2);
	}
	
	
}
