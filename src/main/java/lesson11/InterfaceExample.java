package lesson11;

import java.util.function.Predicate;

/**
 * Created by lolik on 01.02.2018.
 */
public class InterfaceExample {


    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.contains("jack");
        System.out.println(predicate.test("asdjackasd"));
        Login login = new LoginVK();
        login.print();
    }


}
