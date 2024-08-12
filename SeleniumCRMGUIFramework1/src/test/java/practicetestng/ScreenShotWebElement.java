package practicetestng;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenShotWebElement {
	@Test
	
	public void screenShotWebElement() throws IOException {
		 System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://amazon.com");
		WebElement logo= driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		
		File src=logo.getScreenshotAs(OutputType.FILE);
		File des=new File("./screenshot/ele.png");
		FileHandler.copy(src,des);
		
	   
	}
	

}
