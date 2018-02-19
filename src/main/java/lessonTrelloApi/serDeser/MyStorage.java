package lessonTrelloApi.serDeser;

import java.io.Serializable;

/**
 * Created by lolik on 2/19/18.
 */
public class MyStorage implements Serializable {

    public String name;
    public int age;

    @Override
    public String toString() {
        return "MyStorage{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
