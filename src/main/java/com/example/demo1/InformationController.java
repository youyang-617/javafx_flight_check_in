package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Optional;

public class InformationController {
    public static String user_id;
    public static String chosenSeat;
    @FXML
    Label name,flight,destination,date,gate,warn,food_warn,food_warn1;
    @FXML
    private Button button_next;
    @FXML
    private Button back_seat;

    @FXML
    protected void goto_next() throws IOException {
        PageController pageController = new PageController();
        //go to the page food
        System.out.println(name.getText());
        if(name.getText().equals(" "))
        {
            warn.setText("You have to print your ticket now!");
            // System.out.println("aaaaaaaaaaaaaaa");
        }else{
            pageController.change_page(button_next);
            //Alert err = new Alert(Alert.AlertType.INFORMATION);
            //err.setTitle("Information Dialog");
            //err.setHeaderText(null);
            //err.setContentText("In this page, you can select some nomarl food.If you want to update the meal set you can click next button.");
            //err.show();
        }
    }
    @FXML
    protected void goback_seat() throws IOException{
        PageController pageController = new PageController();
        pageController.change_page(back_seat);
        System.out.println(chosenSeat);
    }
    public void setValue(){


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("CONFIRMATION");
        alert.setContentText("Do you want to print your ticket?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){

            setValues();
            warn.setText(" ");
        }

    }

    public void setValues(){
        System.out.println(user_id);
        Customer c = new Customer(user_id);
        c.search();
        String names = c.firstName + " " + c.lastName;
        name.setText(names);
        flight.setText(c.flightNum);
        destination.setText(c.destination);
        date.setText(c.date);
        gate.setText(c.gate);
        System.out.println(c.lastName);
    }
}
