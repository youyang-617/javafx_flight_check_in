package com.example.demo;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SeatController<Lable> implements Initializable {
    @FXML
    private Button previousButton;
    @FXML
    private Button confirmButton;
    @FXML
    private Label flightChosen;
    @FXML
    private ChoiceBox<String> choose;
    private String[] testChoices = {"我饿了","很痛苦","你呢"};

    @FXML
    private Label welcomeText;

    @FXML
    //when press the button PREVIOUS
    protected void onHelloButtonClick() {
        welcomeText.setText("还没做呢");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //add test choices to the choice box
        choose.getItems().addAll(testChoices);
        //display the value selected
        choose.setOnAction(this::getChoice);
    }
    //get the value which the user chose in the choiceBOX and set it to the text
    public void getChoice(ActionEvent event){
        String myChoice = choose.getValue();
        flightChosen.setText(myChoice);
    }
}