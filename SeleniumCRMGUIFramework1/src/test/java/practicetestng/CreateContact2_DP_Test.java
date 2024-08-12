package practicetestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact2_DP_Test {
	@Test(dataProvider="getData")
	public void createContactTest(String firstName,String lastName,long phoneNumber) {
		
		System.out.println("FirstName :"+ firstName+",LastName:"+ lastName+",PhoneNumber:"+phoneNumber);
				
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][3];
		
		objArr[0][0]="deepak";
		objArr[0][1]="HR";
		objArr[0][2]=89127345;
		
		objArr[1][0]="Joe";
		objArr[1][1]="Manager";
		objArr[1][2]=989857345;
		
		
		objArr[2][0]="Smith";
		objArr[2][1]="Employee";
		objArr[2][2]=779857345;
		
		return objArr;
	}
	
	
	
}



