package SampleScript;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {

	public static void main(String[] args) throws Throwable, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\main\\resources\\readdata1.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sh = book.getSheet("sheet2");
		
		Row row = sh.getRow(1);
		Cell cell = row.createCell(4);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("PASS");
		
	//get the write mode of the physical file
		FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\main\\resources\\readdata1.xlsx");
	//performing save function
		book.write(fos);
		
		book.close();
		System.out.println("executed");
	}
}
