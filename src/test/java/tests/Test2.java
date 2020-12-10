package tests;

import java.io.File;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.ExtentManager;

public class Test2 {
	
	
	public static String extentReportPath = // "./reports/extentReports/extent.html";
			System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator + "Extent.html";

	public static ExtentReports extReps = ExtentManager.createExtentInstance(extentReportPath);
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	@Test
	public void doRegistration() {
		System.out.println("Registration successful");
	}
	
	@Test
	public void doLogin() {
		
		Assert.fail();
		System.out.println("Login failed");
	}
	
	@Test
	public void doPageNavigagtion() {
		System.out.println("PageNavigagtion Skipped");
		throw new SkipException("Skipping PageNavigagtion testcase");
	}
}
