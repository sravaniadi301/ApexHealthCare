package practicetestng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CreateContactTest {
	
	@Test
	public void createContactTest()
	{
		//spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information in create Test
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("BROWSER","CHROME-109");
		
		ExtentTest test=report.createTest("createContactTest");
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO, "navigate to contact app");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is creted");
		}else {
			test.log(Status.FAIL, "contact is not creted");
		}
			
	report.flush();
}
}

