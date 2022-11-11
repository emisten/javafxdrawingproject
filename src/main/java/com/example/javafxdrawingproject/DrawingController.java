package com.example.javafxdrawingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DrawingController {
    public void handleButtonPressed(ActionEvent event){
        Button button = (Button) event.getSource();
        System.out.println(button.getText());

    }
}