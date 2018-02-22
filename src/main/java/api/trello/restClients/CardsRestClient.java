package api.trello.restClients;

import okhttp3.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by lolik on 2/22/18.
 */
public class CardsRestClient extends TrelloRestClient {

    private static final String ENDPOINT = TrelloRestClient.baseUrl+"cards/";



    public String create(String idList, String name) throws IOException {
        RequestBody requestBody = new FormBody.Builder().add("name", name).add("idList", idList).build();
        Request request = new Request.Builder().url(ENDPOINT).post(requestBody).build();
        String response = client.newCall(request).execute().body().string();
        return response;
    }



    public String addAttachment(String cardId, File file) throws IOException {
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file))
                .build();

        Request request = new Request.Builder().url(ENDPOINT+cardId+"/attachments").post(body).build();
        String response = client.newCall(request).execute().body().string();
        return response;
    }


    public String delete(String id) {
        return null;
    }
}
