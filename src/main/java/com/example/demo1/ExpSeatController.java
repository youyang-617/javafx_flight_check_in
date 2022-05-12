package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.io.IOException;

public class ExpSeatController {
    public static String user_id;
    public static boolean seatState=false;
    @FXML
    private RadioButton c1, c2;
    @FXML
    private Button expSeat;
    @FXML
    private Button expBack;
    @FXML
    //when press the button PREVIOUS
    protected void goBack() throws IOException {
        PageController controller = new PageController();
        controller.change_page(expBack);
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
}
