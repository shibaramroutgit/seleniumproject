package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.JenkinsBasicPage;
import org.example.pages.TestngParalela;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG extends TestBase {
public TestngParalela testngParalela;
public SoftAssert softAssert;
    @BeforeMethod
    public void predefineData() throws InterruptedException {
        setupDriver();
        testngParalela=getTestngParalela();
        softAssert = setSoftAssert();
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
        String val = testngParalela.validateTestngPageHeader();
        softAssert.assertEquals(val,"TestNG Paralela");
        softAssert.assertAll();
    }
    @Test
    public void TC2() throws InterruptedException {
        System.out.println("TC2");
        testngParalela.navigateToTestngParalelaMenu();
        String val = testngParalela.validateTestngPageHeader();
        softAssert.assertEquals(val,"TestNG Paralela");
        softAssert.assertAll();
    }

}
