package lesson4;

/**
 * Created by lolik on 18.12.2017.
 */
public class JavaArithmeticalReduction {



    public static void main(String[] args) {

        int a = 10;
        int b = 5;


        a+=b; // EQUALS: a = a + b;
        System.out.println("b+=a: "+a);
        a = 10;

        a-=b; // EQUALS: a = a - b;
        System.out.println("b-=a: "+a);

        a = 10;
        a/=b; // EQUALS: a = a / b;
        System.out.println("b/=a: "+a);

        a = 10;
        a*=b; // EQUALS: a = a * b;
        System.out.println("b*=a: "+a);



    }


}
