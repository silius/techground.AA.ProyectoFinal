import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageobject.loginPage;
import pageobject.dashboardPage;
import pageobject.headerPage;
import dataproviders.usersProvider;
import pojo.loginData;

public class loginTest extends baseTest {



    //@Test(groups = {"login"}, priority=1)
    @Test(dataProvider = "getUserDataFromJson", dataProviderClass = usersProvider.class)
    public void allow_user_to_login(loginData logind) throws InterruptedException {
        loginPage login= new loginPage(driver.getCurrentUrl(),driver);
        headerPage header = new headerPage(driver);
        dashboardPage dashboardPage= new dashboardPage(driver);
        header.goToLogin();
        login.insertEmail(logind.getEmail());
        login.insertPassword(logind.getPassword());
        login.clickLoginButton();

        login.waitUntilElement(dashboardPage.showDashboard());
        Assert.assertEquals(dashboardPage.showDashboard().isDisplayed(),true);

    }
    //@Test(groups = {"login"}, priority=2, invocationCount = 0)
    @Test(dataProvider = "getBadUserDataFromJson", dataProviderClass = usersProvider.class)
    public void do_not_allow_user_to_do_login(loginData logind){
        loginPage login= new loginPage(driver.getCurrentUrl(),driver);
        headerPage header = new headerPage(driver);
        header.goToLogin();
        login.insertEmail(logind.getEmail());
        login.insertPassword(logind.getPassword());
        login.clickLoginButton();
        //Explicit wait
        login.waitUntilElement(login.displayAlertMessage());

        Assert.assertEquals(login.displayAlertMessage().isDisplayed(),true);
    }

}
