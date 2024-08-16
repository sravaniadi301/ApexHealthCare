package pac1;

import org.testng.annotations.Test;

public class contactTest {
	@Test
	public void contact(){
		System.out.println("execute contact test");
		String URL=System.getProperty("url");
		String BROWSER=System.getProperty("browser");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
	}

	@Test
	public void modtest(){
		System.out.println("execute modify contact test");
		
	}

}
