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
import java.util.Optional;
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
     Label name,flight,destination,date,gate,warn,food_warn,food_warn1;
    @FXML

    private Button goback_info;
    @FXML
    private Button goback_food;
    @FXML
    private Button back_seat;

    @FXML

    protected void goto_next() throws IOException {
        //go to the page food
        System.out.println(name.getText());
        if(name.getText().equals(" "))
        {
            warn.setText("You have to print your ticket now!");
           // System.out.println("aaaaaaaaaaaaaaa");
        }else{
        change_page(button_next);
        //Alert err = new Alert(Alert.AlertType.INFORMATION);
        //err.setTitle("Information Dialog");
        //err.setHeaderText(null);
        //err.setContentText("In this page, you can select some nomarl food.If you want to update the meal set you can click next button.");
        //err.show();
        }
    }

    @FXML
    protected void goto_next_2() throws IOException{
        change_page(button_next3);

    }

    @FXML
    protected void goto_next_1() throws IOException {
        Customer c = new Customer(user_id);
        if(mealA.isSelected()){
            c.ModifyMeal("A",c.search());
            food_warn.setText(" ");
        }else if(mealB.isSelected()){
            c.ModifyMeal("B",c.search());
            food_warn.setText(" ");
        }else if(mealC.isSelected()){
            c.ModifyMeal("C",c.search());
            food_warn.setText(" ");
        }else if(mealD.isSelected()){
            c.ModifyMeal("D",c.search());
            food_warn.setText(" ");
        }else{
            c.ModifyMeal(" ",c.search());
        }
        System.out.println(c.typeOfMeal);
        System.out.println("-----------------------");
        if(c.typeOfMeal.equals(" ")){

            food_warn.setText("You didn't choose any food!");

        }else{
        change_page(button_next1);} //go to the page upload_ID}
    }

    @FXML
    protected void goto_next_3() throws IOException{ //还没做两个都选，没做退回，没做鲁邦
        Customer c = new Customer(user_id);
        c.search();
        if(steak.isSelected() && pizza.isSelected()){
            c.ModifyMeal("EF",c.search());
            food_warn1.setText(" ");
        }else if(pizza.isSelected() && !(steak.isSelected())) {
            c.ModifyMeal("F", c.search());
            food_warn1.setText(" ");
        }else if(!pizza.isSelected() && steak.isSelected()) {
            c.ModifyMeal("E", c.search());
            food_warn1.setText(" ");
        }
        else{
           // c.ModifyMeal(" ",c.search());
        }
        if(c.typeOfMeal.equals(" ")){

            food_warn1.setText("You didn't choose any food!");

        }else{


            change_page(button_next2);}


    }

    @FXML
    protected  void goback_information() throws IOException {
        change_page(goback_info);
    }
    @FXML
    protected  void goback_food() throws IOException{
        change_page(goback_food);
    }
    @FXML
    protected void goback_seat() throws IOException{
        change_page(back_seat);
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
        }
        //actions to go back to the previous page
        else if(b.getId().equals("goback")){
            path = "expensive_food.fxml";
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
            path = "payment.fxml";
            title = "payment";
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
    @FXML
    public void MakeChoice(){
        ToggleGroup group = new ToggleGroup();
        mealA.setToggleGroup(group);
        mealB.setToggleGroup(group);
        mealC.setToggleGroup(group);
        mealD.setToggleGroup(group);

    }

    public void setValue(){


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("CONFIRMATION");
            alert.setContentText("Do you want to print your ticket?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                //name = new Label();
               setValues();
               warn.setText(" ");
            } else {

            }
        //



    }

    public void setValues(){
        Customer c = new Customer(user_id);
        c.search();
        String names = c.firstName + " " + c.lastName;
        name.setText(names);
        flight.setText(c.flightNum);
        destination.setText(c.destination);
        date.setText(c.date);
        gate.setText(c.gate);
        System.out.println(c.lastName);
    }
}

