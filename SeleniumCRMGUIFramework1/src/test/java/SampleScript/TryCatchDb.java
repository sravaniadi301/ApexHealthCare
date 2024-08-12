package SampleScript;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

import com.mysql.cj.jdbc.Driver;
public class TryCatchDb {
		public static void main(String[] args) throws SQLException{
		
			Connection conn=null;
			try {
				
		Driver d = new Driver();
			DriverManager.registerDriver(d);
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			Statement stat=conn.createStatement();
			
			ResultSet  resultset=stat.executeQuery("Select * from emp");
			while(resultset.next())
			{
				System.out.println(resultset.getString(1)+"\t"+resultset.getString(2));
			}
			}
catch(Exception e)
			{
	
	System.out.println("handle exception");
	}
finally {
	conn.close();
	System.out.println("connection close");
}
}

}
