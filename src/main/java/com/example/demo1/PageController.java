package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Flow;


public class PageController {
    public static String user_id;
    @FXML
    private Button button_next;
    @FXML
    private Button button_next1;
    @FXML
    private Button button_next2;
    @FXML
    private Button button_next3;
    @FXML
    private Button button_upload;
    @FXML
    private ImageView view;
    @FXML
    private RadioButton mealA;
    @FXML
    private RadioButton mealB;
    @FXML
    private RadioButton mealC;
    @FXML
    private RadioButton mealD;
    @FXML
    private CheckBox steak;
    @FXML
    private CheckBox pizza;


    @FXML
    protected void goto_next() throws IOException {
        change_page(button_next); //go to the page food
        Alert err = new Alert(Alert.AlertType.INFORMATION);
        err.setTitle("Information Dialog");
        err.setHeaderText(null);
        err.setContentText("In this page, you can select some nomarl food.If you want to update the meal set you can click next button.");
        err.show();
    }

    @FXML
    protected void goto_next_2() throws IOException{
        change_page(button_next3);
    }

    @FXML
    protected void goto_next_1() throws IOException {
        Customer c = new Customer("100001");
        if(mealA.isSelected()){
            c.ModifyMeal("A",c.search());
        }else if(mealB.isSelected()){
            c.ModifyMeal("B",c.search());
        }else if(mealC.isSelected()){
            c.ModifyMeal("C",c.search());
        }else {
            c.ModifyMeal("D",c.search());
        }
        change_page(button_next1); //go to the page upload_ID
    }

    @FXML
    protected void goto_next_3() throws IOException{ //还没做两个都选，没做退回，没做鲁邦
        Customer c = new Customer("100001");
        if(steak.isSelected()){
            c.ModifyMeal("E",c.search());
        }else if(pizza.isSelected()) {
            c.ModifyMeal("F", c.search());
        }else{

        }
        change_page(button_next2);
    }
    @FXML
    protected void upload_ID() throws IOException{
        // to be continued.....
    }

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

        }else if(b.getId().equals("button_next3")){
            path = "expensive_food.fxml";
            title = "food";

        }
        else if(b.getId().equals("login")){
            path = "seat-view.fxml";
            title = "Seat";
        }
        else if(b.getId().equals("confirmButton")){
            path = "hello-view.fxml";
            title = "Information";
        }
        else if(b.getId().equals("button_upload")){
            path = "load_ID.fxml";
            title = "ID";
        }
        else {
            path = "baggage.fxml";
            title = "baggage";
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
    }
    @FXML
    public void MakeChoice(){
        ToggleGroup group = new ToggleGroup();
        mealA.setToggleGroup(group);
        mealB.setToggleGroup(group);
        mealC.setToggleGroup(group);
        mealD.setToggleGroup(group);

    }


}

