package testcase3;

import dataproviders.itemProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.productPage;
import pageobject.searchBoxPage;
import pageobject.searchResultsPage;
import pojo.productnPrices;

public class priceCurrencyTest extends common.baseTest{

    @Test(description = "Verifies price per currency for products",dataProvider = "getProductsPrices", dataProviderClass = itemProvider.class)
    public void price_matches_currency(productnPrices item) {
        searchBoxPage search = new searchBoxPage(driver);
        searchResultsPage results = new searchResultsPage(driver);
        productPage product = new productPage(driver);

        search.insertCriteria(item.getItem());
        search.clickSearch();
        search.waitUntilElement(results.showContent());

        results.clickProduct();
        results.waitUntilElement(product.showCurrencyDropDown());

        product.clickCurrency();
        //Test Euro
        product.selectCurrency("EUR");
        Assert.assertEquals(product.getValue(),item.getPrice().getEu());
        //Test GBP
        product.clickCurrency();
        product.selectCurrency("GBP");
        Assert.assertEquals(product.getValue(),item.getPrice().getUk());
        //Test US
        product.clickCurrency();
        product.selectCurrency("USD");
        Assert.assertEquals(product.getValue(),item.getPrice().getUs());

    }

}
