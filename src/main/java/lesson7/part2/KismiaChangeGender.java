package lesson7.part2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * Created by lolik on 18.01.2018.
 */
public class KismiaChangeGender extends KismiaLogin {




    // [name='search_gender'][value='m']  - male
    // [name='search_gender'][value='f']  - male

    @Test(priority = 2)
    public void changeGender() throws InterruptedException {
        driver.get("https://kismia.com/profile/settings#profile");


        Select select = new Select(driver.findElement(By.cssSelector(".settings-path__select--year")));
        System.out.println(select.getFirstSelectedOption().getAttribute("value"));


        select.selectByValue("1930");

        System.out.println(driver.findElement(By.cssSelector(".settings-radio [value='m']")).isSelected());
        System.out.println(driver.findElement(By.cssSelector(".settings-radio [value='f']")).isSelected());

        // System.out.println(driver.findElement(By.cssSelector(".settings-radio__label--m")).isSelected());
       // System.out.println(driver.findElement(By.cssSelector(".settings-radio__label--f")).isSelected());

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        String script = "var s = '';" +
                "var o = getComputedStyle(arguments[0]);" +
                "for(var i = 0; i < o.length; i++){" +
                "s+=o[i] + ':' + o.getPropertyValue(o[i])+';';}" +
                "return s;";

       // System.out.println(executor.executeScript(script, driver.findElement(By.cssSelector(".settings-radio [value='m']"))));
       // System.out.println(executor.executeScript(script, driver.findElement(By.cssSelector(".settings-radio [value='f']"))));
/*
        driver.findElement(By.cssSelector(".settings-radio [value='m']")).click();
        if(isPopupPresent()){
            driver.findElement(By.cssSelector("#dialog-form .button--green-border")).click();
        } else {
            driver.findElement(By.cssSelector(".settings-radio [value='f']")).click();
            driver.findElement(By.cssSelector("#dialog-form .button--green-border")).click();
        }*/
        Thread.sleep(5000);

    }


    public boolean isPopupPresent(){
       return driver.findElements(By.cssSelector("#dialog-form")).size() > 0;
    }




}
