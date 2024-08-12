package practicetestng;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	public ExtentReports report;
	
	@BeforeSuite
	  public  void configBS() {
		//spark report config
				ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRM Test Suite Result");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				//add Env information in create Test
				 report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS","Windows-10");
				report.setSystemInfo("BROWSER","CHROME-109");
	}
		@AfterSuite
		
		public void confiAs() {
			report.flush();
		}
		
	
	@Test
	public void createContactTest() {
		System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ","_").replace(":","_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport1/report1_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
					
		ExtentTest  test=report.createTest("createContactTest");
							
	 test.log(Status.INFO,"login to app");
	 test.log(Status.INFO, "navigate to contact app");
	 test.log(Status.INFO, "create contact");
	 if("HDFCTT".equals("HDFC")) {
		test.log(Status.PASS, "contact is creted");
		}else {
		test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
		}
			
	driver.close();
	}

@Test
public void createContactWithOrg() {
				
 ExtentTest test=report.createTest("createContactWithOrg");
						
 test.log(Status.INFO,"login to app");
 test.log(Status.INFO, "navigate to contact app");
 test.log(Status.INFO, "create contact");
 if("HDFC".equals("HDFC")) {
	test.log(Status.PASS, "contactWithOrg is creted");
	}else {
	test.log(Status.FAIL, "contactWithOrg is not creted");
	}
	}	

@Test
public void createContactWithPhoneNumber() {
				
 ExtentTest test=report.createTest("createContactWithPhoneNumber");
						
 test.log(Status.INFO,"login to app");
 test.log(Status.INFO, "navigate to contact app");
 test.log(Status.INFO, "create contact");
 if("HDFC".equals("HDFC")) {
	test.log(Status.PASS, "contactWithPhnNum is creted");
	}else {
	test.log(Status.FAIL, "contactWithPhoneNum is not creted");
	}
	
	}	}



