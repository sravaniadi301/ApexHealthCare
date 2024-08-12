package SampleScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ProjectCheckTest {

		public static void main(String[] args) throws SQLException{
			
			String Expectedname="Seetha";
		
			//Driver driverRef= new Driver();
		Driver d = new Driver();
			DriverManager.registerDriver(d);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			Statement stat=conn.createStatement();
			
			ResultSet  resultset=stat.executeQuery("Select * from emp");
			while(resultset.next())
			{
				String name=resultset.getString(2);
				
				if(Expectedname.equals(name))
				{
			System.out.println(Expectedname +"is available==pass");
			
			}
			}
			
			

			conn.close();
	}

}