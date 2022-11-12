package com.example.javafxdrawingproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class DrawingController {

    public Canvas canvas;
    public Button circleButton;


    public void initialize(){
        circleButton.onMouseClickedProperty();
    }


    public void handlePressed(MouseEvent mouseEvent){

        Shape shape = Shape.createShape( ShapeType.CIRCLE, mouseEvent.getX(), mouseEvent.getY());
        //System.out.println("CIRCLE");

    }
}