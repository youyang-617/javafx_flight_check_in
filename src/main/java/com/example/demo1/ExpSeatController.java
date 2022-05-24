package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExpSeatController  implements Initializable {
    public static String user_id;
    public static boolean seatState=false;
    public ToggleGroup seat;
    @FXML
    private RadioButton c1, c2;
    @FXML
    private Button expSeat;
    @FXML
    private Button expBack;

    @FXML
    //when press the button PREVIOUS
    protected void goBack() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log out");
        alert.setHeaderText("You are about to log out");
        alert.setContentText("Do you really want to log out?");

        if (alert.showAndWait().get() == ButtonType.OK){
            PageController controller = new PageController();
            controller.change_page(expBack);
        }
    }

    @FXML
    private void goNext() throws IOException {
        System.out.println(user_id);

        PageController controller = new PageController();
        controller.change_page(expSeat);
    }

    public void setSeat(ActionEvent event) {
        seatState = !c1.isSelected();
        SeatController.seatState = ExpSeatController.seatState;
        System.out.println("ext:"+seatState);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SeatController.seatState = false;
        System.out.println("ext:"+seatState);
    }
}
