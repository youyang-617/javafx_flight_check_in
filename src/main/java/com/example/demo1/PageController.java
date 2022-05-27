package com.example.demo1;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This class is used to change the page.
 * @author Xinlei Ge
 */
public class PageController {
    public static String user_id;
    Customer c = new Customer(user_id);

    /**

     * This method is used to close the old page

     * @param b

     */
    public void change_page(Button b) throws IOException{
        Stage primaryStage=(Stage)b.getScene().getWindow();
        //to open the new wimdow, we need to close the old window
        primaryStage.close();
        NewPage(b);
    }

    /**

     * This method is used to open the window

     * @param b

     */
    public void NewPage(Button b) throws IOException {
        String path;
        String title;

        //we will go to the different new window depend on which button is clicked
        if(b.getId().equals("toFood")  || b.getId().equals("goback") || b.getId().equals("goback_pay") || b.getId().equals("gobackFood")){
            path = "food.fxml";
            title = "food";
        }
        else if(b.getId().equals("login") || "previousButton".equals(b.getId()) ){
            path = "seatType.fxml";
            title = "expensiveSeat";
        }
        else if(b.getId().equals("expSeat") || b.getId().equals("backSeat")){
                path = "seat-view.fxml";
                title = "Seat";
        }
        else if(b.getId().equals("confirmButton") || b.getId().equals("gobackInfo")){
            path = "information.fxml";
            title = "Information";
        }
        else if(b.getId().equals("button_upload")){
            path = "load_ID.fxml";
            title = "ID";
        }
        else if (b.getId().equals("toPayment")){
            path = "payment.fxml";
            title = "payment";
        }
        else if (b.getId().equals("1") || b.getId().equals("next_pay")){
            path = "baggage.fxml";
            title = "baggage";
        }
        else if(b.getId().equals("toBaggage")){
            c.search();
            if("J1".equals(c.seatNum) || "J2".equals(c.seatNum) || "A2".equals(c.seatNum) ||"A1".equals(c.seatNum) ||"C2".equals(c.seatNum) ||"C1".equals(c.seatNum) ||"L2".equals(c.seatNum) ||"L1".equals(c.seatNum) ){
                path = "payment.fxml";
                title = "payment";
            }else{
                path = "baggage.fxml";
                title = "baggage";
            }
        }
        else if("expBack".equals(b.getId()) || b.getId().equals("finish")){
            path = "check_in.fxml";
            title = "check in";
        }
        else if(b.getId().equals("toExpensivefood")){
            path = "expensive_food.fxml";
            title = "expensiveFood";
        }
        else{
            path = "";
            title = "";
        }
        //set the root
        AnchorPane root = FXMLLoader.load(PageApplication.class.getResource(path));
        Scene scene;
        scene = new Scene(root);
        Stage stage = new Stage();
        //set the title
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}

