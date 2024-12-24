package pages;

import Utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {
    private static final By USERNAME=By.xpath("//a[@title=\"View my customer account\"]//span");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName(){
    return getVisibleText(USERNAME);
    }
}
