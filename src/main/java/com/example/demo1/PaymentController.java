package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {
    public static String user_id;
    @FXML
    private Label money;
    @FXML
    Label warn;
    @FXML
    private Label type;

    @FXML
    private Button goback_pay;
    @FXML
    private Button next_pay;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Customer client = new Customer(user_id);
        client.search();
        String meal=client.getTypeOfMeal();
        String seat=client.getSeatNum();
        int extrafee=client.getMoney();
        money.setText("$"+ extrafee);
        type.setText("Seat " + seat + " and Meal "+ meal);
    }

    @FXML
    private void GoBack() throws IOException {
        PageController controller = new PageController();
        controller.change_page(goback_pay);

    }
    @FXML
    private void Next() throws IOException {
        PageController controller = new PageController();
        controller.change_page(next_pay);

    }
    @FXML
    private void Pay()  {
        System.out.println("111111111");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("CONFIRMATION");
        alert.setContentText("Do you want to print your ticket?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){

            warn.setText(" ");
        }


    }


}