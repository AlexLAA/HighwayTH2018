package lesson11;

import org.testng.annotations.Test;

/**
 * Created by lolik on 31.01.2018.
 */
public class FactoryExample extends BrowserFactory {


    @Test
    public void azaza(){
        driver.get("http://www.oschadbank.ua/ua/");
        String pageSource = driver.getPageSource();
        String startUSDBuy = "buy-USD\" data-buy=\"";
        String endUSDBuy = "\">";
        pageSource = pageSource.substring(pageSource.indexOf(startUSDBuy)+startUSDBuy.length());
        System.out.println(pageSource.substring(0, pageSource.indexOf(endUSDBuy)));
    }







}
