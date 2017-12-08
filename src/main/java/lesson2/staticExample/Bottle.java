package lesson2.staticExample;

/**
 * Created by lolik on 07.12.2017.
 */
public class Bottle {

    public static String type;
    public String name;
    public double amount;

    @Override
    public String toString() {
        return name+" : "+amount;
    }
}
