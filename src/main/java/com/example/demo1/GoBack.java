package com.example.demo1;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;

/**
 * Template of 'button control page return and prompt'
 * @author Yuqi Liu (youyang617@outlook.com)
 * @date 2022/5/26
 */
public abstract class GoBack {
    public GoBack(String title, String header, String content, Button button) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        if (alert.showAndWait().get() == ButtonType.OK){
            PageController controller = new PageController();
            try {
                controller.change_page(button);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
