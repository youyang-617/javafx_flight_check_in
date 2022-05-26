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

    private Boolean flag=false;

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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("You need to pay again for changed food or seat, operation irreversible!");
        alert.setContentText("The original payment will be returned to your card within 3 working days");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            PageController controller = new PageController();
            controller.change_page(goback_pay);
        }

    }
    @FXML
    private void Next() throws IOException {
        if(flag){
            PageController controller = new PageController();
            controller.change_page(next_pay);
        }else{
            num_label.setText("You haven't finish your payment!");
        }


    }
    @FXML
    private void Pay()  {
        String Card = card.getText();
        String Pswd = password.getText();

        if (InputCheck.checkCreditCardNumber(Card)&&InputCheck.checkCreditCardPassword(Pswd)) {

            if(CreditCards.checkCreditCards(Card, Pswd)){
                flag = true;
                num_label.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Payment accomplished!");
                alert.setContentText("Click OK to continue");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    warn.setText(" ");
                }
            } else {
                num_label.setText("wrong input of either card number or password");
            }
        } else {
            num_label.setText("wrong number of digits entered");
        }

    }


}