import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;


public class CreateTableInCLIAndVerify  {
public static void main(String[] args) throws Throwable {
		
		String expected_project_name = "New_Project";
		
		// launch and set database
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		
		//Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		//communicate 
		Statement statement = connection.createStatement();
		
		// Get data
		
	int res = statement.executeUpdate("insert into project(project_id,created_by,created_on,project_name,status,team_size) value('TY_PROJ_015','Rajesh','16/12/2021','New_Project','Created',0);");
	ResultSet result = statement.executeQuery("select * from project");	
	while (result.next())
		{
			if(result.getString(4).equals(expected_project_name))
			{
			System.out.println("PASS");
		    }
				
		}
		connection.close();
	}
}