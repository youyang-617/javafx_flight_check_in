package com.example.demo1;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

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
            title = "Select Food";
        }
        else if(b.getId().equals("login") || "previousButton".equals(b.getId()) ){
            path = "seatType.fxml";
            title = "Select Seat Type";
        }
        else if(b.getId().equals("expSeat") || b.getId().equals("backSeat")){
                path = "seat-view.fxml";
                title = "Select Preferred Seat";
        }
        else if(b.getId().equals("confirmButton") || b.getId().equals("gobackInfo")){
            path = "information.fxml";
            title = "Print Your Information";
        }
        else if(b.getId().equals("button_upload")){
            path = "load_ID.fxml";
            title = "ID";
        }
        else if (b.getId().equals("toPayment")){
            path = "payment.fxml";
            title = "Payment";
        }
        else if (b.getId().equals("1") || b.getId().equals("next_pay")){
            path = "baggage.fxml";
            title = "Baggage";
        }
        else if(b.getId().equals("toBaggage")){
            c.search();
            if("J1".equals(c.seatNum) || "J2".equals(c.seatNum) || "A2".equals(c.seatNum) ||"A1".equals(c.seatNum) ||"C2".equals(c.seatNum) ||"C1".equals(c.seatNum) ||"L2".equals(c.seatNum) ||"L1".equals(c.seatNum) ){
                path = "payment.fxml";
                title = "Payment";
            }else{
                path = "baggage.fxml";
                title = "Baggage";
            }
        }
        else if("expBack".equals(b.getId()) || b.getId().equals("finish")){
            path = "check_in.fxml";
            title = "check in";
        }
        else if(b.getId().equals("toExpensivefood")){
            path = "expensive_food.fxml";
            title = "Expensive Food";
        }
        else{
            path = "";
            title = "";
        }
        //set the root
        AnchorPane root = FXMLLoader.load(Objects.requireNonNull(PageApplication.class.getResource(path)));
        Scene scene;
        scene = new Scene(root);
        Stage stage = new Stage();
        //set the title
        stage.setTitle(title);
        stage.getIcons().add(new Image(
                Objects.requireNonNull(PageApplication.class.getResourceAsStream("/image/plane.png"))));
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });
    }
    public void exit(Stage stage){
        Exit exit = new Exit(stage);
    }
}

