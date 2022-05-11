package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ExpSeatController {
    public static String user_id;
    public static boolean seatState=false;
    @FXML
    private RadioButton c1, c2;
    @FXML
    private Button expSeat;
    @FXML
    private void GoNext() throws IOException {
        System.out.println(user_id);

        PageController controller = new PageController();
        controller.change_page(expSeat);
        setPageInfo(seatState);
    }

    public void setSeat(ActionEvent event) {
        if (c1.isSelected()) {
            seatState = false;
        } else {
            seatState = true;
        }
    }
    public void setPageInfo(boolean seatState){
//        SeatController seat = new SeatController();
//        PageController page = new PageController();
//        BaggageController baggage = new BaggageController();
//        StageManager.CONTROLLER.put("seat", seat);
//        StageManager.CONTROLLER.put("page", page);
//        StageManager.CONTROLLER.put("baggage",baggage);
//        System.out.println(StageManager.CONTROLLER);

//        SeatController seatControl=(SeatController) StageManager.CONTROLLER.get("seat");
//        PageController pageControl=(PageController) StageManager.CONTROLLER.get("page");

        SeatController.seatState = seatState;
        System.out.println(seatState);
    }

}
