package lesson21.strings;

/**
 * Created by lolik on 3/19/18.
 */
public class Cipher {


    public static void main(String[] args) {

        String abc = encode("abc");
        System.out.println(abc);

        //String decode = decode(abc);
        //System.out.println(decode);
    }



    static StringBuilder alphabetText = new StringBuilder("0123456789 abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,.");
    static StringBuilder cipherText = new StringBuilder("OPQRSTUVWXYZ,. abcdefghijklwxyzABCDEFGmnopqrstuvHIJKLMN0123456789");

    public static String encode(String msg) {
        StringBuilder builder = new StringBuilder(msg);
        for(int i = 0; i < builder.length(); i++){
            char c = builder.charAt(i);
            int normalIndex = alphabetText.indexOf(c + "");
            char charToReplace = cipherText.charAt(normalIndex);
            builder.setCharAt(i, charToReplace);
        }
        return builder.toString();
    }







    public static String decode(String msg){
        StringBuilder builder = new StringBuilder(msg);
        for(int i = 0; i < builder.length(); i++){
            int normalIndex = cipherText.indexOf(builder.charAt(i) + "");
            char charToReplace = alphabetText.charAt(normalIndex);
            builder.setCharAt(i, charToReplace);
        }
        return builder.toString();
    }


}
