package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.Optional;

/**
 * This class is used to print the information
 * of the boarding pass and can go back or go on.
 * @author Xinlei Ge
 */
public class InformationController {
    /**The user id od the passenger*/
    public static String user_id;
    public static String chosenSeat;

    /**labels used to print the information*/
    @FXML
    Label name,flight,destination,date,gate;

    /**labels used to warn the passenger*/
    @FXML
    Label warn;

    /**button used to go to food page*/
    @FXML
    private Button toFood;

    /**button used to go back to seat selection*/
    @FXML
    private Button backSeat;

    PageController pageController = new PageController();
    Customer c = new Customer(user_id);


    /**
     * This method is used to judge if the user have printed the pass and go to the next page
     */
    @FXML
    protected void gotoFood() throws IOException {
        //To judge if the passenger has printed the boarding pass
        if(name.getText().equals(" "))
        {
            //to warn the passenger
            warn.setText("You have to print your ticket now!");
        }else{
            //go to next page
            pageController.change_page(toFood);
        }
    }

    /**
     * This method is used to go back to the previous page
     */
    @FXML
    protected void gobackSeat() throws IOException{
        Seat seatSelector = new Seat("BU1334");
        seatSelector.update(chosenSeat,0);
        //To make sure the passenger want to go back
        CommonGoBack goGoGo = new CommonGoBack(backSeat);
    }

    /**
     * This method is used to make sure if the passenger want to print the boarding pass
     */
    public void setValue(){
        //To make sure the passenger want to print
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("CONFIRMATION");
        alert.setContentText("Do you want to print your ticket?");
        Optional<ButtonType> result = alert.showAndWait();
        //if the passenger wants to print, then set the values
        if (result.get() == ButtonType.OK){
            setValues();
            warn.setText(" ");
        }
    }

    /**
     * This method is used to set the value as printing the boarding pass
     */
    public void setValues(){
        //get the value from the backend
        c.search();
        String names = c.firstName + " " + c.lastName;
        //set the value to the label
        name.setText(names);
        flight.setText(c.flightNum);
        destination.setText(c.destination);
        date.setText(c.date);
        gate.setText(c.gate);
    }
}
