package SampleExcel;

	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ReadDataFromExcel {

	   
   		public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
   			
   		 System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");  
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://demowebshop.tricentis.com/login");
   			
   		FileInputStream fis=new FileInputStream("E:\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\test\\resources\\TestScriptdata\\excel1.xlsx");
   			//To access the Workbook
   	     Workbook book=WorkbookFactory.create(fis);
   		//to access the sheet
   		Sheet sh=book.getSheet("sheet1");
   		
   		int row=sh.getLastRowNum();
   		
   		
   		 for(int i=0;i<=row;i++)
   		{
     			Row row1=sh.getRow(i);
     			int cell=row1.getLastCellNum();
     		String[][] arr1 =new String [row+1][cell+1];
   			for(int j=0;j<row1.getLastCellNum();j++)
   			{  
   		       arr1[i][j]=sh.getRow(i).getCell(j).toString();
   		
   		       
   		       //System.out.println(arr1[i][j]);
   			
   			
   		 if(j==0)
   		 {
   			System.out.println("username==="+arr1[i][j]);
   		WebElement email= driver.findElement(By.id("Email"));
   		email.sendKeys(arr1[i][j]);
   		email.clear();
   		 }
   		 else {
   			System.out.println("password===="+arr1[i][j]);
   		WebElement password =driver.findElement(By.id("Password"));
   		password.sendKeys(arr1[i][j]);
       		password.clear();
   		 }
   		}
   		}
   		}
   	
   		
}   			