package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


/**
 * Initialize the screen with the display of extra fee and set and food selection
 * and check the credit card information and pay for extra fee
 */
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

    private Boolean flag = false;


    /**
     * Initialize the screen with the display of extra fee and set and food selection
     *
     * @param location  the page parameter, generated automatically
     * @param resources the page parameter, generated automatically
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Customer client = new Customer(user_id);
        client.search();
        String meal = client.getTypeOfMeal();
        String seat = client.getSeatNum();
        int extrafee = client.getMoney();
        money.setText("£" + extrafee);
        type.setText("Seat " + seat + " and Meal " + meal);
    }


    /**
     * when pressing the 'back' button, go to the previous page
     */
    @FXML
    private void GoBack() {
        PayGoBack goGoGo = new PayGoBack(goback_pay);
    }


    /**
     * when pressing the 'next' button, go to the next page
     *
     * @throws IOException Exception loading page file
     */
    @FXML
    private void Next() throws IOException {
        if (flag) {
            PageController controller = new PageController();
            controller.change_page(next_pay);
        } else {
            num_label.setText("You haven't finished your payment!");
        }


    }

    /**
     * check the credit card information and pay for extra fee
     */
    @FXML
    private void Pay() {
        String Card = card.getText();
        String Pswd = password.getText();

        if (InputCheck.checkCreditCardNumber(Card) && InputCheck.checkCreditCardPassword(Pswd)) {

            if (CreditCards.checkCreditCards(Card, Pswd)) {
                flag = true;
                num_label.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Payment accomplished!");
                alert.setContentText("Click OK to continue");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
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