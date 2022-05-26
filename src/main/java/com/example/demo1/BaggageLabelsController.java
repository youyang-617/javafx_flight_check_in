package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * loading corresponding baggage information and pass them to BaggageController
 */
public class BaggageLabelsController {
    public static String user_id;
    @FXML
    private Label count;

    @FXML
    private Label flight;

    @FXML
    private Label from;

    @FXML
    private Label to;

    @FXML
    private Label name;

    /**
     * loading corresponding baggage information and displaying then on screen
     * @param i the baggage number
     * @param Name the passenger's name
     * @param flt the flight number
     * @param dep the departure place
     * @param des the destination

     */
    public void setData(int i,String Name,String flt,String dep,String des) {
        count.setText(String.valueOf(i+1));
        name.setText(Name);
        flight.setText(flt);
        from.setText(dep);
        to.setText(des);
    }
}
