package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Yuqi Liu, Xiangrui Meng
 */
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

    /**
     * when pressing the previous button, go back to the check-in page and show a hint
     */
    @FXML
    protected void goBack() throws IOException {
        LogOut logOut = new LogOut(expBack);
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
