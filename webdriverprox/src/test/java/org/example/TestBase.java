package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class TestBase {

    public    WebDriver driver=null;
    public String browserName = String.valueOf(BrowserTypes.CHROME);


    public WebDriver setupDriver() throws InterruptedException {
            switch (browserName) {
                case "CHROME":
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
    public void tx()
    {
        System.out.println(browserName);
    }

    /*public static void main(String[] args) {
        TestBase t = new TestBase();
        t.tx();
    }*/

}
