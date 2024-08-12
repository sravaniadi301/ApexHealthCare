package SampleScript;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\main\\resources\\readdata1.xlsx");
        Workbook wb=WorkbookFactory.create(fis);
        Sheet sh=wb.getSheet("test");
        Row row=sh.getRow(1);
        Cell cell=row.getCell(1);
        String data=cell.getStringCellValue();
        System.out.println(data);
        wb.close();
		
	}

	
}
