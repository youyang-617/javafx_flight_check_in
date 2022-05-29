package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Controller of the check-in page
 */
public class CheckInController implements Initializable {
    @FXML
    private Tab num_tab;

    @FXML
    private Tab id_tab;

    @FXML
    private Tab card_tab;

    @FXML
    TextField num_text;

    @FXML
    private TextField familyName_text;

    @FXML
    private TextField id_text;

    @FXML
    private Button login;

    @FXML
    private Label num_label;

    @FXML
    private Label fam_label;

    @FXML
    private Label photo_label;

    /**
     * Clear information in the tabs when initializing the page
     * @param url the page parameter, generated automatically
     * @param rb the page parameter, generated automatically
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        num_tab.setOnSelectionChanged((Event event) -> {
            clearIssueEntries();
        });
        id_tab.setOnSelectionChanged((Event event) -> {
            clearIssueEntries();
        });
        card_tab.setOnSelectionChanged((Event event) -> {
            clearIssueEntries();
        });

    }

    /**
     * Triggered when user clicks on check in button
     * Reads and determines different inputs depending on the user's chosen login method
     * @throws IOException Exception loading page file
     */
    @FXML
    private void CheckIn() throws IOException {

        if (num_tab.isSelected()) {
            String OrderNumber = num_text.getText();
            if (InputCheck.checkOrderNumber(OrderNumber)) {
                Customer client = new Customer(OrderNumber);
                if (!"False".equals(client.search()[0])) {
                    String[] search = client.search();
                    setPageInfo(OrderNumber);
                    PageController controller = new PageController();
                    controller.change_page(login);
                } else {
                    num_label.setText("no user found");
                }
            } else {
                num_label.setText("wrong pattern(should be 6 digits)");
            }
        }

        if (id_tab.isSelected()) {
            String familyName = familyName_text.getText();
            String idNum = id_text.getText();
            if (InputCheck.checkCustomerName(familyName) && InputCheck.checkIDNumber(idNum)) {
                Customer client = new Customer(familyName, idNum);
                String[] search = client.search();
                if (!"False".equals(search[0])) {
                    // successfully log in
                    setPageInfo(search[5]);
                    PageController controller = new PageController();
                    controller.change_page(login);
                } else {
                    fam_label.setText("no user found");
                }
            } else {
                fam_label.setText("incorrect Family name or ID");
            }
        }

        if (card_tab.isSelected()) {
            photo_label.setText("Sorry, function still to be developed");

        }
    }

    /**
     * Triggered when the user changes the login method, clearing the original input
     */
    private void clearIssueEntries() {
        num_text.clear();
        familyName_text.clear();
        id_text.clear();

    }
    /**
     * pass the id number of the user logged in to all pages
     * @param OrderNumber the id number of the user logged in
     */
    public void setPageInfo(String OrderNumber) {
        SeatController.user_id = OrderNumber;
        PageController.user_id = OrderNumber;
        BaggageController.user_id = OrderNumber;
        BaggageLabelsController.user_id = OrderNumber;
        ExpSeatController.user_id = OrderNumber;
        PaymentController.user_id = OrderNumber;
        InformationController.user_id = OrderNumber;
        FoodController.user_id = OrderNumber;
        ExpensiveFoodController.user_id = OrderNumber;
    }

}
