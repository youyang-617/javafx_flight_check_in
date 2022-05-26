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
    private Label warn;

    @FXML
    private Label num_label;

    @FXML
    private Label type;
    @FXML
    private TextField card;

    @FXML
    private TextField password;

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
        String Card = card.getText();
        if (InputCheck.checkCreditCardNumber(Card)) {
        } else {
            num_label.setText("wrong pattern(should be 6 digits)");
        }





        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Payment accomplished!");
        alert.setContentText("Click OK to continue");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            warn.setText(" ");
        }


    }


}