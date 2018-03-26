
import lesson14.Movie;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

/**
 * Created by lolik on 3/5/18.
 */
public class ReflectionExample {


    @Test
    public void azaza() throws IllegalAccessException, NoSuchFieldException {
        Movie movie = new Movie();
        movie.title = "My Movie";
        Field[] fields = movie.getClass().getFields();
        for(Field field : fields){
            System.out.println(field.getName());
            System.out.println(field.get(movie));
        }
    }

    @Test
    public void getPrivateField() throws NoSuchFieldException, IllegalAccessException {
        Movie movie = new Movie();
        movie.title = "My Movie";
        Class aClass = movie.getClass();

        System.out.println("___________");
        Field myPrivateString = aClass.getDeclaredField("myPrivateString");
        myPrivateString.setAccessible(true);
        System.out.println(myPrivateString.get(movie));
        //myPrivateString.set(movie, "Jack");
        System.out.println(myPrivateString.get(movie));

    }

    @Test
    public void getDeclaredFields(){
        Movie movie = new Movie();
        Class aClass = movie.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field field : declaredFields){
            field.setAccessible(true);
            System.out.println(field.getName());
        }
    }


}
