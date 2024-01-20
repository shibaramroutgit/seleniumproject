package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.JenkinsBasicPage;
import org.example.pages.TestngParalela;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestNG extends TestBase {
public TestngParalela testngParalela;
public SoftAssert softAssert;
    @BeforeMethod
    public void predefineData() throws InterruptedException {
        setupDriver();
        testngParalela=getTestngParalela();
        softAssert = new SoftAssert();
    }
    @AfterMethod
    public void postExecute()
    {
        driverQuit();

    }
    @Test
    public void TC1() throws InterruptedException {
        System.out.println("TC1");
        testngParalela.navigateToTestngParalelaMenu();
        logger.info("AB5");
        String val = testngParalela.validateTestngPageHeader();
        softAssert.assertEquals(val,"TestNG Paralela");
        softAssert.assertAll();
        logger.info("All6");
    }
    @Test
    public void TC2() throws InterruptedException, IOException {
        System.out.println("TC2");
        testngParalela.navigateToTestngParalelaMenu();
        logger.info("AB7");
        String val = testngParalela.validateTestngPageHeader();
        softAssert.assertEquals(val,"TestNG Paralela");
        softAssert.assertAll();
        getScreenshotWebElement(testngParalela.HeaderText);
        logger.info("All8");
    }

}
