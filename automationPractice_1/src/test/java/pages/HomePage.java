package pages;

import Utility.BrowserUtility;

import static Utility.PropertyUtility.*;

import Utility.JSONUtility;
import Utility.LoggerUtility;
import constants.Browser;
import static constants.Env.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.Properties;

public final class HomePage extends BrowserUtility {
    private static final By SIGNIN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");
    Logger logger= LoggerUtility.getLogger(this.getClass());


    public HomePage(Browser browserName,boolean isHeadless) {
        super(browserName,isHeadless);
       // goToWebsite(readProperty(QA,"URL"));
        logger.info("Navigate to Website");
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    public LoginPage goToLoginPage(){
        click(SIGNIN_LINK_LOCATOR);
        LoginPage loginPage=new LoginPage(getDriver());
        return loginPage;

    }
}
