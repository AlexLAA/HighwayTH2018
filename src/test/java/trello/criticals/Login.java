package trello.criticals;

import io.qameta.allure.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by lolik on 2/26/18.
 */
@Epic("Criticals")
@Feature("Login")
public class Login {

    @Test(description = "Логин обычным пользователем")
    @Description("Проверка логина обычным юзером, должно работать нормально ))")
    @Parameters({"email", "password"})
    @Story("Login as regular user")
    public void loginAsRegularUser(String email, String password){
        login(email, password);

    }

    @Step("Login")
    public void login(String email, String password){
        get("https://trello.com");
        type(email);
        type(password);
        someAttachment("MY ATTACHMENT");
    }


    @Attachment
    public String someAttachment(String text) {
        return text;
    }



    @Step("Open Page: {0}")
    public void get(String url){
        System.out.println(url);
    }

    @Step
    public void type(String text){

    }



}
