package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[2]/a") public WebElement cicd;
    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[2]/ul/li[2]/a") public WebElement jenkins;
    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[3]/a") public WebElement framework;
    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[3]/ul/li[1]/a") public WebElement testng;

    public String pageHeaderGetText(WebElement element)
    {
       return element.getText();
    }


}
