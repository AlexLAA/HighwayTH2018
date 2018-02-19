package lessonCollections;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lolik on 2/12/18.
 */
public class MovieSortExample {


    @Test
    public void sortIt(){





        List<Movie> list = new ArrayList<>();
        list.add(new Movie("A film", 2.4));
        list.add(new Movie("B film", 2.1));
        list.add(new Movie("C film", 3.1));
        list.add(new Movie("A s film", 5.1));

        Collections.sort(list, new MovieTitlesComparator());
        System.out.println(list);


        // Collections.sort(list);
       // System.out.println(list);
    }
}
