package dev.wutt.movie.selector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MovieScraper {

    final String url = "https://www.imdb.com/chart/top/";
    static List<Film> films = new ArrayList<>();

    public List<Film> getData() {
        try {
            Document doc = Jsoup.connect(url).get();

            String movieSelector = "table.chart.full-width";

            Element table = doc.select(movieSelector).get(0);
            Elements rows = table.select("tr");

            // sublist to ignore first element containing column names
            for (Element row : rows.subList(1, rows.size())) {
                String title = row.select(".titleColumn a").text();
                String link = row.select(".titleColumn a").attr("href").toString();
                Double rating = Double.parseDouble(row.select(".imdbRating").text());

                films.add(new Film(title, link, rating));
            }



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(films);
        return films;
    }


}