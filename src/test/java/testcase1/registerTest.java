package testcase1;

import dataproviders.usersProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.dashboardPage;
import pageobject.headerPage;
import pageobject.newAccountPage;
import pageobject.registerPage;
import pojo.userRegister;
import utilities.helpers;

public class registerTest extends common.baseTest {

    @Test(groups = "sanity", description = "Registers a new user account",dataProvider = "getNewUserDataFromJson", dataProviderClass = usersProvider.class)
    public void user_is_allowed_to_register(userRegister newuser) {
        helpers util = new helpers();
        headerPage header = new headerPage(driver);
        dashboardPage dashboardPage= new dashboardPage(driver);
        registerPage register = new registerPage(driver);
        newAccountPage accpage = new newAccountPage(driver);

        header.goToRegister();
        register.insertFirstName(newuser.getFirst_name());
        register.insertLastName(newuser.getLast_name());
        register.insertEmail(util.generateRandomEmail()+"@null.org");
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
