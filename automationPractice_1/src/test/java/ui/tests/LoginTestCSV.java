package ui.tests;

import constants.Browser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pojo.User;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTestCSV {
    /*Test Method - Test Script should be small
       you cannot add conditional statements, loops, try catch in your test method
       reduce use of local variables
       Atleast one assertions
        */
    HomePage homePage;


    @Test (description = "login test",dataProviderClass= dataProviders.LoginDataProvider.class,
            dataProvider="LoginTestDataProvider")
    public void loginTest(User user){

        //assertEquals(homePage.goToLoginPage().doLoginWith("jeevasri@gmail.com","test@123").getUserName(),"Jeevasri P");
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Jeevasri P");

    }

}


