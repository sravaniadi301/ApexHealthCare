package practicehometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
	
	@Test
	
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");
		SoftAssert assertobj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		//Hard Assert
		Assert.assertEquals("Home","Home");
		System.out.println("step-3");
		assertobj.assertEquals("Home-CRM","HomeCRM");
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
		assertobj.assertAll();
		System.out.println(mtd.getName()+"Test End");
	}
}
