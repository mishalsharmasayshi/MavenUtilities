package Utility;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Tests {
	/*String extentReportPath = // "./reports/extentReports/extent.html";
			System.getProperty("user.dir") + File.separator + "ExtentReports" + File.separator + "Extent.html";
	ExtentReports extReps = ExtentManager.createExtentInstance(extentReportPath);
	ExtentTest exTest;*/
	static String path =System.getProperty("user.dir")+File.separator+"ExtentReports"+File.separator+"Extent.html";
	Logger log = LogManager.getLogger(Tests.class.getClass());
	protected ExtentReports extReps =ExtentManager.createExtentInstance(path);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	@Test
	public void doLogin() {
		//exTest = extReps.createTest("Do Login Test");--implemented in listener
		log.debug("Login failed ");
		System.out.println("Login failed");
		Assert.fail(" Failing the test Case");
	}

	@Test
	public void doRegistration() {
		//exTest = extReps.createTest("Do Registration Test"); - implemented in listener
		log.debug("Registration done Successfully");
		System.out.println("Registration done Successfully");
	}

	@Test
	public void navigateToHomePage() {
		//exTest = extReps.createTest("Navigate To HomePage Test"); implemented in listener
		log.debug("NavigateToHomePage Skipped");
		System.out.println("NavigateToHomePage Skipped");
		throw new SkipException(" Skipping the testcase");

	}
 /*
	@AfterMethod
	public void writeToReport(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			String mName = result.getMethod().getMethodName();
			String logText = "<b>" + " Test case : " + mName + " Passed" + "</b>";
			Markup mkp = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			exTest.log(Status.PASS, mkp);

			exTest.pass(" Test has passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String failureException=Arrays.toString(result.getThrowable().getStackTrace());
			String markupText="<details>"+"<summary>"+"<b>"+"<font color="+"red>"+"Exception"
					+ "Occured. Click to see : "+"</font>"+"</b>"+"</summary>"
					+failureException.replaceAll(",", "<br>")+"</details>";
			Markup failMkp=MarkupHelper.createLabel(markupText,ExtentColor.WHITE);
			String mName = result.getMethod().getMethodName();
			String logText = "</b>" + " Test Case : " + mName + " Failed " + "</b>";
			Markup mkp = MarkupHelper.createLabel(logText, ExtentColor.RED);
			// exTest.log(Status.FAIL, " Test failed");
			// exTest.fail(" Test has failed");
			exTest.log(Status.FAIL, mkp);
			exTest.fail(failMkp);
		} else if (result.getStatus() == ITestResult.SKIP) {
			String mName = result.getMethod().getMethodName();
			String logText = "</b>" + " Test Case : " + mName + " Skipped " + "</b>";
			Markup mkp = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
			exTest.log(Status.SKIP, mkp);
			
			String throwableMsg = Arrays.toString(result.getThrowable().getStackTrace());
			Markup mSkip = MarkupHelper.createLabel("<details>"+"<summary>"+"<b>"+"Click to see the exception"
			+"</b>"+"</summary>"+ throwableMsg.replaceAll(",", "<br>")+"</details>",ExtentColor.WHITE);
			exTest.skip(mSkip);
			// exTest.log(Status.SKIP, " Test Skipped");
			// exTest.skip( new SkipException("Skipping"));
		}
	}
	

	@AfterTest
	public void flush() {
		if (extReps != null) {
			extReps.flush();
			log.exit();
		}
	} */

}
