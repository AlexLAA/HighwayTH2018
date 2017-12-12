package lesson3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by lolik on 11.12.2017.
 */
public class AlertExample {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.plus2net.com/javascript_tutorial/window-alert1.php");
        driver.findElement(By.cssSelector("input")).click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.cssSelector("input")).click();
        driver.quit();
    }

}
