package lessonMultithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lolik on 3/19/18.
 */
public class SimpleThreadRunnerSync {


    public static int counter = 0;

    public synchronized static void increment(){
        counter++;
    }

    public synchronized static int get(){
        return counter;
    }

    public static List<Integer> numbers = new ArrayList<>();

    public synchronized static void add(){
        numbers.add(get());
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 5; i++){
            SimpleThreadSync thread = new SimpleThreadSync("THREAD "+i);
            thread.start();
        }

        while (get() < 100000){
            Thread.sleep(1000);
        }
        System.out.println(numbers.size());
        System.out.println("END MAIN METHOD");


    }
}
