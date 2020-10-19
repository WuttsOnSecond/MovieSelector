package dev.wutt.movie.selector;

import dev.wutt.movie.selector.model.MovieScraper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MovieScraper topFilms = new MovieScraper();

        primaryStage.setTitle("Movie Selector");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui.fxml"));
        BorderPane pane = loader.<BorderPane>load();

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
