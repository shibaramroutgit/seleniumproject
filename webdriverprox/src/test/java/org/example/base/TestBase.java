package org.example.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.JenkinsBasicPage;
import org.example.pages.TestngParalela;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBase {

    public   WebDriver driver=null;
    public  String browserName = String.valueOf(BrowserTypes.CHROME);
    public   SoftAssert  softAssert;
    public  final Logger logger = LogManager.getLogger(getClass());



    public WebDriver setupDriver() throws InterruptedException {
            switch (browserName) {
                case "CHROME":
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    driver.get("https://myqaandqc.blogspot.com/");
                    Thread.sleep(10000);
                    break;
                case "FIREFOX":
                    driver = new FirefoxDriver();
                    break;
                case "EDGE":
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    System.out.println("No Browser");
            }
            return driver;
    }

    public void driverQuit()
    {
        driver.quit();
        System.out.println(driver.toString());
    }
    public String removeSpecialCharacters(String string)
    {
        // This regex will keep only alphanumeric characters
        return string.replaceAll("[^a-zA-Z0-9]", "");
    }

    public Date getDate()
    {
        return  new Date();
    }

    public String getFormatedDate(Date date)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(date);
    }
    public void getScreenshotWebElement(WebElement element) throws IOException {
        Date date =getDate();
        String stringDate  = getFormatedDate(date);
        String timeStampName = removeSpecialCharacters(stringDate);
        String fileName = timeStampName +".jpg";
        File file = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src\\test\\screenshots\\"+fileName));
    }

    public void getScreenshotDriver() throws IOException {
        Date date =getDate();
        String stringDate  = getFormatedDate(date);
        String timeStampName = removeSpecialCharacters(stringDate);
        String fileName = timeStampName +".jpg";
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src\\test\\screenshots\\"+fileName));
    }
    public TestngParalela getTestngParalela()
    {
        return new TestngParalela(driver);
    }



    public JenkinsBasicPage getJenkinsBasicPage()
    {
        return new JenkinsBasicPage(driver);
    }



}
