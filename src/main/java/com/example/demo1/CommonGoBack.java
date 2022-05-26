package com.example.demo1;
import javafx.scene.control.Button;

/**
 * A concrete implementation of the GoBack class for going to the previous page
 * @author Yuqi Liu (youyang617@outlook.com)
 * @date 2022/5/26
 */
public class CommonGoBack extends GoBack{
    public CommonGoBack(Button button) {
        super("Go back", "You are about to go back to the previous page", "The data you have filled in on this page will not be recorded",button);
    }
}
