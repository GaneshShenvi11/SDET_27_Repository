import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataFromDataBase {
	public static void main(String[] args) throws Throwable {
	
		String expectedValue = "Uganda";

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Establish the connection with database
		Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		
		// issue the statement
		
		Statement statement = connection.createStatement();
		
		// execute queries
		
		ResultSet result = statement.executeQuery("select * from studentinfo");
		
		while (result.next())
		{
			if(result.getString(4).equals(expectedValue))
			{
			System.out.println("PASS");
			break;
			}else {
				System.out.println("FAIL");
				break;
				
			}
		}
		
		// close the database connection
		
		connection.close();

	  }
	}
