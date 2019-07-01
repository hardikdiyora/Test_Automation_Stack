package task.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends UITestBase {
    private LoginPage _loginPage;

    @BeforeMethod
    void setUp(){
        Log.info("Navigate to Login Page");
        _loginPage = new LoginPage(driver, wait);
    }

    @Test
    void verifyLoginFailureWithWrongCredentials(){
        Log.info("Verify user is not able to login successfully with wrong credentials.");
        Boolean value = _loginPage.loginToAccount("testtask","password123");
        Assert.assertFalse(value);
    }
}
