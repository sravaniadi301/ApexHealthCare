package practicetestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {

	@Test(dataProvider="getData")
	public void createContactTest(String firstName,String lastName) {
		
		System.out.println("FirstName :"+ firstName+"LastName:"+ lastName);
				
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		
		objArr[0][0]="deepak";
		objArr[0][1]="HR";
		
		objArr[1][0]="Joe";
		objArr[1][1]="Manager";
		
		objArr[2][0]="Smith";
		objArr[2][1]="Employee";
		
		return objArr;
	}
	
	
	
}
