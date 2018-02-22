package api.trello.restClients;

import api.trello.TrelloAuthInterceptor;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by lolik on 2/22/18.
 */
public class TrelloRestClient {

    protected Gson gson = new Gson();
    protected OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new TrelloAuthInterceptor()).build();

    protected static final String baseUrl = "https://api.trello.com/1/";




}
