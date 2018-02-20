package lessonTrelloApi;

import com.google.gson.Gson;
import lessonTrelloApi.models.Card;
import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by lolik on 2/19/18.
 */
public class TrelloApi {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    Gson gson = new Gson();



    OkHttpClient client = new OkHttpClient();

    public void getBoardLists(String boardId) throws IOException {
        Request request = new Request.Builder().url("https://api.trello.com/1/boards/"+boardId+"/lists?cards=all&key="+TrelloLoginPass.key+"&token="+TrelloLoginPass.token).build();
        String string = client.newCall(request).execute().body().string();
        System.out.println(string);
    }

    public void createCard(String idList, Card card) throws IOException {
        String json = gson.toJson(card);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/cards?idList="+idList+"&key="+TrelloLoginPass.key+"&token="+TrelloLoginPass.token)
                .post(body).build();
        String string = client.newCall(request).execute().body().string();
        System.out.println(string);
    }



    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Test
    public void testApi() throws IOException {
        getBoardLists("JKegetyW");
        /*Card card = new Card();
        card.name = "Created via API 2";
        card.desc = "TEST DESC";
        createCard("5a8aaf5838440fc96023077d", card);*/
    }
}
