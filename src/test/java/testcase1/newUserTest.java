package testcase1;

import dataproviders.usersProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.dashboardPage;
import pageobject.headerPage;
import pageobject.newAccountPage;
import pageobject.registerPage;
import pojo.userRegister;

public class newUserTest extends common.baseTest {

    @Test(groups = "sanity", description = "Registers a new user account",dataProvider = "getNewUserDataFromJson", dataProviderClass = usersProvider.class)
    public void createNewUser(userRegister newuser) {
        headerPage header = new headerPage(driver);
        dashboardPage dashboardPage= new dashboardPage(driver);
        registerPage register = new registerPage(driver);
        newAccountPage accpage = new newAccountPage(driver);

        header.goToRegister();
        register.insertFirstName(newuser.getFirst_name());
        register.insertLastName(newuser.getLast_name());
        register.insertEmail(newuser.getSaltString()+"@null.org");
        register.insertTelephone(newuser.getTelephone());
        register.insertPassword(newuser.getPassword());
        register.insertPasswordConfirmation(newuser.getPassword());
        register.checkTerms();
        register.clickSubmit();

        register.waitUntilElement(accpage.showContent());
        Assert.assertEquals(accpage.validateContent(),"Your Account Has Been Created!");
        accpage.clickContinue();

        accpage.waitUntilElement(dashboardPage.showDashboard());
        Assert.assertTrue(dashboardPage.showDashboard().isDisplayed());
    }
}
