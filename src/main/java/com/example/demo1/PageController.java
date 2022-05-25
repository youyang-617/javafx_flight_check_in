package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.concurrent.Flow;


public class PageController {
    public static String user_id;
    Customer c = new Customer(user_id);

    public void change_page(Button b) throws IOException{
        Stage primaryStage=(Stage)b.getScene().getWindow();
        primaryStage.close();//to open the new wimdow, we need to close the old window
         NewPage(b);
    }

    public void NewPage(Button b) throws IOException { //this method is used to open the new window
        String path;
        String title;

        if(b.getId().equals("button_next")){    //we will go to the different new window depend on which button is clicked
            path = "food.fxml";
            title = "food";

        }
        else if(b.getId().equals("button_next3")){
            path = "expensive_food.fxml";
            title = "food";

        }
        else if(b.getId().equals("login")){
            path = "seatType.fxml";
            title = "expensiveSeat";
        }
        else if(b.getId().equals("expSeat")){
                path = "seat-view.fxml";
                title = "Seat";
        }
        else if(b.getId().equals("confirmButton")){
            path = "information.fxml";
            title = "Information";
        }
        else if(b.getId().equals("button_upload")){
            path = "load_ID.fxml";
            title = "ID";
        }
        else if (b.getId().equals("button_next2")){
            path = "payment.fxml";
            title = "payment";
        }else if (b.getId().equals("1")){
            path = "baggage.fxml";
            title = "baggage";
        }else if (b.getId().equals("next_pay")){
            path = "baggage.fxml";
            title = "baggage";
        }
        //actions to go back to the previous page
        else if(b.getId().equals("goback")){
            path = "food.fxml";
            title = "food";

        }else if(b.getId().equals("goback_pay")){
            path = "food.fxml";
            title = "food";

        }else if(b.getId().equals("goback_info")){
            path = "information.fxml";
            title = "information";

        }else if(b.getId().equals("goback_food")){
            path = "food.fxml";
            title = "food";
        }else if(b.getId().equals("back_seat")){
            path = "seat-view.fxml";
            title = "Seat";
        }else if(b.getId().equals("button_next1")){
            if("J1".equals(c.seatNum) || "J2".equals(c.seatNum)){
                path = "payment.fxml";
                title = "payment";
            }else{
                path = "baggage.fxml";
                title = "baggage";
            }

        }else if("expBack".equals(b.getId())){
            path = "check_in.fxml";
            title = "check in";
        }else if("previousButton".equals(b.getId())){
            path = "seatType.fxml";
            title = "Select seat type";
        }
        else{
            path = "";
            title = "";

        }
        AnchorPane root = FXMLLoader.load(PageApplication.class.getResource(path));
        //BorderPane root1 = FXMLLoader.load(PageApplication.class.getResource(path));

        Scene scene;
        scene = new Scene(root);

//        Map<String, String> map = new HashMap<>();
//        map.put("ID",user_id);
//        scene.setUserData(map);

        Stage stage = new Stage();
        stage.setTitle(title);  //set the title
        stage.setScene(scene);
        stage.show();
       // if(path.equals("information.fxml")){
         //   setValue();
        //}
    }




}

