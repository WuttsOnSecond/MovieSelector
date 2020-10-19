package dev.wutt.movie.selector.controller;

import dev.wutt.movie.selector.model.Film;
import dev.wutt.movie.selector.model.MovieScraper;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

public class FXController {

    // pulls data from IMDB's top 250 list and stores it in an Array List
    MovieScraper scraper = new MovieScraper();
    List<Film> films = scraper.getData();
    Random random = new Random();

    public Hyperlink output;
    int randomUpperBound = 250;

    // event listener that pulls a random film from list
    // then display a hyperlink to its entry on IMDB
    public void onClick(ActionEvent e) throws URISyntaxException {
        if (films.size() > 0) {
            int idx = random.nextInt(randomUpperBound);
            randomUpperBound--;

            output.setText(films.get(idx).toString());
            String url = films.get(idx).getLink();
            output.setOnAction(e1 -> {
                try {
                    System.out.println("idx: " + idx);
                    Desktop.getDesktop().browse(new URI("https://www.imdb.com/" + url));
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (URISyntaxException e3) {
                    e3.printStackTrace();
                }
            });

            films.remove(idx);
        }

        else output.setText("You've already viewed all 250 films.");
    }
}
