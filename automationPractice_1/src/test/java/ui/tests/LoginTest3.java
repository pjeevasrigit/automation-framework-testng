package ui.tests;

import Utility.LoggerUtility;
import constants.Browser;
import dataProviders.LoginDataProvider;
import listners.MyRetryAnalyser;
import listners.TestListner;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pages.HomePage;
import pojo.User;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListner.class)
public class LoginTest3 extends TestBase {
    /*Test Method - Test Script should be small
       you cannot add conditional statements, loops, try catch in your test method
       reduce use of local variables
       Atleast one assertions
        */

    @Test (description = "login test",dataProviderClass= dataProviders.LoginDataProvider.class,
            dataProvider="LoginTestDataProvider")
    public void loginTest(User user){

        //assertEquals(homePage.goToLoginPage().doLoginWith("jeevasri@gmail.com","test@123").getUserName(),"Jeevasri P");
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Jeevasri P");

    }

    @Test(dataProvider = "LoginTestCSVDataProvider", dataProviderClass = LoginDataProvider.class)
    public void loginCSVTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Jeevasri P");

        System.out.println("Username: " + user.getEmailAddress());
        System.out.println("Password: " + user.getPassword());
    }

    @Test(dataProvider = "LoginTestExcelDataProvider", dataProviderClass = LoginDataProvider.class
            ,retryAnalyzer = MyRetryAnalyser.class,groups = {"e2e","sanity"})
    public void loginExcelTest(User user) {

        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Jeevasri P");
        System.out.println("Username: " + user.getEmailAddress());
        System.out.println("Password: " + user.getPassword());

    }

    @AfterTest
    public void closeBrowser(){
        homePage.closeBrowser();
    }


}


