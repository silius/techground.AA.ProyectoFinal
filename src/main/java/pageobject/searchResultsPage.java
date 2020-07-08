package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchResultsPage extends basePage{
    public searchResultsPage(WebDriver _driver) {
        super(_driver);
    }

    //private By product = By.linkText("MacBook");
    private By product = By.xpath("//div[@class='image']");
    private By content = By.xpath("//h2");

    @Step
    public void clickProduct() { product().click(); }

    private WebElement product() { return driver.findElement(product); }
    public WebElement showContent(){ return driver.findElement(content); }
}
