package lesson12Abs;

/**
 * Created by lolik on 05.02.2018.
 */
public abstract class Pet {

    protected boolean isHungry = false;

    public abstract void voice();
    public abstract void move();


    public boolean isHungry(){
        return isHungry;
    }


}
