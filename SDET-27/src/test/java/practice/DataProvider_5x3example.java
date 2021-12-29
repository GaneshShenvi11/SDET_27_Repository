package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_5x3example {
@Test(dataProvider = "getData")
	
	public void readDataFromDataProviderTest (int slno ,String Animals , String Birds) {
		
		System.out.println("Sl No  ---> " +slno + "--- Animals --->"+ Animals +"--- Birds --->"+ Birds);

}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[5][3];  // 5 X 3 HomeWork
		
	objArr [0][0] = 1 ;
	objArr [0][1] = " Cat ";
	objArr [0][2] = " Crow " ;
	
	objArr [1][0] = 2 ;
	objArr [1][1] = " Dog " ;
	objArr [1][2] = " Parrot " ;
	
	
	objArr [2][0] =  3 ;
	objArr [2][1] = " Cow " ;
	objArr [2][2] = " Dove " ;
	
	objArr [3][0] = 4 ;
	objArr [3][1] = " Buffalo" ;
	objArr [3][2] = " Pegion " ;
	
	objArr [4][0] = 5 ;
	objArr [4][1] = " snake " ;
	objArr [4][2] = " Hen " ;
	
	
	return objArr;
	}

}
