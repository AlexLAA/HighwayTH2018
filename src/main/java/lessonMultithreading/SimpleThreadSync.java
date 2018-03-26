package lessonMultithreading;

/**
 * Created by lolik on 3/19/18.
 */
public class SimpleThreadSync extends Thread {

    String name;

    public SimpleThreadSync(String name){
        this.name = name;
    }





    @Override
    public void run() {
        while (SimpleThreadRunnerSync.get() != 100000){
            SimpleThreadRunnerSync.increment();
            System.out.println(name+" : "+ SimpleThreadRunnerSync.get());
            SimpleThreadRunnerSync.add();
        }

    }


}
