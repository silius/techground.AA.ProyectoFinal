package dataproviders;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.loginData;
import pojo.userRegister;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class usersProvider {
    @DataProvider(name="getUserDataFromJson")
    private Object[][] getUserDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/users.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");
        List<loginData> testData = new Gson().fromJson(dataSet, new TypeToken<List<loginData>>() {}.getType());

        Object[][] returnValue = new Object[testData.size()][1];

        int index = 0;

        for(Object [] each: returnValue) {
            each[0] = testData.get(index++);
        }

        return returnValue;
    }

    @DataProvider(name="getBadUserDataFromJson")
    private Object[][] getBadUserDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/badUsers.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");
        List<loginData> testData = new Gson().fromJson(dataSet, new TypeToken<List<loginData>>() {}.getType());

        Object[][] returnValue = new Object[testData.size()][1];

        int index = 0;

        for(Object [] each: returnValue) {
            each[0] = testData.get(index++);
        }

        return returnValue;
    }

    @DataProvider(name="getNewUserDataFromJson")
    private Object[][] getNewUserDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/newUsers.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataset");
        List<userRegister> testData = new Gson().fromJson(dataSet, new TypeToken<List<userRegister>>() {}.getType());

        Object[][] returnValue = new Object[testData.size()][1];

        int index = 0;

        for(Object [] each: returnValue) {
            each[0] = testData.get(index++);
        }

        return returnValue;
    }
}
