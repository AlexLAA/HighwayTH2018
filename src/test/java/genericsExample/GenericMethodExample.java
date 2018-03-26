package genericsExample;

import java.util.Comparator;
import java.util.List;

/**
 * Created by lolik on 3/5/18.
 */
public class GenericMethodExample {



    public static <T extends Number> double sum(T v1, T v2){
        return v1.doubleValue()+v2.doubleValue();
    }


    public static double sumWC(List<? extends Number> list){
        double result = 0.0;
        for (Number number : list) {
            result += number.doubleValue();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(sum(1.2, 2.3));
    }
}
