package practicetestng;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
	@Test
	public void amazonTest() throws IOException {
		 System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		driver.get("http://amazon.com");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
	    File src=ts.getScreenshotAs(OutputType.FILE);
	    File trg=new File("./screenshot/1.png");
	    FileHandler.copy(src, trg);
		 
				
	}
	

}
