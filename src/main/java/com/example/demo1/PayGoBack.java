package com.example.demo1;
import javafx.scene.control.Button;

/**
 * A concrete implementation of the GoBack class for going to the previous page
 * @author Yuqi Liu (youyang617@outlook.com)
 * @date 2022/5/26
 */
public class PayGoBack extends GoBack{
    public PayGoBack(Button button) {
        super("Go back", "You need to pay again for changed food or seat, operation irreversible!",
                "The original payment will be returned to your card within 3 working days",button);
    }
}
