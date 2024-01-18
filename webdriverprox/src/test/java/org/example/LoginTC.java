package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class LoginTC extends TestBase{
    public WebDriver driver;
    @BeforeMethod
    public void predefineData() throws InterruptedException {
        driver=setupDriver();
    }
    @AfterMethod
    public void postExecute()
    {
        driverQuit();

    }
    @Test
    public void TC1()
    {
        System.out.println("TC1");
        WebElement w1 = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[2]/a"));
        WebElement w2 = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[2]/ul/li[2]/a"));
        WebElement w3 = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[2]/ul/li[2]/ul/li[2]/a"));
        Actions a = new Actions(driver);
        a.moveToElement(w1);
        a.moveToElement(w2);
        a.moveToElement(w3).click().build().perform();

    }
    @Test
    public void TC2()
    {
        System.out.println("TC2");
        WebElement w1 = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[2]/a"));
        WebElement w2 = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[2]/ul/li[2]/a"));
        WebElement w3 = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[2]/ul/li[2]/ul/li[2]/a"));
        Actions a = new Actions(driver);
        a.moveToElement(w1);
        a.moveToElement(w2);
        a.moveToElement(w3).click().build().perform();
    }
    @Test
    public void TC3()
    {
        System.out.println("TC3");
        WebElement w1 = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[2]/a"));
        WebElement w2 = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[2]/ul/li[2]/a"));
        WebElement w3 = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[2]/ul/li[2]/ul/li[2]/a"));
        Actions a = new Actions(driver);
        a.moveToElement(w1);
        a.moveToElement(w2);
        a.moveToElement(w3).click().build().perform();
    }
}
