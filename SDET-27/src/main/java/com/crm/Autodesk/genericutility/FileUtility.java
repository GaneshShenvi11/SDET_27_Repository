package com.crm.Autodesk.genericutility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 *  
 * @author Inspiron-3147
 *
 */
public class FileUtility {
	
	public String getPropertyKeyValue (String key ) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
