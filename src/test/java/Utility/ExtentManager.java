package Utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static  ExtentReports createExtentInstance(String path){
		ExtentSparkReporter htmlRep = new ExtentSparkReporter(path);
		htmlRep.config().setDocumentTitle("ExtentReport");
		htmlRep.config().setEncoding("utf-8");
		htmlRep.config().setTheme(Theme.STANDARD);
		htmlRep.config().setReportName("TestAutomationExtentReports");

		ExtentReports exReport = new ExtentReports();
		exReport.attachReporter(htmlRep);
		exReport.setSystemInfo("Automation Creator", "Mishal");
		exReport.setSystemInfo("Organisation name ", "WoltersKluwer");
		exReport.setSystemInfo(" Build Number", "23811232");
        return exReport;
	}
}
