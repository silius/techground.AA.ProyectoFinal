package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class headerPage extends basePage {
    private By myAccountLink = By.linkText("My Account");
    private By loginLink = By.linkText("Login");

    public headerPage(WebDriver _driver) {
        super(_driver);
    }

    public void clickMyAccountLink() {
        driver.findElement(this.myAccountLink).click();
    }
    public void clickLoginLink() {
        driver.findElement(this.loginLink).click();
    }
    public void goToLogin(){
        this.clickMyAccountLink();
        this.clickLoginLink();
    }

}
