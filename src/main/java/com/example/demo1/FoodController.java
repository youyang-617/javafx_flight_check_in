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

/**
 * This class is used to select the normal food or go to the next page
 * @author Xinlei Ge
 */
public class FoodController implements Initializable {
    /**The user id od the passenger*/
    public static String user_id;

    /**
     * used to show user has selected the food
     */
    private String myChoice = "";

    /**button used to go to baggage page*/
    @FXML
    private Button toBaggage;

    /**labels used to warn the passenger*/
    @FXML
    Label foodWarn;

    /**button used to go back*/
    @FXML
    private Button gobackInfo;

    /**button used to go to expensive food page*/
    @FXML
    private Button toExpensivefood;

    /**button used to select food*/
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

    /**
     * Initialize the page, run when the page loads
     * @param url the page parameter, generated automatically
     * @param resourceBundle the page parameter, generated automatically
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();
        mealA.setToggleGroup(group);
        mealB.setToggleGroup(group);
        mealC.setToggleGroup(group);
        mealD.setToggleGroup(group);
        //set listening
        mealA.setOnAction(this::getChoice);
        mealD.setOnAction(this::getChoice);
        mealC.setOnAction(this::getChoice);
        mealB.setOnAction(this::getChoice);
        c.ModifyMeal(" ",c.search());
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
    protected void gotoBaggage() throws IOException {
        //set value to backend
        selectFood();
        //judge if the passenger has selected food
        if(Objects.equals(getMyChoice(), "")){
            foodWarn.setText("You didn't choose any food!");
        }else{
            pageController.change_page(toBaggage);}
    }

    /**
     * when the 'pdate' button is pressed jump to the next page
     * @throws IOException Exception loading page file
     */
    @FXML
    protected void gotoExpensivefood() throws IOException{
        //set value to backend
        selectFood();
        //go to the next page
        pageController.change_page(toExpensivefood);
    }

    /**
     * When pressed the 'back' button, go back to the previous page
     * @throws IOException Exception loading page file
     */
    @FXML
    protected void gobackInformation() throws IOException {
        //To make sure the passenger want to go back
        CommonGoBack goGoGo = new CommonGoBack(gobackInfo);
    }

    /**
     * set the chosen food to the backend
     */
    public void selectFood(){
        //set the value to the backend
        if(mealA.isSelected()){
            c.ModifyMeal("A",c.search());
            foodWarn.setText(" ");
        }else if(mealB.isSelected()){
            c.ModifyMeal("B",c.search());
            foodWarn.setText(" ");
        }else if(mealC.isSelected()){
            c.ModifyMeal("C",c.search());
            foodWarn.setText(" ");
        }else if(mealD.isSelected()){
            c.ModifyMeal("D",c.search());
            foodWarn.setText(" ");
        }else{
            c.ModifyMeal(" ",c.search());
        }
    }

}
