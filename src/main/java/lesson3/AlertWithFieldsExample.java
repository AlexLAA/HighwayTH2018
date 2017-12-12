package lesson3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by lolik on 11.12.2017.
 */
public class AlertWithFieldsExample {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        WebElement iFrame = driver.findElement(By.cssSelector("#iframeResult"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("JACK SPARROW!");
        Thread.sleep(2000);
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(5000);
        driver.quit();
    }

}
