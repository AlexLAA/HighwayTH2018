package lesson14;

import lesson11.BrowserFactory;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by lolik on 2/19/18.
 */
public class KismiaLoginWithCookies extends BrowserFactory{


    @Test
    public void azaza() throws IOException, InterruptedException {
        driver.get("https://kismia.com");
        List<Cookie> loginCookies = PostRequestExample.getLoginCookies();
        for(Cookie cookie : loginCookies){
            driver.manage().addCookie(cookie);
        }
        driver.get("https://kismia.com/profile");
        Thread.sleep(20000);
    }
}
