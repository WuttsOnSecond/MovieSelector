package dev.wutt.movie.selector.model;

import java.awt.*;
import java.util.Random;

public class Film {

    private String title;
    private String link;
    private Double rating;

    public Film(String title, String link, Double rating) {
        this.title = title;
        this.link = link;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return title + " ---- " + rating;
    }
}