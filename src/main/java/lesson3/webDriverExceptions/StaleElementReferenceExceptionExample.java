package lesson3.webDriverExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by lolik on 11.12.2017.
 */
public class StaleElementReferenceExceptionExample {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.cssSelector(".fb_logo"));
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector(".fb_logo")).isDisplayed());
        driver.quit();
    }

}
