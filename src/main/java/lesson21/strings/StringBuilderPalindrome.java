package lesson21.strings;

/**
 * Created by lolik on 3/19/18.
 */
public class StringBuilderPalindrome {

    public static void main(String[] args) {
        String palindrome = "moom";
        StringBuilder builder = new StringBuilder(palindrome);
        builder.reverse();
        if (palindrome.equals(builder.toString()))
            System.out.println("Palindrome");
        else
            System.out.println("Not palindrome");
    }

}
