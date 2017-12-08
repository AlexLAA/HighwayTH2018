package lesson2.variablesExample;

/**
 * Created by lolik on 07.12.2017.
 */
public class DataTypesNotInit {


    static int myInt;
    static byte myByte;
    static short myShort;
    static long myLong;

    static float myFloat;
    static double myDouble;

    static boolean myBoolean;

    static String myString;



    public static void main(String[] args) {

        System.out.println("Не назначенные переменные:");
        System.out.println("Целые числа:");
        System.out.println(myInt);
        System.out.println(myByte);
        System.out.println(myShort);
        System.out.println(myLong);
        System.out.println();
        System.out.println("Числа с точкой:");
        System.out.println(myFloat);
        System.out.println(myDouble);
        System.out.println();
        System.out.println("Булиевый тип (логический):");
        System.out.println(myBoolean);
        System.out.println();
        System.out.println("(Строка) - объект класса String:");
        System.out.println(myString);


    }

}
