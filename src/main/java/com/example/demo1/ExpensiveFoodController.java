package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Objects;

public class ExpensiveFoodController {
    public static String user_id;
    @FXML
    private Button button_next2;
    @FXML
    private CheckBox steak;
    @FXML
    private CheckBox pizza;
    @FXML
    Label food_warn1;
    @FXML
    private Button goback_food;

    PageController pageController = new PageController();

    @FXML
    protected void goto_next_3() throws IOException { //还没做两个都选，没做退回，没做鲁邦
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
        if (c.typeOfMeal.equals(" ")){

            food_warn1.setText("You didn't choose any food!");

        }else{


            pageController.change_page(button_next2);}


    }


    @FXML
    protected  void goback_food() throws IOException{
        pageController.change_page(goback_food);
    }
}
