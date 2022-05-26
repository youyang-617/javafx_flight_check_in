package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ExpensiveFoodController implements Initializable {
    public static String user_id;
    @FXML
    private Button button_next2;
    @FXML
    private RadioButton steak;
    @FXML
    private RadioButton pizza;
    @FXML
    Label food_warn1;
    @FXML
    private Button goback_food;

    private String myChoice = "";

    PageController pageController = new PageController();
    Customer c = new Customer(user_id);

    @FXML
    protected void goto_next_3() throws IOException {
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

        if (Objects.equals(getMyChoice(), "") && c.typeOfMeal.equals(" ")){

            food_warn1.setText("You didn't choose any food!");

        }else{


            pageController.change_page(button_next2);}


    }


    @FXML
    protected  void goback_food() throws IOException{
        pageController.change_page(goback_food);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();
        steak.setToggleGroup(group);
        pizza.setToggleGroup(group);
        steak.setOnAction(this::getChoice);
        pizza.setOnAction(this::getChoice);
    }
}
