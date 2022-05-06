package com.example.demo1;

import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTexts();

    }
    /**
     * for log in
     **/
    @FXML
    private void CheckIn() throws IOException {
        // choose to log in with ID number
        if (num_tab.isSelected()) {
            String OrderNumber = num_text.getText();

            // check order number
            if (InputCheck.checkOrderNumber(OrderNumber)){
                Customer client = new Customer(OrderNumber);

                if(!"False".equals(client.search()[0])){
                    String[] search = client.search();
                    System.out.println(search[0]);
                    // successfully logged in
                    setPageInfo(OrderNumber);
                    PageController controller = new PageController();
                    controller.change_page(login);
                }else{
                    num_label.setText("no user found");
                }
            }else{
                num_label.setText("wrong pattern(should be 6 digits)");
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
                    System.out.println(search[5]);
                    // successfully log in
                    setPageInfo(search[5]);
                    PageController controller = new PageController();
                    controller.change_page(login);
                }else{
                    fam_label.setText("no user found");
                    System.out.println("wrong!!!!!");
                }
            }else{
                fam_label.setText("incorrect Family name or ID");
                System.out.println("so very wrong");
            }

        }
        if (card_tab.isSelected()) {
            System.out.println("ur photo");
            setPageInfo("100001");
            PageController controller = new PageController();
            controller.change_page(login);
        }


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

    // paa the id number to all pages
    public void setPageInfo(String OrderNumber){
//        SeatController seat = new SeatController();
//        PageController page = new PageController();
//        BaggageController baggage = new BaggageController();
//        StageManager.CONTROLLER.put("seat", seat);
//        StageManager.CONTROLLER.put("page", page);
//        StageManager.CONTROLLER.put("baggage",baggage);
//        System.out.println(StageManager.CONTROLLER);

//        SeatController seatControl=(SeatController) StageManager.CONTROLLER.get("seat");
//        PageController pageControl=(PageController) StageManager.CONTROLLER.get("page");

        SeatController.user_id =OrderNumber;
        PageController.user_id=OrderNumber;
        BaggageController.user_id=OrderNumber;
        BaggageLabelsController.user_id=OrderNumber;
    }

}
