package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ExpSeatController {
    public static String user_id;
    @FXML
    private Button expSeat;
    @FXML
    private void GoNext() throws IOException {
        System.out.println(user_id);
        PageController controller = new PageController();
        controller.change_page(expSeat);
    }
}
