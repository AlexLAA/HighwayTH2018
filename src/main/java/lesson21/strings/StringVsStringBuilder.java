package lesson21.strings;

/**
 * Created by lolik on 3/19/18.
 */
public class StringVsStringBuilder {

    public static int count = 100000;


    public static void main(String[] args) {
        long stringMillis = timeConcatString();
        long stringBuilderMillis = timeConcatStringBuilder();
        System.out.println("String concat time: "+stringMillis);
        System.out.println("StringBuilder concat time: "+stringBuilderMillis);
    }

    public static long timeConcatString(){
        long before = System.currentTimeMillis();
        String output = "Some text";
        for(int i = 0; i < count; i++)
            output = output + "Some text";
        //creates 100 new objects
        System.out.println(output);
        long after = System.currentTimeMillis();
       return after-before;
    }

    public static long timeConcatStringBuilder(){
        long before = System.currentTimeMillis();
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < count; i++)
            output.append("Some text"); //use 1 object only
        System.out.println(output);
        long after = System.currentTimeMillis();
        return after-before;
    }






}
