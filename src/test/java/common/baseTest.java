package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class baseTest {
    public WebDriver driver;
    String baseURL="https://demo.opencart.com/";

    @BeforeMethod(alwaysRun = true)
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
