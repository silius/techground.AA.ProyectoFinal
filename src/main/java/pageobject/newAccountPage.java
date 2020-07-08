package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class newAccountPage extends basePage{
    public newAccountPage(WebDriver _driver) {
        super(_driver);
    }

    private By content = By.xpath("//div[@id='content']/h1");
    private By continueBTN = By.xpath("//a[@class='btn btn-primary']");

    public String validateContent() {
        return showContent().getText();
    }
    public void clickContinue(){ continueButton().click();}

    public WebElement showContent(){ return driver.findElement(content); }
    public WebElement continueButton(){ return driver.findElement(continueBTN);}

}
