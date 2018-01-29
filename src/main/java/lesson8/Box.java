package lesson8;

/**
 * Created by lolik on 22.01.2018.
 */
public class Box {

    public Box(){

    }

    public double width;
    public double height;
    public double depth;


    public String getVolume() {
        return "Объём коробки: " + (width * height * depth);
    }

    public void printInfo(){
        System.out.println(getVolume());
    }


}
