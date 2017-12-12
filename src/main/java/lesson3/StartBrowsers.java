package lesson3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by lolik on 11.12.2017.
 */
public class StartBrowsers {


    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.gecko.driver", "/Users/lolik/webDrivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        Thread.sleep(10000);
        driver.quit();
    }


}
