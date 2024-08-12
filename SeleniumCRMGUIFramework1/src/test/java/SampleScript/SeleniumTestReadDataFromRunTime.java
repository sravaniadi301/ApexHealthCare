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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRunTime {

	@Test
	public void seleniumTest() throws Throwable {
			
		//capture the data(maven parameter) from the cmd line(var)
				String URL = System.getProperty("url");
				String BROWSER = System.getProperty("browser");
				String USERNAME = System.getProperty("username");
				String PASSWORD = System.getProperty("password");
				
				//generate the random number
				Random random = new Random();
				int randomInt = random.nextInt(1000);
				
			//read testscript data from excel
				//step1 : get the excel path location & java object of the physical excelfile
						FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Selenium files\\SeleniumCRMGUIFramework1\\src\\main\\resources\\readdata1.xlsx");
						
						
					//step2 : open workbook in read mode
						Workbook wb = WorkbookFactory.create(fis1);
						
					//step3 : get the control of the "org" sheet
						Sheet sh = wb.getSheet("test");
						
					//step4 : get the control of 1st row
						Row row = sh.getRow(1);
					
					//step5 : get the control of the 2nd cell & read the string data
						String orgName = row.getCell(2).toString() + randomInt; 
						
					//step6 : close the workbook
						wb.close();
				/*
				 * System.out.println(BROWSER); 
				 * System.out.println(URL);
				 * System.out.println(USERNAME); 
				 * System.out.println(PASSWORD);
				 */

				/*
				 * Scanner s = new Scanner(System.in); 
				 * System.out.println("enter the browser");
				 * String browser = s.next();
				 * 
				 */
				
				 WebDriver driver = null; 
				 if(BROWSER.equals("chrome")) { 
					 driver = new ChromeDriver(); 
				 }else if(BROWSER.equals("firefox")) { 
					 driver = new FirefoxDriver(); 
				}else if(BROWSER.equals("edge")) { 
					driver = new EdgeDriver(); 
				}else {
						driver = new ChromeDriver(); 
				}
				 
				 driver.manage().window().maximize();
				 
				// WebDriver driver=new ChromeDriver();

				 //step 1: login to app
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(URL);

				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//step 2: navigate to organization module
				driver.findElement(By.linkText("Organizations")).click();
				
				//step 3: click on "create organization" button
				driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
				
				//step 4: enter all details & create new organization
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
				Thread.sleep(2000);
				
				//step 5: logout
				Actions act = new Actions(driver);
				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
				Thread.sleep(2000);
				act.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
				/*
				 * driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click(); 
				 * Actions act = new Actions(driver);
				 * act.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform(); 
				 * Thread.sleep(2000);
				 */
				/*
				 * WebDriver driver=new ChromeDriver(); driver.get("http://localhost:8888");
				 * 
				 * driver.findElement(By.name("user_name")).sendKeys("admin");
				 * driver.findElement(By.name("user_password")).sendKeys("manager");
				 * driver.findElement(By.id("submitButton")).click();
				 * 
				 * driver.findElement(By.linkText("Organizations")).click(); driver.quit();
				 */
	}
}
