package practicetestng;

import org.testng.annotations.Test;

public class OrderInvoTest {
	
	@Test(invocationCount=10)
	public void createOrderTest() {
		System.out.println("execute create Order with-->123");
		
	}
	@Test(enabled=false)
	
	public void billingOrderTest() {
		System.out.println("execute billing Order Test==>123");
	}
	

}
