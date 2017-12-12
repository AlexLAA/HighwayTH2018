package lesson3.webDriverExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by lolik on 11.12.2017.
 */
public class CommonErrors {



    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com"); // Cannot navigate to invalid URL

        driver.findElement(By.cssSelector("//*[@class='jack']"));  //*[@class='jack'] - xpath syntax


    }

}
