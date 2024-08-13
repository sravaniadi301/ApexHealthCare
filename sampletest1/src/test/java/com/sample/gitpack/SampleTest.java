package com.sample.gitpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");  
		
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://49.249.28.218:8081/AppServer/Hospital_Management_System");
	}

}
