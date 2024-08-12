package SampleScript;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;



	import com.mysql.cj.jdbc.Driver;




public class ExecuteNonSelectQueryTest {

		public static void main(String[] args) throws SQLException{
			
			
				//Driver driverRef= new Driver();
			Driver d = new Driver();
				DriverManager.registerDriver(d);
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
				Statement stat=conn.createStatement();
				
				int   resultset=stat.executeUpdate("insert into emp values('5','deepu','7889');");
				
				System.out.println(resultset);
				
				
				conn.close();
		}

	}
