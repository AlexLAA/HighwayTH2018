package lessonCollections;

import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by lolik on 2/12/18.
 */
public class ListExample {


    @Test
    public void azaza(){


        Set<String> set = new LinkedHashSet<>();

      /*  List<String> stringList = new ArrayList<>();
        stringList.add("Jack");
        stringList.add("Maria");
        stringList.add("Pavel");
        stringList.add("Timur");
        System.out.println(stringList);*/



        List<String> list = new ArrayList<>();
        list.add("Pavel");
        list.add("Alexey");
        list.add("Timur");

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);


    }


}
