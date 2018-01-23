package lesson8;

/**
 * Created by lolik on 22.01.2018.
 */
public class StringMethodsExample {
    public static void main(String[] args) {


        Box.type = "asdasd";
        Box box = new Box();
        String names = "Pavel,Tim,Alex";
        String[] splited = names.split(",");
        for(String name : splited){
            System.out.println(name);
        }
    }
}
