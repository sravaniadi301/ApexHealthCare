package practicetestng;

import org.testng.annotations.Test;

public class OrderTest {

	@Test
	public void createOrderTest() {
		System.out.println("execute create Order with-->123");
		String str=null;
		System.out.println(str.equals("123"));
	}
	@Test(dependsOnMethods="createOrderTest")
	
	public void billingOrderTest() {
		System.out.println("execute billing Order Test==>123");
	}
	
}

