package SampleScript;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {
		
		int n=20;
		
		//choose a character random from this string
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);  //to concatinate 20 chars
		
		for(int i=0;i<n; i++)
		{
			//generate a random number between 0 to AlphaNumericString variable length
			int index = (int)(AlphaNumericString.length()* Math.random()); //used to pick one of the value
			
			//add character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		
		//System.out.println(sb);
	}
}
