package trello.criticals;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by lolik on 2/26/18.
 */
@Epic("Criticals")
@Feature("Board Actions")
public class BoardActions {

    @Test
    @Story("Create Board")
    public void createBoard(){
        Assert.assertTrue(false, "RESPONSE CODE == 404");
    }

    @Test
    @Story("Remove Board")
    public void removeBoard(){
        throw new NullPointerException();
    }

}
