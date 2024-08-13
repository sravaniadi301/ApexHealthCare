package com.sample.gitpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sampleclass1 {

	public static void main(String[] args) {
		System.out.println("sample project");
		 WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8081/AppServer/Hospital_Management_System");

	}

}
