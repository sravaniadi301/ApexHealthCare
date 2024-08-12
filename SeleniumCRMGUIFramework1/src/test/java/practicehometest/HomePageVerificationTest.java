package practicehometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageVerificationTest {
@Test
	
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");
		SoftAssert assertobj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		//soft Assert
		assertobj.assertEquals("Home","Home-page");
		System.out.println("step-3");
		assertobj.assertEquals("Home-CRM","Home-CRM");
		System.out.println("step-4");
		assertobj.assertAll();
		System.out.println(mtd.getName()+"Test End");
	}
	

	@Test
	
	public void verifyLogoHomePage(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");
		SoftAssert assertobj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertobj.assertTrue(true);
		System.out.println("step-3");
		System.out.println("step-4");
		System.out.println(mtd.getName()+"Test End");
	}
}



