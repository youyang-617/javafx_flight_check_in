package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * Display the baggage information on page
 * including loading corresponding baggage information and displaying then on screen
 *
 */
public class BaggageController implements Initializable {
    public static String user_id;
    public ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Button goback;
    @FXML
    private Button finish;

    @FXML
    Label test;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Customer client = new Customer(user_id);
        String[] search = client.search();

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < Integer.parseInt(search[9]) ; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("baggage_labels.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                BaggageLabelsController BaggageLabelsController = fxmlLoader.getController();
                BaggageLabelsController.setData(i,search[0]+" "+search[1],search[3],search[10],search[11]);

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

    @FXML
    private void GoBack(){
        CommonGoBack goGoGo = new CommonGoBack(goback);

    }
    @FXML
    private void Finish() throws IOException {
        PageController controller = new PageController();
        controller.change_page(finish);
    }


}
