import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class baseTest {
    public WebDriver driver;
    //public String username;
    //public String password;
    String baseURL="https://demo.opencart.com/";

    @BeforeMethod(alwaysRun = true)
    //@Parameters({"username","password","browser"})
    @Parameters({"browser"})
    public void setUpTest(@Optional("chrome")String browser){
        if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.get(baseURL);
      //  this.username = username;
        // this.password = password;

    }



    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
        try {
            driver.quit();
        }catch (WebDriverException error){
            System.out.println("Error");
        }
    }
}
