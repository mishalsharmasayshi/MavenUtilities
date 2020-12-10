package listeners;

import java.io.File;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utility.ExtentManager;
import Utility.Tests;
import tests.Test2;

public class ExtentListeners extends Tests implements ITestListener {
	
	
	public void onTestStart(ITestResult result) {
		
		ExtentTest exTest = extReps.createTest(result.getMethod().getMethodName());
		testReport.set(exTest);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Hello pass ji");
		// exTest=extReps.createTest(result.getMethod().getMethodName());
		String mName = result.getMethod().getMethodName();
		String logText = "<b>" + " Test case : " + mName + " Passed" + "</b>";
		Markup mkp = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		// exTest.log(Status.PASS, mkp);
		testReport.get().pass(mkp);
		// exTest.pass(" Test has passed");
		testReport.get().pass("Test has passed");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Hello fail ji");
		// exTest=extReps.createTest(result.getMethod().getMethodName());
		String failureException = Arrays.toString(result.getThrowable().getStackTrace());
		String markupText = "<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception"
				+ "Occured. Click to see : " + "</font>" + "</b>" + "</summary>"
				+ failureException.replaceAll(",", "<br>") + "</details>";
		Markup failMkp = MarkupHelper.createLabel(markupText, ExtentColor.WHITE);
		String mName = result.getMethod().getMethodName();
		String logText = "</b>" + " Test Case : " + mName + " Failed " + "</b>";
		Markup mkp = MarkupHelper.createLabel(logText, ExtentColor.RED);
		// exTest.log(Status.FAIL, " Test failed");
		// exTest.fail(" Test has failed");

		// exTest.log(Status.FAIL, mkp);
		testReport.get().log(Status.FAIL, mkp);
		// exTest.fail(failMkp);
		testReport.get().fail(failMkp);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// exTest=extReps.createTest(result.getMethod().getMethodName());
		String mName = result.getMethod().getMethodName();
		String logText = "</b>" + " Test Case : " + mName + " Skipped " + "</b>";
		Markup mkp = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		// exTest.log(Status.SKIP, mkp);
		testReport.get().generateLog(Status.SKIP, mkp);

		String throwableMsg = Arrays.toString(result.getThrowable().getStackTrace());
		Markup mSkip = MarkupHelper.createLabel("<details>" + "<summary>" + "<b>" + "Click to see the exception"
				+ "</b>" + "</summary>" + throwableMsg.replaceAll(",", "<br>") + "</details>", ExtentColor.WHITE);
		// exTest.skip(mSkip);
		testReport.get().skip(mSkip);
		// exTest.log(Status.SKIP, " Test Skipped");
		// exTest.skip( new SkipException("Skipping"));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		if (extReps != null) {
			extReps.flush();
		}

	}

}
