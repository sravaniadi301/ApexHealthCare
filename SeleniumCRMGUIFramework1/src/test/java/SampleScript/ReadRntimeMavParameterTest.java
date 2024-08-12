package SampleScript;

import org.testng.annotations.Test;

public class ReadRntimeMavParameterTest {
 @Test
 public void runtimeparameterTest() {
	 String URL=System.getProperty("url");
	 String Browser=System.getProperty("browser");
	 String USERNAME=System.getProperty("username");
	 String PASSWORD=System.getProperty("password");
	 
	 System.out.println("Env Data==>URL ==>"+URL);
	 System.out.println("Browser Data==>URL ==>"+Browser);
	 System.out.println("password==>URL ==>"+PASSWORD);
 }
}
 
