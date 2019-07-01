package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger Log = Logger.getLogger(BasePage.class);

    BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    /****
     * click on the element.
     * @param locator locator of web element.
     ****/
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    /***
     * wait until element to be visible.
     * @param locator locator of web element.
     */
    public void waitUntilElementVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /***
     * enter the text into text box.
     * @param locator locator of web element.
     * @param text text to be fill in web element like textbox or text area.
     *
     */
    public void inputText(By locator, String text) {
        waitUntilElementVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    /***
     * Check whether element is present or not.
     *  @param locator locator of web element.
     */
    public boolean isElementPresent(By locator) {
        try {
            waitUntilElementVisible(locator);
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
