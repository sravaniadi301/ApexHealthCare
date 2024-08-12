package SampleScript;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\main\\resources\\readdata1.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sh = book.getSheet("test");
		
		int rowCount = sh.getLastRowNum(); //this method is used to get the last row count in excel
		
		for(int i=1; i<=rowCount; i++) {
			
			Row row = sh.getRow(i);
			
			String column1Data = row.getCell(0).toString();
			String column2Data = row.getCell(1).toString();
			
			//System.out.println(column1Data);
			//System.out.println(column2Data);
			
			System.out.println(column1Data +"\t" +column2Data);
		}
		
		
		book.close();
	}
}
