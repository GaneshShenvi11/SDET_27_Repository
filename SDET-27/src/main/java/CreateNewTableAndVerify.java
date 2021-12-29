
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;


public class CreateNewTableAndVerify {
public static void main(String[] args) throws Throwable  {
		
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra", Keys.TAB, "rmgy@9999",Keys.ENTER);
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.className("btn-success")).click();
		driver.findElement(By.name("projectName")).sendKeys("New_Project_Auto");
		driver.findElement(By.name("createdBy")).sendKeys("Ganesh_Auto");
		WebElement wb = driver.findElement(By.xpath("//label[text()='Project Status ']/../select"));
		//WebElement wb = driver.findElement(By.xpath("//select[@name='status']/option"));
		Select s = new Select(wb);
		s.selectByIndex(2);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
				
		//driver.quit();
		
		String project_name = "New_Project_Auto";
		// launch and set database
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		//Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		//communicate 
		Statement statement = connection.createStatement();
		// Get data
		ResultSet result = statement.executeQuery("select * from project");
	
		while (result.next())
		{
			if(result.getString(4).equals(project_name))
			{
			System.out.println("PASS");
		    }
				
		}
		connection.close();
	}
}
