package lesson3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/**
 * Created by lolik on 11.12.2017.
 */
public class BrowserCookies {


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie cookie : cookies){
            System.out.println(cookie);
        }
        driver.quit();
    }
}
