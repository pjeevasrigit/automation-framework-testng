package pages;


import Utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    private static final By MAIL_ID=By.id("email");
    private static final By PASSWORD_ID=By.id("passwd");
    private static final By SIGN_IN=By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage  doLoginWith(String email,String password){
        enterText(MAIL_ID,email);
        enterText(PASSWORD_ID,password);
        click(SIGN_IN);
        MyAccountPage myAccountPage=new MyAccountPage(getDriver());
        return myAccountPage;
    }
}
