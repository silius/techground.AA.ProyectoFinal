package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerPage extends basePage {
    public registerPage(WebDriver _driver) {
        super(_driver);
    }

    private By first_nameTextBox = By.id("input-firstname");
    private By last_nameTextBox = By.id("input-lastname");
    private By emailTextBox = By.id("input-email");
    private By telephoneTextBox = By.id("input-telephone");
    private By passwordTextBox = By.id("input-password");
    private By passwordConfirmTextBox = By.id("input-confirm");
    private By continueButton = By.xpath("//input[@type='submit']");
    private By termsCheckBox = By.xpath("//input[@type='checkbox']");

    @Step
    public void insertFirstName(String name) {
        first_nameTextBox().sendKeys(name);
    }
    @Step
    public void insertLastName(String lname){ last_nameTextBox().sendKeys(lname);}
    @Step
    public void insertEmail(String email){ emailTextBox().sendKeys(email);}
    @Step
    public void insertTelephone(String telephone){ telephoneTextBox().sendKeys(telephone);}
    @Step
    public void insertPassword(String password){ passwordTextBox().sendKeys(password);}
    @Step
    public void insertPasswordConfirmation(String password){ passwordConfirmTextBox().sendKeys(password);}
    @Step
    public void checkTerms(){ termsCheckBox().click();}
    @Step
    public void clickSubmit(){ continueButton().click();}

    private WebElement first_nameTextBox() { return driver.findElement(first_nameTextBox);}
    private WebElement last_nameTextBox() { return driver.findElement(last_nameTextBox);}
    private WebElement telephoneTextBox() { return driver.findElement(telephoneTextBox);}
    private WebElement passwordTextBox() { return driver.findElement(passwordTextBox);}
    private WebElement passwordConfirmTextBox() { return driver.findElement(passwordConfirmTextBox);}
    private WebElement emailTextBox() { return driver.findElement(emailTextBox);}
    private WebElement continueButton() { return driver.findElement(continueButton);}
    private WebElement termsCheckBox() { return driver.findElement(termsCheckBox);}


}
