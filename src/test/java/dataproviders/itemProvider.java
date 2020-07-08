package dataproviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.productnPrices;
import pojo.searchItem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class itemProvider {

    @DataProvider(name="getSearchCriteria")
    private Object[][] getSearchCriteria() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/searchCriteria.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");
        List<searchItem> testData = new Gson().fromJson(dataSet, new TypeToken<List<searchItem>>() {}.getType());

        Object[][] returnValue = new Object[testData.size()][1];

        int index = 0;

        for(Object [] each: returnValue) {
            each[0] = testData.get(index++);
        }

        return returnValue;
    }

    @DataProvider(name="getProductsPrices")
    private Object[][] getProductsPrices() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/products_prices.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");
        List<productnPrices> testData = new Gson().fromJson(dataSet, new TypeToken<List<productnPrices>>() {}.getType());

        Object[][] returnValue = new Object[testData.size()][1];

        int index = 0;

        for(Object [] each: returnValue) {
            each[0] = testData.get(index++);
        }

        return returnValue;
    }

}
