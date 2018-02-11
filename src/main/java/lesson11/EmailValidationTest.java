package lesson11;

import lesson8.User;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lolik on 31.01.2018.
 */
public class EmailValidationTest {

    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }



    @Test(dataProvider = "names")
    public void aza(User s) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            driver.get("https://kismia.com/");
        } catch (TimeoutException e){

        }

        driver.findElement(By.cssSelector("#form-registration")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#iam-boy + label"))));
        driver.findElement(By.cssSelector("#iam-boy + label")).click();
        driver.findElement(By.cssSelector("#user-reg-myname")).clear();
        driver.findElement(By.cssSelector("#user-reg-myname")).sendKeys(s.name);

        Thread.sleep(2000);
    }



    @DataProvider
    public Object[][] names(){
        return new Object[][]{
                {new User("asd")},
                {new User("asd")},
                {new User("asd")},
                {new User("asd")}
        };
    }





    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
