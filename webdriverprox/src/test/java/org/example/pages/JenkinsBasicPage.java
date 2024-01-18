package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JenkinsBasicPage extends HomePage{

    public WebDriver driver;

    public JenkinsBasicPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[2]/ul/li[2]/ul/li[1]/a") public WebElement jenkinBasic;
    @FindBy(xpath = "//*[@id=\"Blog1\"]/div[1]/div/div/div[1]/div[1]/h3") public WebElement HeaderText;

    public String validateJenkinsPageHeader()
    {
        //return jBasic.getText();
        return pageHeaderGetText(HeaderText);
    }
    public void navigateToJenkinsBasicMenu() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(cicd).click().build().perform();
        Thread.sleep(1000);
        actions.moveToElement(jenkins).click().build().perform();
        Thread.sleep(1000);
        actions.moveToElement(jenkinBasic).click().build().perform();

    }


}
