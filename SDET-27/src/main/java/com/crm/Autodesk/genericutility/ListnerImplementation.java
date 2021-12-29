package com.crm.Autodesk.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener  {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	/**
	 *  Used to get screenshot on failed script
	 */
	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		// capture the Method Name
		String methodName = result.getMethod().getMethodName();
		
		// capture the current date
		String CurrentDate = new JavaUtility().getSystemDateWithFormat(); 
		
		
		// Concatenate the variables   methodName & CurrentDate
		String screenShotName = methodName + CurrentDate ;
		
	
		try {
				new WebDriverUtility().takeScreenshot(BaseClass.sDriver, screenShotName);
		} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
