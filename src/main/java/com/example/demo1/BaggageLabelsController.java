package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

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


    public void setData(int i,String Name,String flt,String dep,String des) {
        count.setText(String.valueOf(i+1));
        name.setText(Name);
        flight.setText(flt);
        from.setText(dep);
        to.setText(des);
    }
}
