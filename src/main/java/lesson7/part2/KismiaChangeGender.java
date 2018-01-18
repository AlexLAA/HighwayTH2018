package lesson7.part2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

/**
 * Created by lolik on 18.01.2018.
 */
public class KismiaChangeGender extends BrowserFactory {




    // [name='search_gender'][value='m']  - male
    // [name='search_gender'][value='f']  - male

    @Test
    public void changeGender() throws InterruptedException {
        driver.get("https://kismia.com/profile/settings#profile");


        driver.findElement(By.cssSelector(".settings-radio [value='m']")).click();
        if(isPopupPresent()){
            saveChanges();
        } else {
            driver.findElement(By.cssSelector(".settings-radio [value='f']")).click();
            saveChanges();
        }
        Thread.sleep(5000);
    }


    public boolean isPopupPresent(){
       return driver.findElements(By.cssSelector("#dialog-form")).size() > 0;
    }

    public void saveChanges(){
        driver.findElement(By.cssSelector("#dialog-form .button--green-border")).click();
        driver.findElement(By.cssSelector("[data-tab='profile'] .js_save")).click();
    }



}
