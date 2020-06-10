
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.asserts.*;

public class loginTest {

    private WebDriver driver;

    @Parameters({"username","password"})
    @Test(groups = {"login"})
    public void allow_user_to_login(String username,String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/index.php?route=account/login");

        WebElement usernameTextBox = driver.findElement(By.id("input-email"));
        WebElement passwordTextBox = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();

        Thread.sleep(3000);

        WebElement dashboard = driver.findElement(By.id("account-account"));
        Assert.assertEquals(driver.findElement(By.id("account-account")).isDisplayed(),true);

        driver.quit();
    }
}
