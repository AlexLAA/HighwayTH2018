package lesson2.staticExample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lolik on 07.12.2017.
 */
public class Party {


    static List<Bottle> bottles = new ArrayList<>();

    public static void main(String[] args) {

        Bottle.type = "Whiskey";

        Bottle bottle1 = new Bottle();
        bottle1.name = "Jack Daniels";
        bottle1.amount = 0.5;

        Bottle bottle2 = new Bottle();
        bottle2.name = "Jameson";
        bottle2.amount = 1.0;

        bottles.add(bottle1);
        bottles.add(bottle2);

        System.out.println("At Friday we will drink: ");
        System.out.println("Alcohol type: "+Bottle.type);
        System.out.println(bottles);

/*        bottles.clear();

        Bottle.type = "Beer";

        Bottle beer1 = new Bottle();
        beer1.name = "Hoegaarden";
        beer1.amount = 0.3;

        Bottle beer2 = new Bottle();
        beer1.name = "Guinness";
        beer1.amount = 0.5;

        bottles.add(beer1);
        bottles.add(beer2);

        System.out.println("After that: ");
        System.out.println("Alcohol type: "+Bottle.type);
        System.out.println(bottles);*/


    }


}
