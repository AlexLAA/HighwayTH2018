package lesson7.part2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by lolik on 18.01.2018.
 */
public class KismiaLogin extends BrowserFactory {




    @Test
    @Parameters({"email", "password"})
    public void login(@Optional("Loliktest1@mail.ru")String email, @Optional("qwe1rty2")String password) throws InterruptedException {
        System.out.println("EMAIL: "+email);
        System.out.println("PASSWORD: "+password);
        try {
            driver.get("https://kismia.com");
        } catch (Exception e){
            System.out.println("STOP LOADING WINDOW");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("return window.stop");
        }



        driver.findElement(By.cssSelector("#user-email")).clear();
        driver.findElement(By.cssSelector("#user-email")).sendKeys(email);
        driver.findElement(By.cssSelector("#user-password")).clear();
        driver.findElement(By.cssSelector("#user-password")).sendKeys(password);
        driver.findElement(By.cssSelector("#sign-in-form .submit")).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("kismia.com/u"), "Wrong PAGE: "+driver.getCurrentUrl());

    }



}
