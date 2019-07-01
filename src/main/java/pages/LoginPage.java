package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private static By logo = By.cssSelector("div[class='logo']");
    private static By username_tb = By.id("username");
    private static By password_tb = By.id("password-field");
    private static By login_btn = By.cssSelector("input[type='submit']");
    private static By login_error_title = By.cssSelector("p[class='subtitle']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        waitUntilElementVisible(logo);
    }

    /***
     * log in to account with username and password.
     * @param username the username of account.
     * @param password the password of account.
     * @return if login successful then true else false.
     *
     * NOTE : Ideally, We need to return page object means if login successful
     * then Dashboard Page otherwise Login Page instance.
     */
    public Boolean loginToAccount(String username, String password) {
        Log.info("Enter the Username.");
        inputText(username_tb, username);
        Log.info("Enter the Password.");
        inputText(password_tb, password);
        Log.info("Click on Log In button.");
        click(login_btn);
        if(isElementPresent(login_error_title)){
            Log.info("Login failure, please navigate to Login Page again");
            return false;
        }
        else{
            Log.info("Login successful, please navigate to Dashboard Page");
            return true;
        }
    }

}
