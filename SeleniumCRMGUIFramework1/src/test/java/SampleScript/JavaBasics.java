package SampleScript;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasics {

	public static void main(String[] args) {
		
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate=sim.format(dateobj);
	
		System.out.println(actDate);
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dateRequ=sim.format(cal.getTime());
		System.out.println(dateRequ);
		
	

	}

}
