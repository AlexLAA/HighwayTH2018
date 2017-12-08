package lesson2.publicExample;

/**
 * Created by lolik on 07.12.2017.
 */
public class MainPublicExample {


    public static void main(String[] args) {

        // public field access anywhere
        System.out.println("Male age: "+Male.age);

        // private field is only for class
        System.out.println("Female age: no access");

    }

}
