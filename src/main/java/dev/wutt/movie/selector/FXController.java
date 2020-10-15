package dev.wutt.movie.selector;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FXController {

    MovieScraper scraper = new MovieScraper();
    List<Film> films = scraper.getData();
    Random random = new Random();

    public Hyperlink output;
    int randomUpperBound = 250;

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
