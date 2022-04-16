package com.example.demo1;

import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;


public class CheckInController implements Initializable {
    @FXML
    private Tab num_tab;

    @FXML
    private Tab id_tab;

    @FXML
    private Tab card_tab;

    @FXML
    private TextField num_text;

    @FXML
    private TextField familyName_text;

    @FXML
    private TextField id_text;

    @FXML
    private Button login;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTexts();

    }

    @FXML
    private void CheckIn() throws IOException {
        if (num_tab.isSelected()) {
            String OrderNumber = num_text.getText();

            // check order number
            if (InputCheck.checkOrderNumber(OrderNumber)){
                Customer client = new Customer(OrderNumber);
                String[] search = client.search();
                if(!"False".equals(search[0])){
                    System.out.println(search[0]);
                }else{
                    System.out.println("wrong!!!!!");
                }
            }else{
                System.out.println("so very wrong");
            }

        }
        if (id_tab.isSelected()) {

            String familyName = familyName_text.getText();
            String idNum = id_text.getText();

            // check family name and id number
            if (InputCheck.checkCustomerName(familyName) && InputCheck.checkIDNumber(idNum)){
                Customer client = new Customer(familyName, idNum);
                String[] search = client.search();
                if(!"False".equals(search[0])){
                    System.out.println(search[0]);
                }else{
                    System.out.println("wrong!!!!!");
                }
            }else{
                System.out.println("so very wrong");
            }

        }
        if (card_tab.isSelected()) {
            System.out.println("ur photo");
        }

        PageController controller = new PageController();
        controller.change_page(login);
    }


// to
    private void initTexts() {
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

    //clear everything entered
    private void clearIssueEntries() {
        num_text.clear();
        familyName_text.clear();
        id_text.clear();
    //  thingy_to_put_error_text_which_is_a_text.setText("");
    }



}
