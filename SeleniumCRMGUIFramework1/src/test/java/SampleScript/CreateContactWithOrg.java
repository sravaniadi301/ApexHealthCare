package SampleScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactWithOrg {

	@Test
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
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
	
			//step1 : get the excel path location & java object of the physical excelfile
					FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\test\\resources\\TestScriptdata\\testScriptdata.xlsx");
					Workbook wb = WorkbookFactory.create(fis1);
					Sheet sh = wb.getSheet("org");
	 				Row row = sh.getRow(6);
					String orgName = row.getCell(2).toString() + randomInt;
					
					String LastName = row.getCell(2).toString() + randomInt; 
					wb.close();
					System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");  
			      	 WebDriver driver = new ChromeDriver();
					 
		//launching the browser	 
		/* WebDriver driver =null;
		 if(BROWSER.equals("chrome"))
		 {
			 driver = new ChromeDriver();
		 }
		 else if(BROWSER.equals("Firefox"))
		 {
			 driver = new FirefoxDriver();
		 }
		 else if(BROWSER.equals("edge"))
		 {
			 driver = new EdgeDriver();
		 }
		 else
		 {
			 driver = new EdgeDriver();  //by default
		 }*/
		 //launching the application
		 driver.get(URL);
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.linkText("Organizations")).click();
			
			//step 3: click on "create organization" button
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			//step 4: enter all details & create new organization
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		 driver.findElement(By.linkText("Contacts")).click();
		 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		 driver.findElement(By.name("lastname")).sendKeys(LastName);
    		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	//   switch to child window
		Set<String>set=driver.getWindowHandles();
		Iterator<String>it=set.iterator();
		while(it.hasNext()) {
			String windowId=it.next();
			driver.switchTo().window(windowId);
			String acturl=driver.getCurrentUrl();
			if(acturl.contains("module=Accounts"))
			{
				break;
			}
		}	
		 driver.findElement(By.name("search_text")).sendKeys(orgName);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		//dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		//switch to parent Window
		Set<String>set1=driver.getWindowHandles();
		Iterator<String>it1=set.iterator();
		while(it1.hasNext()) {
			String windowID=it1.next();
			driver.switchTo().window(windowID);
			String acturl1=driver.getCurrentUrl();
			if(acturl1.contains("Contacts&action"))
			{
				break;
			}
		}
		 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		 //verify header Text

			String actOrgName=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
			if(actOrgName.equals(orgName)) {
				System.out.println(orgName +"is created==Pass");
			}
			else {
				System.out.println(orgName +"is Not created==fail");
        }
		 
		 
		 String  headerText=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		 if(headerText.contains(orgName))
		 {
			 System.out.println(orgName+" Contact is created===PASS");
		 }
		 else
		 {
			 System.out.println(orgName+"Contact is not created===FAIL");
		 }
		
		 //logout
		 Actions act = new Actions(driver);
		 WebElement signoutImg= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 act.moveToElement(signoutImg).perform();
		 driver.findElement(By.linkText("Sign Out")).click();
		 driver.close();

	}
}
	
