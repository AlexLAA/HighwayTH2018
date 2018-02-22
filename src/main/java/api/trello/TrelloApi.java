package api.trello;

import api.trello.restClients.BatchRestClient;
import api.trello.restClients.BoardsRestClient;
import api.trello.restClients.CardsRestClient;

/**
 * Created by lolik on 2/22/18.
 */
public class TrelloApi {



    public BatchRestClient batch = new BatchRestClient();
    public CardsRestClient cards = new CardsRestClient();
    public BoardsRestClient boards = new BoardsRestClient();



}
