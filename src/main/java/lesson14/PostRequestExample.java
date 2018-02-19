package lesson14;

import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lolik on 2/15/18.
 */
public class PostRequestExample {


    static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new UserAgentInterceptor("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36"))
            .cookieJar(new DefaultCookieStorage())
            .build();


    @Test
    public void kismiaLogin() throws IOException {


        client.newCall(new Request.Builder().url("https://kismia.com/").build()).execute().body().string();

        RequestBody formBody = new FormBody.Builder()
                .add("email", "loliktest1@mail.ru")
                .add("password", "qwe1rty2")
                .build();
        Request request = new Request.Builder()
                .url("https://kismia.com/sign/in")
                .post(formBody)
                .build();

        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
        String string = client.newCall(new Request.Builder().url("https://kismia.com/profile").build()).execute().body().string();
        System.out.println(string);


        List<Cookie> cookies = DefaultCookieStorage.cookies;
        for(Cookie cookie :cookies){

        }

    }

    public static List<org.openqa.selenium.Cookie> getLoginCookies() throws IOException {
        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();

        client.newCall(new Request.Builder().url("https://kismia.com/").build()).execute().body().string();

        RequestBody formBody = new FormBody.Builder()
                .add("email", "loliktest1@mail.ru")
                .add("password", "qwe1rty2")
                .build();
        Request request = new Request.Builder()
                .url("https://kismia.com/sign/in")
                .post(formBody)
                .build();

        String response = client.newCall(request).execute().body().string();
        List<Cookie> cookies = DefaultCookieStorage.cookies;
        for(Cookie cookie :cookies){
            org.openqa.selenium.Cookie.Builder builder = new org.openqa.selenium.Cookie.Builder(cookie.name(), cookie.value());
            seleniumCookies.add(builder.build());
        }

        return seleniumCookies;
    }
}
