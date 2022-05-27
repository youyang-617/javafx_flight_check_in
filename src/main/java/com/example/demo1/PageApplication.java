package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PageApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(PageApplication.class.getResource("check_in.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 960, 640);
            stage.setResizable(false);
            stage.setTitle("Login");
            stage.getIcons().add(new Image(
                    Objects.requireNonNull(PageApplication.class.getResourceAsStream("/image/plane.png"))));
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(event -> {
                event.consume();
                exit(stage);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void exit(Stage stage){
        Exit exit = new Exit(stage);
    }
    public static void main(String[] args) {
        launch();
    }
}