package org.example.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Date;

public class ReportMasterSetup {
    public static ExtentReports extentReportSetup()
    {
        Date d  = new Date();
        String fileName = "Extent_"+ d.toString().replace(":", "_").replace(" ", "_")+".html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\TestReportDir"+fileName);
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle(fileName);
        extentSparkReporter.config().setEncoding("utf-8");
        extentSparkReporter.config().setReportName(fileName);

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Automation Tester", "Shibaram Rout");
        extentReports.setSystemInfo("Organization", "Shibaram Automation");
        extentReports.setSystemInfo("Build no", "HelpTest-1234");

        return extentReports;

    }
}
