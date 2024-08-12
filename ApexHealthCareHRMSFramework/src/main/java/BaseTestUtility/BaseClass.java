package BaseTestUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseClass{
	public  WebDriver driver ;
public void configBS()
	{
		System.out.println("==connect to DB ,Report config===");
	
	}

@BeforeClass

public void configBC() throws IOException
	{
		System.out.println("==Launch the Browser==");
	
			 System.setProperty("webdriver.gecko.driver","./Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		
	}
	
@BeforeMethod()
public void configBM() throws IOException

	{
	System.out.println("==Login==");
	driver.get("http://49.249.28.218:8081/AppServer/");
	  
    driver.navigate().to("http://49.249.28.218:8081/AppServer/Hospital_Management_System/");
 	
}

@AfterMethod()
public void configAM()
	{
		System.out.println("==Logout===");
		
		
}
@AfterClass()
public void configAC()
	{
		System.out.println("==closethe Browser==");
		driver.quit();
}
@AfterSuite(groups= {"smokeTest","regressionTest"})
public void configAS()
	{
	  
		System.out.println("==close Db,Report backup==");
			
	
		  
	}
}


