package lesson12Abs;

/**
 * Created by lolik on 05.02.2018.
 */
public class Dog extends Pet {

    @Override
    public void voice() {
        System.out.println("GAF GAF");
        isHungry = true;
    }

    @Override
    public void move() {
        if(isHungry){
            System.out.println("I need food!");
            return;
        }
        System.out.println("Ok, I'll walk...");
    }



    public void barkDogName(){
        System.out.println("JACK");
    }

}
