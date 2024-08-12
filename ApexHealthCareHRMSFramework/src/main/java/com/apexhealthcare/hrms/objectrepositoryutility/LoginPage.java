package com.apexhealthcare.hrms.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import BaseTestUtility.BaseClass;

//Rule1:Create a separate java class
public class LoginPage extends BaseClass
{
	
   WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
    
  //Rule2:Object creation
	
	@FindBy(xpath="(//a[text()='Click Here'])[3]")
	private WebElement clickhere1;
	
	


	public WebElement getClickhere1() {
		return clickhere1;
	}

	//Rule 5:provide Action
	public void loginToapp(String username,String password) {
		
		driver.manage().window().maximize();
		
		clickhere1.click();
	}
	
	
	
}
