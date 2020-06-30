package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage extends basePage {

    public loginPage(String _pageURL, WebDriver _driver) {
        super(_pageURL, _driver);
    }

    private By usernameTextBox = By.id("input-email");
    private By passwordTextBox = By.id("input-password");
    private By loginButton = By.xpath("//input[@type='submit']");
    private By alertMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    @Step
    public void insertEmail(String username) {
        semailTextBox().sendKeys(username);
    }

    @Step
    public void insertPassword(String password) {
        spasswordTextBox().sendKeys(password);
    }

    @Step
    public void clickLoginButton() {
        sloginButton().click();
    }

    public WebElement displayAlertMessage() {
        return driver.findElement(alertMessage);
    }

    public WebElement semailTextBox() {
        return driver.findElement(usernameTextBox);
    }

    public WebElement spasswordTextBox() {
        return driver.findElement(passwordTextBox);
    }

    public WebElement sloginButton() {
        return driver.findElement(loginButton);
    }

}
