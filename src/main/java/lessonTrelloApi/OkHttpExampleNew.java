package lessonTrelloApi;

import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by lolik on 2/19/18.
 */
public class OkHttpExampleNew {

    OkHttpClient client = new OkHttpClient();



    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    @Test
    public void testRequest() throws IOException {
        String response = post("https://httpbin.org/post", "{\"param\":\"jack\"}");
        System.out.println(response);
    }

}
