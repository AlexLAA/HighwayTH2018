package lesson2.voidExample;

/**
 * Created by lolik on 07.12.2017.
 */
public class ShowVoidExample {

    public static void main(String[] args) {

        // Method 'getName()' returns String type, you can use it to assign a variable;
        String name = getName();
        System.out.println(name);


        // ERROR: 'printName()' has no return type, you can only execute it;
        // String name2 = printName(); // ERROR (Try uncomment)

        printName(); // RIGHT USAGE

    }



    public static String getName(){
        return "JACK";
    }

    public static void printName(){
        System.out.println("Jack");
    }



}
