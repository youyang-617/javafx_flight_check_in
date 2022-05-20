package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {
    public static String user_id;
    @FXML
    private Label money;

    @FXML
    private Label type;


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

//    public void checkIn() throws IOException {
//        if (num_tab.isSelected()) {
//            String OrderNumber = num_text.getText();
//
//            // check order number
//            if (InputCheck.checkOrderNumber(OrderNumber)) {
//                Customer client = new Customer(OrderNumber);
//
//                if (!"False".equals(client.search()[0])) {
//                    String[] search = client.search();
//                    System.out.println(search[0]);
//                    // successfully logged in
//                    setPageInfo(OrderNumber);
//                    PageController controller = new PageController();
//                    controller.change_page(login);
//                } else {
//                    num_label.setText("no user found");
//                }
//            } else {
//                num_label.setText("wrong pattern(should be 6 digits)");
//            }
//
//        }
//    }
}