package lesson1;

import java.util.Scanner;

/**
 * Created by lolik on 04.12.2017.
 */
public class HelloUserConsoleInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String s = scanner.nextLine();
        System.out.println("Greetings, "+s+"!");
    }

}
