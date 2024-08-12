package practicetestng;

import org.testng.annotations.Test;

public class ContactTest {
	@Test(priority=1)
	public void createContactTest() {
		System.out.println("execute create contact with-->HDFC");
	}
	@Test(priority=2)
	
	public void modifyContactTest() {
		System.out.println("execute modifyContact--->HDFC =>ICICI");
	}
	@Test(priority=3)
	public void deleteContactTest() {
		System.out.println("execute deleteContact-->ICICI");
	}

}
