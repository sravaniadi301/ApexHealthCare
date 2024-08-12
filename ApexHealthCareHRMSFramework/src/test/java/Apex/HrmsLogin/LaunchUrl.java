package Apex.HrmsLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.apexhealthcare.hrms.objectrepositoryutility.LoginPage;


import BaseTestUtility.BaseClass;

public class LaunchUrl extends BaseClass{
	@Test
	public void launchurl() {
	 
		driver.manage().window().maximize();
	
  LoginPage cnp=new LoginPage(driver);
	cnp.getClickhere1().click();
   
    driver.close();
    
}



}
