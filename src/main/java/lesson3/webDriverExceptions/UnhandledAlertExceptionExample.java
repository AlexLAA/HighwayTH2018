package lesson3.webDriverExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by lolik on 11.12.2017.
 */
public class UnhandledAlertExceptionExample {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.plus2net.com/javascript_tutorial/window-alert1.php");
        driver.findElement(By.cssSelector("input")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input")).click();
        driver.quit();
    }

}
