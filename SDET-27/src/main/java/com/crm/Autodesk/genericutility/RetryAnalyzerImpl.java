package com.crm.Autodesk.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This Class provides implementation for IRetryAnalyzer
 * @author Inspiron-3147
 *
 */
public class RetryAnalyzerImpl implements IRetryAnalyzer{
		int count = 1 ;
	  
		int retryCount = 5 ;
	public boolean retry(ITestResult result) {
		  
		  
		  while(count <= retryCount) {
			  
			  count++;
			  return true;
		  }
		return false;
	}
}
