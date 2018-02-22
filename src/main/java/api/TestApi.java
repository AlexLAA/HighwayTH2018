package api;

import api.trello.TrelloApi;
import api.trello.models.Board;
import api.trello.models.List;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by lolik on 2/22/18.
 */
public class TestApi {


    @Test
    public void azaza() throws IOException {
        TrelloApi trelloApi = new TrelloApi();


        java.util.List<List> lists = trelloApi.boards.lists("JKegetyW", null);
        for(List l : lists){
            String resp = trelloApi.cards.create(l.id, "JackSparrowApi");
            System.out.println(resp);
        }
    }
}
