package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerDemo {
	
	@Test(retryAnalyzer = com.crm.Autodesk.genericutility.RetryAnalyzerImpl.class)
	public void retryAnalyzerDemoTest()
	{
		System.out.println(" Retry Analyzer Initiated");
		Assert.fail();
	}

}
