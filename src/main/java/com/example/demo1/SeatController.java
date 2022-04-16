package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
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

    @FXML
    private Label welcomeText;

    //button to choose seat
    @FXML
    private RadioButton c1, c2, c3, c4;

    //后续需要更改的航班号，暂时设为常量


    private String myChoice = "";

    public String getMyChoice() {
        return myChoice;
    }

    public void setMyChoice(String myChoice) {
        this.myChoice = myChoice;
    }


    @FXML
    //when press the button PREVIOUS
    protected void onHelloButtonClick() {
        welcomeText.setText("还没做呢");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SeatSelector seatSelector = new SeatSelector("BU1334");
        ArrayList<String> availableSeats = seatSelector.findRemainSeats();
        String[] testChoices = (String[]) availableSeats.toArray(new String[0]);
        //add test choices to the choice box
        choose.getItems().addAll(testChoices);
        //display the value selected
        choose.setOnAction(this::getChoice);
    }
    //get the value which the user chose in the choiceBOX and set it to the text

    /**
     * 监听选座ChoiceBox并传入全局变量
     */
    public void getChoice(ActionEvent event) {
        String choice = choose.getValue();
        setMyChoice(choice);
        flightChosen.setText(choice);
    }

    public void seatContinueClick(ActionEvent event) throws IOException {
        String choice = getMyChoice();
        if (Objects.equals(choice, "")){
            flightChosen.setTextFill(Color.web("#0076a3"));
            flightChosen.setText("You haven't chosen");
        }
        else{
            SeatSelector seatSelector = new SeatSelector("BU1334");
            seatSelector.update(choice);
            System.out.println("pressed");
            //页面跳转
        }
        PageController controller = new PageController();
        controller.change_page(confirmButton);
    }


    public void getSeat(ActionEvent event) {
        String choice = null;
        if (c1.isSelected()) {
            choice = "C1";
        } else if (c2.isSelected()) {
            choice = "C2";
        } else if (c3.isSelected()) {
            choice = "C3";
        } else if (c4.isSelected()) {
            choice = "C4";
        }
        setMyChoice(choice);
        flightChosen.setText(choice);
    }
}