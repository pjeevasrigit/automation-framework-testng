package Utility;

import constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {
    private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
    Logger logger= LoggerUtility.getLogger(this.getClass());

    public WebDriver getDriver() {
        return driver.get();
    }
    public BrowserUtility(WebDriver driver){
        super();
        this.driver.set(driver);
    }
    public BrowserUtility(String browserName) {
        if (browserName.equals("chrome")) {
            driver.set( new ChromeDriver());
        } else if (browserName.equals("firefox")) {
            driver.set(new FirefoxDriver());
        } else {
            System.err.println("Invalid Browser Name");
        }
    }

    public BrowserUtility(Browser browserName) {
        if (browserName == Browser.CHROME) {
            logger.info("Launching Chrome"+browserName);
            driver.set(new ChromeDriver());
        } else if (browserName == Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
        }
    }

    public BrowserUtility(Browser browserName,boolean isHeadless) {
        if (browserName == Browser.CHROME) {
            if(isHeadless){
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--headless=old");
                options.addArguments("--window-size=1920,1080");
                logger.info("Launching Chrome"+browserName);
                driver.set(new ChromeDriver(options));
            } else{
                driver.set(new ChromeDriver());
            }

        } else if (browserName == Browser.FIREFOX) {
            if(isHeadless){
                FirefoxOptions options=new FirefoxOptions();
                options.addArguments("--headless=old");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("disable-gpu");
                logger.info("Launching Chrome"+browserName);
                driver.set(new FirefoxDriver(options));
            } else{
                driver.set(new FirefoxDriver());
            }

        }
    }



    public void goToWebsite(String url){
       logger.info("Navigate to url"+url);
        driver.get().get(url);
    }

    public void maximizeWindow(){
        driver.get().manage().window().maximize();
    }

    public void click(By locator){
        logger.info("Clicking the element "+locator);
        WebElement element=driver.get().findElement(locator);
        logger.info("Element found "+locator);
        element.click();
    }

    public void enterText(By locator,String text){
        logger.info("Entering the text "+locator);
        WebElement element=driver.get().findElement(locator);
        element.sendKeys(text);
        logger.info("Entered Text"+locator);
    }

    public String getVisibleText(By locator){
        logger.info("Getting the Element Text "+locator);
        WebElement element=driver.get().findElement(locator);
        return element.getText();
    }

    public void closeBrowser(){
        driver.get().close();
    }

    public String takeScreenshot(String name) throws IOException {
        TakesScreenshot screenshot=(TakesScreenshot)driver.get();
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
        String timestamp=format.format(date);
        String path=System.getProperty("user.dir")+"//screenshot//"+name +"_" +timestamp+".png";
        File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
        File screenshotFile=new File(path);
        FileUtils .copyFile(screenshotData,screenshotFile);
        return path;
    }
}


