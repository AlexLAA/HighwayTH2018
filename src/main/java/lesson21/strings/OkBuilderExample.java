package lesson21.strings;

import lesson14.DefaultCookieStorage;
import lesson14.UserAgentInterceptor;
import okhttp3.OkHttpClient;
import org.openqa.selenium.Cookie;

import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by lolik on 3/19/18.
 */
public class OkBuilderExample {


    OkHttpClient client = new OkHttpClient.Builder()
            .cookieJar(new DefaultCookieStorage())
            .addInterceptor(new UserAgentInterceptor(""))
            .connectTimeout(10, TimeUnit.SECONDS)
            .build();



    Cookie cookie = new Cookie.Builder("", "")
            .domain("")
            .path("/")
            .expiresOn(new Date())
            .build();


}
