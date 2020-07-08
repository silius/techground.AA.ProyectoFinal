package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchBoxPage extends basePage{

    private By searchBoxInput = new By.ByName("search");
    private By searchBoxBtn = new By.ByXPath("//span[@class='input-group-btn']/button");

    @Step
    public void insertCriteria(String criteria){ searchBoxInput().sendKeys(criteria);}
    @Step
    public void clickSearch(){ searchBoxBtn().click();}

    private WebElement searchBoxInput() { return driver.findElement(searchBoxInput); }
    private WebElement searchBoxBtn() { return driver.findElement(searchBoxBtn); }


    public searchBoxPage(WebDriver _driver) {
        super(_driver);
    }
}
