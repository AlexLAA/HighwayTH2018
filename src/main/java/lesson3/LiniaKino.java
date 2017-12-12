package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by lolik on 11.12.2017.
 */
public class LiniaKino {




    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://liniakino.com/showtimes/aladdin/");
        driver.findElement(By.xpath("//*[@id='closeButton']")).click();
        driver.findElement(By.xpath("//*[@class='showtimes-list']//*[@class='showtime-movie'][2]//*[contains(@class,'showtime-day')][7]//*[@class='showtime-item'][5]/a")).click();
        Thread.sleep(5000);

        WebElement hallFrame = driver.findElement(By.xpath("//*[@class='arcticmodal-container_i']//iframe"));
        driver.switchTo().frame(hallFrame);

        List<WebElement> seats = driver.findElements(By.xpath("//*[@id='hall-scheme-container']//*[contains(@id,'hseat')]"));
        seats.get(10).click();
        seats.get(20).click();
        Thread.sleep(5000);
        driver.quit();
    }



}
