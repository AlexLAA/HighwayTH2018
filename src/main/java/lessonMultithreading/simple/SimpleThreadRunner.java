package lessonMultithreading.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lolik on 3/19/18.
 */
public class SimpleThreadRunner {


    public static int counter = 0;



    public static List<Integer> numbers = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 5; i++){
            SimpleThread thread = new SimpleThread("THREAD "+i);
            thread.start();
        }

        while (counter < 100000){
            Thread.sleep(1000);
        }
        System.out.println(numbers.size());
        System.out.println("END MAIN METHOD");


    }
}
