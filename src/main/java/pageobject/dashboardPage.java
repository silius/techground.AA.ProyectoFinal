package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboardPage extends basePage {
    private By dashboard = By.id("account-account");

    public dashboardPage(WebDriver _driver) {
        super(_driver);
    }

    public WebElement showDashboard() {
        return driver.findElement(this.dashboard);
    }

}
