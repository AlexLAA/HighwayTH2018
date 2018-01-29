package lesson8;

/**
 * Created by lolik on 25.01.2018.
 */
public class HeavyBox extends Box {

    int weight; // вес коробки

    public void printInfo(){
        System.out.println(getVolume());
        System.out.println("Вес коробки: "+weight);
    }


}
