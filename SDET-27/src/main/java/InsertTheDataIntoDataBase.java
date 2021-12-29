import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertTheDataIntoDataBase  {
	
	public static void main(String[] args) throws Throwable {
		

	// Register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Establish the connection with database
		Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		
		// issue the statement
		
		Statement statement = connection.createStatement();
		
		// execute queries
		
		int result = statement.executeUpdate("insert into studentinfo(fname,lname,address) value('Pradhan','Kumar','Bharat')");
		
		if(result == 1)
		{
			System.out.println("One Set of data is added into database");		
		}else
		{
			System.out.println("Data is Not added into database");
		}
	
		

		// close the database connection
		
		connection.close();

	 
}
}
