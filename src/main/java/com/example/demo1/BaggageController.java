package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BaggageController implements Initializable {
    public ScrollPane scroll;
    @FXML
    private GridPane grid;

    @FXML
    Label test;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        fruits.addAll(getData());
//        if (fruits.size() > 0) {
//            setChosenFruit(fruits.get(0));
//        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < 4; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("baggage_labels.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                BaggageLabelsController BaggageLabelsController = fxmlLoader.getController();
                //BaggageLabelsController.setData(fruits.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(5));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
