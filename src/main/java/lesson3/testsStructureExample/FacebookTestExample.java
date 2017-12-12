package lesson3.testsStructureExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by lolik on 11.12.2017.
 */
public class FacebookTestExample extends BrowserFactory {



    @Test
    public void facebookLogin(){
        driver.get("https://facebook.com");

        driver.findElement(By.cssSelector("")).clear();
        driver.findElement(By.cssSelector("")).sendKeys("email");

        driver.findElement(By.cssSelector("")).clear();
        driver.findElement(By.cssSelector("")).sendKeys("password");

        driver.findElement(By.cssSelector("")).click();

        System.out.println("PAGE TITLE: "+driver.getTitle());

    }

}
