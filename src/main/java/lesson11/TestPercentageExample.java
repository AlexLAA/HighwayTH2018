package lesson11;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by lolik on 01.02.2018.
 */
public class TestPercentageExample {


    @Test(priority = 2)
    public void a(){
        System.out.println("A");
    }

    @Test(priority = 1)
    public void b(){
        System.out.println("B");
    }

}
