package com.example.demo1;

import javafx.scene.control.Button;

/**
 * A concrete implementation of the GoBack class for logging out
 * @author Yuqi Liu (youyang617@outlook.com)
 * @date 2022/5/26
 */
public class LogOut extends GoBack{
    public LogOut(Button button) {
        super("Log out", "You are about to log out", "Do you really want to log out",button);
    }
}
