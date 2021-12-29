package com.crm.Autodesk.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * it is used 
 * @author Inspiron-3147
 *
 */

public class JavaUtility {
	/**
	 *  it is used to generate random number	
	 * @return
	 */
	public int getRanDomNumber() {
		
		Random random = new Random();
		int intRandom = random.nextInt(10000);
		return intRandom ;
	}
	/**
	 * it is used to get system date & time in IST format
	 * @return
	 */
	
	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString();
	}
	
	public String getSystemDateWithFormat() {
		Date date = new Date();
		String dateAndTime = date.toString();
		
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String finalFormate = YYYY +"-"+MM+"-"+DD;
		
		return finalFormate;
	}

}
