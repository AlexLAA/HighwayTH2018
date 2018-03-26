package email;

import org.apache.commons.mail.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by lolik on 3/1/18.
 */
public class SendEmailTest  {

    @Test
    public void azaza(){

    }

/*
    @Test
    public void azzaza() throws EmailException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        String pageSource = driver.getPageSource();

        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.googlemail.com"); // Set SMTP hostname
        email.setSmtpPort(465); // Set port
        email.setAuthenticator(new DefaultAuthenticator("trello@onthe.io", "qwe1rty2")); // Set email/password
        email.setSSLOnConnect(true); // SSL true
        email.setFrom("user@gmail.com"); // set FROM
        email.setSubject("TestMail"); // set Subject
        email.setHtmlMsg(pageSource); // Set message
        email.addTo("lolikla8@gmail.com"); // Set recipients
        email.send(); // Send Email
    }
*/



}
