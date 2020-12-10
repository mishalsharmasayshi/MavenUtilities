package Utility;
import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProvider2 {
	Logger log = LogManager.getLogger(DataProvider2.class.getClass());
	
	@Test(dataProvider = "getDataFromExcel")
	public void parameterizationTest(Hashtable<String,String> hMap) {
	
		System.out.println("The name is " + hMap.get("name"));
		System.out.println("The email is " +  hMap.get("email"));
		System.out.println("The number is " +  hMap.get("number"));
		log.info("Hello");

	}

	@DataProvider
	public Object[][] getDataFromExcel() {
		log.debug("Ola ke ase");
		log.error("Got error");
		String path = "G:" + File.separator + "ExcelDataFiles" + File.separator + "dataProviderSheet.xlsx";
		ExcelUtility eu = new ExcelUtility(path/*"G:/ExcelDataFiles/dataProviderSheet.xlsx"*/);
		System.out.println("row count for obje creation size "+eu.getRowCount("Sheet1") );
		Object[][] obj = new Object[eu.getRowCount("Sheet1")-1][1]; //  row count =5 , data =4 so- obj[4]
		Hashtable<String, String> hMap=null;
		for (int i = 1; i < eu.getRowCount("Sheet1"); i++) { // 1<5, 2<5,3<5,4<5,
			System.out.println("Iteration is : "+i);
			 hMap= new Hashtable<String, String>();
			for (int j = 0; j < eu.getColumnCount("Sheet1"); j++) {
				hMap.put(eu.getCellValue("Sheet1", 0, j), eu.getCellValue("Sheet1", i, j)); // excel starts with 0.
			}
			System.out.println("Object  value is : "+(i-1));
			obj[i-1][0]=hMap;
		}
        return obj;	
	}
}
