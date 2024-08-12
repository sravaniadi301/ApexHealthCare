package SampleScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
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
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream Fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\main\\resources\\commandata.properties.txt");
        Properties pobj1=new Properties();
        pobj1.load(Fis);
  		
		String BROWSER = pobj1.getProperty("Browser");
		String URL = pobj1.getProperty("Url");
		String USERNAME = pobj1.getProperty("Username");
		String PASSWORD = pobj1.getProperty("Password");
		
		//generate the random number
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
	//read testscript data from excel
		//step1 : get the excel path location & java object of the physical excelfile
				FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\test\\resources\\TestScriptdata\\testScriptdata.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("org");
 				Row row = sh.getRow(1);
				String orgName = row.getCell(2).toString() + randomInt; 
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
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 3: click on "create organization" button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step 4: enter all details & create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 5:verify Header Message Expected Result
		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();	
		if(headerInfo.contains(orgName)) {
			System.out.println(orgName +"is created==Pass");
		}
		else {
			System.out.println(orgName +"is Not created==fail");
		}
			//Step 6:verify Header orgname info Expected Result
	
			String actOrgName=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
			if(actOrgName.equals(orgName)) {
				System.out.println(orgName +"is created==Pass");
			}
			else {
				System.out.println(orgName +"is Not created==fail");
           }
  driver.quit();


	}

}
