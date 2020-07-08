package testcase2;

import dataproviders.itemProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.cartPage;
import pageobject.productPage;
import pageobject.searchBoxPage;
import pageobject.searchResultsPage;
import pojo.searchItem;

public class cartTest extends common.baseTest{

    @Test(description = "Searches and Adds item to SHopping Cart",dataProvider = "getSearchCriteria", dataProviderClass = itemProvider.class)
    public void user_isnt_allow_items_added_to_cart(searchItem sitem) {
        searchBoxPage search = new searchBoxPage(driver);
        searchResultsPage results = new searchResultsPage(driver);
        productPage product = new productPage(driver);
        cartPage cart = new cartPage(driver);

        search.insertCriteria(sitem.getItem());
        search.clickSearch();
        search.waitUntilElement(results.showContent());

        results.clickProduct();
        results.waitUntilElement(product.showContent());

        product.clickAdd();
        Assert.assertTrue(product.displayAlertMessage().isDisplayed());
        product.clickShoppingCart();
        product.waitUntilElement(cart.showContent());

        Assert.assertEquals(cart.showAlert().getText(),"Products marked with *** are not available in the desired quantity or not in stock!\n" +
                "×");

    }
}
