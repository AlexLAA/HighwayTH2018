package lesson11;

/**
 * Created by lolik on 01.02.2018.
 */
public interface Login {

    int jack = 20;

    static void run(){
        System.out.println("JACK");
    }

    default void print(){
        System.out.println("PRINT INTERFACE");
    }
}
