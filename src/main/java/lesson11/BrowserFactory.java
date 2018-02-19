package lesson11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by lolik on 18.01.2018.
 */
public class BrowserFactory {


    public static WebDriver driver;


    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }




    @AfterSuite
    public void tearDown(){
        driver.quit();
    }




}
