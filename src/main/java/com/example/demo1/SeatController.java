package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class SeatController implements Initializable {
    /**
     * Global variables passed between pages, used to identify the user
     */
    public static String user_id;
    /**
     * Global variables passed between pages, used to record whether the selection is a regular seat or a large seat
     */
    public static boolean seatState;
    /**
     * Global variables passed between pages, used to record the seat user chosen
     */
    public static String chosenSeat;
    /**
     * used to show user-selected seats
     */
    private String myChoice = "";

    @FXML
    public ImageView seatsImage;
    @FXML
    private Button previousButton;
    @FXML
    private Button confirmButton;
    @FXML
    Label flightChosen;
    @FXML
    private ChoiceBox<String> choose;
    @FXML
    private Label seatStateLabel;


    /**
     * getter of parameter 'myChoice''
     * @return value of 'myChoice'
     */
    public String getMyChoice() {
        return myChoice;
    }
    /**
     * setter of parameter 'myChoice''
     */
    public void setMyChoice(String myChoice) {
        this.myChoice = myChoice;
    }

    /**
     * When pressed the 'back' button, go back to the previous page
     * @throws IOException Exception loading page file
     */
    @FXML
    protected void goBack() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Go back");
        alert.setHeaderText("You are about to go back to the previous page");
        alert.setContentText("The data you have filled in on this page will not be recorded");

        if (alert.showAndWait().get() == ButtonType.OK){
            PageController controller = new PageController();
            controller.change_page(previousButton);
        }
    }

    /**
     * Initialize the page, run when the page loads
     * @param url the page parameter, generated automatically
     * @param resourceBundle the page parameter, generated automatically
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("it's meeeee"+user_id);
        System.out.println("seat:"+seatState);
        // Find the flight number by the passed user id
        Customer client = new Customer(user_id);
        String[] search = client.search();
        System.out.println(search[3]);
        // Find the seating chart by flight number
        Seat seatSelector = new Seat(search[3]);
        // if choosing the normal seats
        if (!seatState){
            ArrayList<String> availableSeats = seatSelector.findNormalSeats();
            String[] testChoices = availableSeats.toArray(new String[0]);
            choose.setTooltip(new Tooltip("Choose your seat"));
            //add test choices to the choice box
            choose.getItems().addAll(testChoices);
            //display the value selected
            choose.setOnAction(this::getChoice);
        }
        // else if choosing the large ones
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
     * get the value which the user chose in the choiceBOX, call the method in 'Seat.java'
     * to store it, display it, and send it to the file
     * and then pass it to the next page to complete the goBack function
     * (To go back, add the value back to the table of seats to be selected)
     * @param event mouse click and other actions
     */
    public void getChoice(ActionEvent event) {
        String choice = choose.getValue();
        setMyChoice(choice);
        flightChosen.setText(choice);
        flightChosen.setTextFill(Color.web("#45bbbf"));
        chosenSeat= choice;
        InformationController.chosenSeat=SeatController.chosenSeat;
    }

    /**
     * when the 'next' button is pressed, judge if user has chosen seat
     * If selected, jump to the next page; otherwise, prompt the user should select and not jump
     * @param event click the button
     * @throws IOException Exception loading page file
     */
    public void seatContinueClick(ActionEvent event) throws IOException {
        String choice = getMyChoice();
        System.out.println("mychoice"+choice);
        if (Objects.equals(choice, "")){
            System.out.println("?");
            flightChosen.setTextFill(Color.web("red"));
            flightChosen.setText("You haven't chosen");
        }
        else{
            // Update on the flight seating chart
            Seat seatSelector = new Seat("BU1334");
            seatSelector.update(choice);
            System.out.println("pressed");
            // Update the user information
            Customer client = new Customer(user_id);
            String[] search = client.search();
            client.ModifySeatNum(choice,search);
            // jump to the next page
            PageController controller = new PageController();
            controller.change_page(confirmButton);
            //controller.setValue();
        }
    }
}