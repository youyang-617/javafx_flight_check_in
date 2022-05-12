package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class SeatController<Lable> implements Initializable {
    public static String user_id;
    public static boolean seatState;
    @FXML
    private Button previousButton;
    @FXML
    private Button confirmButton;
    @FXML
    Label flightChosen;
    @FXML
    private ChoiceBox<String> choose;

    @FXML
    private Label welcomeText;
    @FXML
    private Label seatStateLabel;

    private String myChoice = "";

    public String getMyChoice() {
        return myChoice;
    }

    public void setMyChoice(String myChoice) {
        this.myChoice = myChoice;
    }

    @FXML
    //when press the button PREVIOUS
    protected void goBack() throws IOException {
        PageController controller = new PageController();
        controller.change_page(previousButton);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("it's meeeee"+user_id);
        System.out.println("seat:"+seatState);
        // 通过传来的user id找到航班号
        Customer client = new Customer(user_id);
        String[] search = client.search();
        System.out.println(search[3]);
        // 通过航班号找座位
        SeatSelector seatSelector = new SeatSelector(search[3]);
        // 如果选的是普通
        if (!seatState){
            ArrayList<String> availableSeats = seatSelector.findNormalSeats();
            String[] testChoices = availableSeats.toArray(new String[0]);
            choose.setTooltip(new Tooltip("Choose your seat"));
            //add test choices to the choice box
            choose.getItems().addAll(testChoices);
            //display the value selected
            choose.setOnAction(this::getChoice);
        }
        // 如果选的是large
        else {
            ArrayList<String> availableSeats = seatSelector.findLargeSeats();
            String[] testChoices = availableSeats.toArray(new String[0]);
            choose.setTooltip(new Tooltip("Choose your seat"));
            seatStateLabel.setText("With extra leg room");
            //add test choices to the choice box

            choose.getItems().addAll(testChoices);
            //display the value selected
            choose.setOnAction(this::getChoice);
        }
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
            //在航班座位表上更新
            SeatSelector seatSelector = new SeatSelector("BU1334");
            seatSelector.update(choice);
            System.out.println("pressed");
            //在个人页面上更新
            Customer client = new Customer(user_id);
            String[] search = client.search();
            client.ModifySeatNum(choice,search);
            //页面跳转
        }
        PageController controller = new PageController();
        controller.change_page(confirmButton);
        //controller.setValue();
    }
}