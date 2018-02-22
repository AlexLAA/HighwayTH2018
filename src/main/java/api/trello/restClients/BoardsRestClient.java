package api.trello.restClients;

import api.trello.models.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by lolik on 2/22/18.
 */
public class BoardsRestClient extends TrelloRestClient {

    private static final String ENDPOINT = TrelloRestClient.baseUrl+"boards/";


    public Board get(String id) throws IOException {
        Request request = new Request.Builder().url(ENDPOINT+id).build();
        String response = client.newCall(request).execute().body().string();
        Gson gson = new Gson();
        Board board = gson.fromJson(response, Board.class);
        return board;
    }


    public List<api.trello.models.List> lists(String id, Map<String, String> params) throws IOException {
        String url = ENDPOINT+id+"/lists";
        Request request = new Request.Builder().url(url).build();
        String response = client.newCall(request).execute().body().string();
        List<api.trello.models.List> list = gson.fromJson(response, new TypeToken<List<api.trello.models.List>>(){}.getType());
        return list;
    }


}
