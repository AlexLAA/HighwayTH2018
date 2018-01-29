package lesson9;

/**
 * Created by lolik on 25.01.2018.
 */
public class MethodsExample {



    public static void main(String[] args) {
        getSquare(1, 4);
       // int square = getSquare();
        System.out.println(getSquare());


    }


    public static int getSquare() {
        return 3 * 5;
    }

    public static int getSquare(int a, int b){
        return a*b;
    }



}
