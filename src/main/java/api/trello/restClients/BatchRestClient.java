package api.trello.restClients;

import okhttp3.HttpUrl;
import okhttp3.Request;

import java.io.IOException;

/**
 * Created by lolik on 2/22/18.
 */
public class BatchRestClient extends TrelloRestClient {


    public String getBatch(String urls) throws IOException {
        Request request = new Request.Builder().url(TrelloRestClient.baseUrl+"batch?urls="+urls).build();
        String response = client.newCall(request).execute().body().string();
        return response;
    }



}
