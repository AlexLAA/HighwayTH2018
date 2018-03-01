package lesson11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Created by lolik on 18.01.2018.
 */
public class BrowserFactory {


    public static WebDriver driver;


    @BeforeSuite
    public void setUp() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("pageLoadStrategy", "none");
        driver = new ChromeDriver(caps);
    }




    @AfterSuite
    public void tearDown(){
        driver.quit();
    }




}
