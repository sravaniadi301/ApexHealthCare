package SampleScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createContactWithSupportDate {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\main\\resources\\TestScriptdata\\testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
			Row row = sh.getRow(1);
		String LastName = row.getCell(2).toString() + randomInt; 
		wb.close();
		System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");  
     	 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 driver.manage().window().maximize();
		 //step 1: login to app
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
			

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step 2: navigate to organization module
		driver.findElement(By.linkText("Contacts")).click();
		
		//step 3: click on "create organization" button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		

		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		
		String startDate=sim.format(dateobj);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String endDate=sim.format(cal.getTime());
		System.out.println(endDate);
		
		//step 4: enter all details & create new contact
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys("startDate");
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys("endDate");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//Step 5:verify Header Message Expected Result
		String SDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();	
		if(SDate.equals(startDate)) {
			System.out.println(startDate +"is created==Pass");
		}
		else {
			System.out.println(startDate +"is Not created==fail");
		}

		String EDate=driver.findElement(By.id("dtlview_Support End Date")).getText();	
		if(EDate.equals(endDate)) {
			System.out.println(endDate +"is created==Pass");
		}
		else {
			System.out.println(endDate +"is Not created==fail");
		}

		}

		}





