package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FoodController implements Initializable {

    public static String user_id;

    private String myChoice = "";
    @FXML
    private Button button_next1;
    @FXML
    Label food_warn;
    @FXML
    private Button goback_info;
    @FXML
    private Button button_next3;
    @FXML
    private RadioButton mealA;
    @FXML
    private RadioButton mealB;
    @FXML
    private RadioButton mealC;
    @FXML
    private RadioButton mealD;

    Customer c = new Customer(user_id);
    PageController pageController = new PageController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();
        mealA.setToggleGroup(group);
        mealB.setToggleGroup(group);
        mealC.setToggleGroup(group);
        mealD.setToggleGroup(group);
        mealA.setOnAction(this::getChoice);
        mealD.setOnAction(this::getChoice);
        mealC.setOnAction(this::getChoice);
        mealB.setOnAction(this::getChoice);
        c.ModifyMeal(" ",c.search());
    }

    @FXML
    protected void goto_next_1() throws IOException {
        //PageController pageController = new PageController();
        //Customer c = new Customer(user_id);
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
        System.out.println(getMyChoice());
        System.out.println("-----------------------");
        if(Objects.equals(getMyChoice(), "")){
            food_warn.setText("You didn't choose any food!");
        }else{
            pageController.change_page(button_next1);}
    }
    @FXML
    protected void goto_next_2() throws IOException{
        //PageController pageController = new PageController();

        pageController.change_page(button_next3);

    }
    @FXML
    protected  void goback_information() throws IOException {
        //PageController pageController = new PageController();
        pageController.change_page(goback_info);
    }

    public String getMyChoice() {
        return myChoice;
    }
    public void setMyChoice(String myChoice) {
        this.myChoice = myChoice;
    }
    public void getChoice(ActionEvent event) {
        //String choice = choose.getValue();
        setMyChoice("select");

    }

}
