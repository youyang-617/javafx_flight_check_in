package com.example.demo1;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * A concrete implementation of the GoBack class for logging out
 * @author Yuqi Liu (youyang617@outlook.com)
 */
public class Exit{
    public Exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("You're about to exit!");
        alert.setContentText("Are you sure?");

        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You successfully exit");
            stage.close();
        }
    }
}
