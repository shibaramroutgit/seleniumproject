package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestngParalela extends HomePage{

    public WebDriver driver;

    public TestngParalela(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[3]/ul/li[1]/ul/li[3]/a") public WebElement paralelaPage;
    @FindBy(xpath = "//*[@id=\"Blog1\"]/div[1]/div/div/div[1]/div[1]/h3") public WebElement HeaderText;
    public void navigateToTestngParalelaMenu() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(framework).click().build().perform();
        Thread.sleep(1000);
        actions.moveToElement(testng).click().build().perform();
        Thread.sleep(1000);
        actions.moveToElement(paralelaPage).click().build().perform();
    }
    public String validateTestngPageHeader()
    {
        return  pageHeaderGetText(HeaderText);
    }





}
