package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class productPage extends basePage {
    private By currencyDL = By.xpath("//button[@class='btn btn-link dropdown-toggle']");
    private By currencyList = By.xpath("//button[@class='currency-select btn btn-link btn-block']");
    private By price = By.xpath("//li/h2");
    private By addToCartBTN = new By.ById("button-cart");
    private By content = new By.ById("content");
    private By alertMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    private By shoppingCart = By.linkText("shopping cart");
    private Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(6,SECONDS).pollingEvery(3, SECONDS).ignoring(NoSuchElementException.class);

    public WebElement showContent() {
        return driver.findElement(content);
    }
    public WebElement showCurrencyDropDown(){
        return driver.findElement(currencyDL);
    }
    private List<WebElement> getCurrencyList() {
        return driver.findElements(currencyList);
    }

    public WebElement displayAlertMessage() {
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(alertMessage);
            }
        });
    }
    public WebElement displayPrice() {
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(price);
            }
        });
    }

    private WebElement price(){
        return displayPrice();
    }

    @Step
    public void clickAdd() { driver.findElement(addToCartBTN).click(); }
    @Step
    public void clickShoppingCart() { driver.findElement(shoppingCart).click(); }
    @Step
    public void clickCurrency() {driver.findElement(currencyDL).click();}
    @Step
    public void selectCurrency(String currencyName) { driver.findElement(By.name(currencyName)).click(); }
    @Step
    public String getValue(){
        this.waitUntilElement(price());
        return price().getText();
    }

    public productPage(WebDriver _driver) {
        super(_driver);
    }
}
