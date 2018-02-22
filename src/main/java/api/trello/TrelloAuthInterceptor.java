package api.trello;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by lolik on 03.02.17.
 */
public class TrelloAuthInterceptor implements Interceptor {


    public static final String KEY = "62084498bd8e084d05d4974993af6b27";
    public static final String TOKEN = "df5691e576f2db8d11cb5491b4f5969219d173207f4c020d7b0521a364a7f1b6";


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("key", KEY)
                .addQueryParameter("token", TOKEN)
                .build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }


}
