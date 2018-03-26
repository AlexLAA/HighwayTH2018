package lessonMultithreading.simple;

/**
 * Created by lolik on 3/19/18.
 */
public class SimpleThread extends Thread {

    String name;

    public SimpleThread(String name){
        this.name = name;
    }





    @Override
    public void run() {
        while (SimpleThreadRunner.counter != 100000){
            SimpleThreadRunner.counter++;
            System.out.println(name+" : "+ SimpleThreadRunner.counter);
            SimpleThreadRunner.numbers.add(SimpleThreadRunner.counter);
        }

    }


}
