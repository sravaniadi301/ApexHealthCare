package SampleScript;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelBasedOnCondition {

	public static void main(String[] args) throws Throwable, IOException {
		
		String data1="";
		String data2="";
		String data3="";
		boolean flag = false;
		
		String expectedTestId = "tc_100"; //condition
			//logic -> get all the tc_id -> check the condition -> if same, get the 
							//complete row of that tc_id
		
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\main\\resources\\readdata1.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sh = book.getSheet("sheet2");
		
		int rowCount = sh.getLastRowNum(); //this method is used to get the last row count in excel
		
		for(int i=0; i<=rowCount; i++) {
			String data = "";
			try {
				data = sh.getRow(i).getCell(0).toString();
				if(data.equals(expectedTestId)) {
					flag = true;
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();
				}
			}catch (Exception e) {}
		}
		if(flag==true) {
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}else {
			System.out.println(expectedTestId + " data is not available");
		}
		
		
		book.close();
	}
}
