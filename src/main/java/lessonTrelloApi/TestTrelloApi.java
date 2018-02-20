package lessonTrelloApi;

import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by lolik on 2/19/18.
 */
public class TestTrelloApi {


    @Test
    public void testGetBoardLists() throws IOException {
        TrelloApiNew trelloApiNew = new TrelloApiNew();
        String boardList = trelloApiNew.getBoardLabels("JKegetyW");
        System.out.println(boardList);
    }
}
