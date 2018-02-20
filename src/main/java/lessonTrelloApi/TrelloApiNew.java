package lessonTrelloApi;

import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by lolik on 2/19/18.
 */
public class TrelloApiNew {

    public static final String KEY = "62084498bd8e084d05d4974993af6b27";
    public static final String TOKEN = "df5691e576f2db8d11cb5491b4f5969219d173207f4c020d7b0521a364a7f1b6";

    OkHttpClient client = new OkHttpClient();

    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String getBoardList(String boardId) throws IOException {
        String url = "https://api.trello.com/1/boards/"+boardId+"/lists?cards=all&key="+KEY+"&token="+TOKEN;
        String response = get(url);
        return response;
    }

    public String getBoardLabels(String boardId) throws IOException {
        String url = "https://api.trello.com/1/boards/"+boardId+"/labels?key="+KEY+"&token="+TOKEN;
        String response = get(url);
        return response;
    }

    @Test
    public void testRequest() throws IOException {
        String response = post("https://httpbin.org/post", "{\"param\":\"jack\"}");
        System.out.println(response);
    }


}
