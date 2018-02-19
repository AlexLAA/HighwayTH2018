package lesson14;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.List;

public class DefaultCookieStorage implements CookieJar {

    public static List<Cookie> cookies = new ArrayList<>();


    @Override
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        System.out.println(list);
        cookies.addAll(list);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        return cookies;
    }

}
