package task.tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import task.tests.TestBase;

public class UITestBase extends TestBase {
    WebDriver driver;
    WebDriverWait wait;

    @Parameters({"browser"})
    @BeforeClass
    public void openBrowser(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            Log.info("Opening the Chrome Browser.");
            driver = new ChromeDriver();
        }
        else if( browser.equalsIgnoreCase("firefox")){
            Log.info("Opening the Firefox Browser.");
            driver = new FirefoxDriver();
        }
        else {
            Log.info("Browser is not specified.");
        }

        //Create a wait. All the TestClasses & PageClasses have to use this wait object.
        wait = new WebDriverWait(driver,15);

        //Maximize Browser Window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser() {
        Log.info("Quiting the Browser.");
        driver.quit();
    }

    @BeforeMethod
    public void openWebApp(){
        Log.info("Opening the LEVERTON Web Application Login Page.");
        driver.get("https://platform-dev.leverton.de/login");
    }
}
