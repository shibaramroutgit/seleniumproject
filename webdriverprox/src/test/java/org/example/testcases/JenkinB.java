package org.example.testcases;

import org.example.base.TestBase;
import org.example.pages.JenkinsBasicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JenkinB extends TestBase {
public JenkinsBasicPage jenkinsBasicPage;
public SoftAssert softAssert;
    @BeforeMethod
    public void predefineData() throws InterruptedException {
        setupDriver();
        jenkinsBasicPage=getJenkinsBasicPage();
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
        jenkinsBasicPage.navigateToJenkinsBasicMenu();
        String val = jenkinsBasicPage.validateJenkinsPageHeader();
        softAssert.assertEquals(val,"Jenkins Basic");
        softAssert.assertAll();
    }
    @Test
    public void TC2() throws InterruptedException {
        System.out.println("TC2");
        jenkinsBasicPage.navigateToJenkinsBasicMenu();
        String val = jenkinsBasicPage.validateJenkinsPageHeader();
        softAssert.assertEquals(val,"Jenkins Basic");
        softAssert.assertAll();
    }

}
