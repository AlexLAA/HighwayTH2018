package lesson14;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lolik on 2/15/18.
 */
public class Movie implements Serializable{

    public String title;
    public double rating;
    public double metascore;
    public int year;
    public String director;
    public List<String> actors = new ArrayList<>();

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", metascore=" + metascore +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", actors=" + actors +
                '}';
    }
}
