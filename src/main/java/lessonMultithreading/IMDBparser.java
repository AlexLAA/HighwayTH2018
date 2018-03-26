package lessonMultithreading;

import lesson14.Movie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static lessonMultithreading.IMDBmain.getUrl;
import static lessonMultithreading.IMDBmain.movieUrls;
import static lessonMultithreading.IMDBmain.movies;

/**
 * Created by lolik on 3/19/18.
 */
public class IMDBparser implements Runnable {

    OkHttpClient client = new OkHttpClient();

    public String getRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Accept-Language", "en-US,en;q=0.5")
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Override
    public void run() {
        while (!movieUrls.isEmpty()){
            try {
                Movie movie = parseMovie();
                movies.add(movie);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Movie parseMovie() throws IOException {
        Movie movie = new Movie();
        String html = getRequest("https://www.imdb.com" + getUrl());
        Document doc = Jsoup.parse(html);
        movie.title = doc.select(".title_wrapper h1").get(0).text();
        try {
            movie.rating = Double.parseDouble(doc.select(".imdbRating [itemprop='ratingValue']").get(0).text());
            movie.metascore = Double.parseDouble(doc.select(".metacriticScore span").get(0).text());
            movie.year = Integer.parseInt(doc.select("#titleYear a").get(0).text());
            movie.director = doc.select("[itemprop='director'] span").get(0).text();
        } catch (Exception e){
            System.out.println("No MetaScore: "+movie.title);
            throw e;
        }
        System.out.println("PARSED: "+movie);
        return movie;
    }
}
