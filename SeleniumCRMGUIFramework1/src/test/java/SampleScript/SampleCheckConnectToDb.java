package SampleScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.mysql.cj.jdbc.Driver;



public class SampleCheckConnectToDb {

	public static void main(String[] args) throws SQLException{
		
		
			//Driver driverRef= new Driver();
		Driver d = new Driver();
			DriverManager.registerDriver(d);
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			Statement stat=conn.createStatement();
			
			ResultSet  resultset=stat.executeQuery("Select * from emp");
			while(resultset.next())
			{
			System.out.println(resultset.getString(1));
			
			}

			conn.close();
	}

}
