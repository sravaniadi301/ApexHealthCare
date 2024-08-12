package SampleScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createContact {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\main\\resources\\commandata.properties.txt");
        Properties pobj=new Properties();
        pobj.load(fis);
       
        String BROWSER=pobj.getProperty("Browser");
        String URL= pobj.getProperty("Url");
        String USERNAME=pobj.getProperty("Username");
        String PASSWORD=pobj.getProperty("Password");
      //generate the random number
      		Random random = new Random();
      		int randomInt = random.nextInt(1000);
      		FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\test\\resources\\TestScriptdata\\testScriptdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("contact");
				Row row = sh.getRow(1);
			String LastName = row.getCell(2).toString() + randomInt; 
			wb.close();
	System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");  
 	 WebDriver driver = new ChromeDriver();
	 
			
	 driver.manage().window().maximize();
	 //step 1: login to app
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);

	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//step 2: navigate to organization module
	driver.findElement(By.linkText("Contacts")).click();
	
	//step 3: click on "create organization" button
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	//step 4: enter all details & create new contact
	driver.findElement(By.name("lastname")).sendKeys(LastName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//Step 5:verify Header Message Expected Result
	String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();	
	if(headerInfo.contains(LastName)) {
		System.out.println(LastName +"is created==Pass");
	}
	else {
		System.out.println(LastName +"is Not created==fail");
	}

        
	}

	}


