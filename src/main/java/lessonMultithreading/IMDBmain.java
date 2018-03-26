package lessonMultithreading;

import lesson14.Movie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by lolik on 3/19/18.
 */
public class IMDBmain {

   static OkHttpClient client = new OkHttpClient();

    public static String getRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Accept-Language", "en-US,en;q=0.5")
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static LinkedBlockingDeque<String> urls = new LinkedBlockingDeque<>();
    public static List<Movie> movies = Collections.synchronizedList(new ArrayList<Movie>());

    public static LinkedList<String> movieUrls = new LinkedList<>();

    public static String getUrl(){
        return movieUrls.removeFirst();
    }

    public static void getTopMoviesUrl() throws IOException {
        String html = getRequest("https://www.imdb.com/chart/top");
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select(".titleColumn a");
        for (Element element : elements) {
            String href = element.attr("href");
            movieUrls.add(href);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        getTopMoviesUrl();
        Thread thread = new Thread(new IMDBparser());
        Thread thread2 = new Thread(new IMDBparser());
        Thread thread3 = new Thread(new IMDBparser());
        Thread deamon = new Thread(new LogDeamon());
        deamon.setDaemon(true);
        deamon.start();
        thread.start();
        thread2.start();
        thread3.start();

        //thread3.join();
        //thread.interrupt();
        System.out.println("MAIN THREAD END");
    }

    public static class LogDeamon implements Runnable {

        @Override
        public void run() {
            while (!movieUrls.isEmpty()){
                System.out.println("PARSED MOVIES: "+movies.size());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
