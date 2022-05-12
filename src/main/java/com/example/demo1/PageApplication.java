package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PageApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(PageApplication.class.getResource("check_in.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 960, 640);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> {
                event.consume();
                logout(stage);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void logout(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("You're about to exit!");
        alert.setContentText("Are you sure?");

        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You successfully exit");
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}