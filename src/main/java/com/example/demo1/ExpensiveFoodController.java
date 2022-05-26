package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * This class is used to select the expensive food and choose to go to next page.
 * @author Xinlei Ge
 */
public class ExpensiveFoodController implements Initializable {
    /**The user id od the passenger*/
    public static String user_id;

    /**button used to go to pay*/
    @FXML
    private Button toPayment;

    /**button used to select food*/
    @FXML
    private RadioButton steak;
    @FXML
    private RadioButton pizza;

    /**labels used to warn the passenger*/
    @FXML
    Label foodWarn1;

    /**button used to go back*/
    @FXML
    private Button gobackFood;

    /**
     * used to show user has selected the food
     */
    private String myChoice = "";

    PageController pageController = new PageController();
    Customer c = new Customer(user_id);

    /**
     * Initialize the page, run when the page loads
     * @param url the page parameter, generated automatically
     * @param resourceBundle the page parameter, generated automatically
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();
        steak.setToggleGroup(group);
        pizza.setToggleGroup(group);
        steak.setOnAction(this::getChoice);
        pizza.setOnAction(this::getChoice);
    }

    /**
     * getter of parameter 'myChoice''
     * @return value of 'myChoice'
     */
    public String getMyChoice() {
        return myChoice;
    }

    /**
     * setter of parameter 'myChoice''
     */
    public void setMyChoice(String myChoice) {
        this.myChoice = myChoice;
    }

    /**
     * To indicate the user has selected
     * @param event mouse click and other actions
     */
    public void getChoice(ActionEvent event) {
        setMyChoice("select");
    }

    /**
     * when the 'next' button is pressed, judge if user has chosen food
     * If selected, jump to the next page; otherwise, prompt the user should select and not jump
     * @throws IOException Exception loading page file
     */
    @FXML
    protected void gotoPayment() throws IOException {
        //set the value to the backend
        c.search();
       if(pizza.isSelected() ) {
            c.ModifyMeal("F", c.search());
            foodWarn1.setText(" ");
        }else if(!pizza.isSelected() ) {
            c.ModifyMeal("E", c.search());
            foodWarn1.setText(" ");
        }
        else{
            // c.ModifyMeal(" ",c.search());
        }

        //judge if the passenger has selected food
        if (Objects.equals(getMyChoice(), "") && c.typeOfMeal.equals(" ")){
            foodWarn1.setText("You didn't choose any food!");
        }else{
            pageController.change_page(toPayment);}
    }

    /**
     * When pressed the 'back' button, go back to the previous page
     * @throws IOException Exception loading page file
     */
    @FXML
    protected  void gobackFood() throws IOException{
        //To make sure the passenger want to go back
        CommonGoBack goGoGo = new CommonGoBack(gobackFood);
    }

}
