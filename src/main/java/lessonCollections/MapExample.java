package lessonCollections;

import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by lolik on 2/22/18.
 */
public class MapExample {


    @Test
    public void azaza(){
        List<String> list = new ArrayList<>();

        Set<String> set = new HashSet<>();

        Map<String, String> map = new HashMap<>();
        map.put("user1", "Masha");
        map.put("user2", "Dima");
        map.put("user3", "Pavel");
        map.put("user1", "Slava");

        System.out.println(map);


        String value = map.get("user1");
        System.out.println(value);


    }



    @Test
    public void mapFor(){

        Map<String, Double> map = new HashMap<>();
        map.put("StarWars1", 9.0);
        map.put("StarWars2", 9.0);
        map.put("StarWars3", 5.7);


        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for(Map.Entry<String, Double> entry : entries){
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println("Movie title: "+key+" Rating: "+value);
        }

    }


    @Test
    public void listIterator(){
        List<String> sexNames = new ArrayList<>();
        sexNames.add("Slava");
        sexNames.add("Jack");
        sexNames.add("Jessika");
        sexNames.add("Kolya");
        sexNames.add("Kolya");

        System.out.println("Original: "+sexNames);
        Iterator<String> iterator = sexNames.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            if(s.contains("J")){
                iterator.remove();
            }
        }


        System.out.println("Removed: "+sexNames);
    }


    public class KeyValue{
        public String key;
        public String value;
    }
}
