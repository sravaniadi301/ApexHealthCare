package practicehometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SampleReport {
@Test
	
	public void homePageTest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start");
		
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		
	}
	

	@Test
	
	public void verifyLogoHomePage(Method mtd) {
		Reporter.log((mtd.getName()+"Test Start"));
		
		Reporter.log("step-1");
		Reporter.log("step-2");
		
		Reporter.log((mtd.getName()+"Test End"));
	}
}



