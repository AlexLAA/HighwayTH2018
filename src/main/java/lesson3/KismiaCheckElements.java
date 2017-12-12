package lesson3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by lolik on 11.12.2017.
 */
public class KismiaCheckElements {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        try {
            driver.get("https://kismia.com/");
        } catch (TimeoutException e){
            System.out.println("STOP PAGE LOADING");
            ((JavascriptExecutor) driver).executeScript("window.stop"); //EXECUTE JS (like in browser console)
        }
        WebElement element = driver.findElement(By.cssSelector("#user-reg-myname"));
        System.out.println(element.isDisplayed());
        driver.quit();
    }


}
