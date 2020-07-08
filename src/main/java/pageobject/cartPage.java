package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage extends basePage {
    private By alertMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    private By content = new By.ById("content");

    public WebElement showContent() { return driver.findElement(content); }
    public WebElement showAlert() { return driver.findElement(alertMessage); }

    public cartPage(WebDriver _driver) {
        super(_driver);
    }
}
