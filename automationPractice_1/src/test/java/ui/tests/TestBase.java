package ui.tests;

import Utility.BrowserUtility;
import Utility.LoggerUtility;
import constants.Browser;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class TestBase {
    HomePage homePage;
    Logger logger= LoggerUtility.getLogger(this.getClass());
    @BeforeMethod(description = "set up the homepage")
    public void setup(){
        logger.info("Starting Home Page");
        homePage=new HomePage(Browser.CHROME,true);
    }

    public BrowserUtility getInstance(){ // return type should be parent class
        return homePage;
    }


}
