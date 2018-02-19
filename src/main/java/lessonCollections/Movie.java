package lessonCollections;

import java.io.Serializable;

/**
 * Created by lolik on 2/12/18.
 */
public class Movie implements Comparable<Movie>, Serializable{

    public String title;
    public double score;

    public Movie(String title, double score){
        this.title = title;
        this.score = score;
    }

    @Override
    public int compareTo(Movie m) {
        return (score < m.score) ? -1 : ((score == m.score) ? 0 : 1);
    }


    @Override
    public String toString() {
        return title+" score: "+score;
    }


}
