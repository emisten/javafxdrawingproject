package com.example.javafxdrawingproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class DrawingController {

    @FXML
    private ColorPicker myColorPicker;

    private Color color = Color.BLACK;
    private ShapeType shapeType = ShapeType.CIRCLE;

    @FXML
    public TextField size;

    @FXML
    public Canvas canvas;

    public void initialize() {
        size.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    size.setText(newValue.replaceAll("\\D", ""));
                }
            }
        });

    }


    public void draw(MouseEvent mouseEvent) {

        double shapeSize = Double.parseDouble(size.getText());
        Shape shape = Shape.createShape(shapeType, mouseEvent.getX()-shapeSize/2, mouseEvent.getY()-shapeSize/2);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(color);



        shape.draw(gc, shapeSize);


        System.out.println("Shape: " + shapeType);
        System.out.println("Mouse x position: " + mouseEvent.getX());
        System.out.println("Mouse y position: " + mouseEvent.getY());

    }

    public void buttonPressed(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if ("Circle".equals(button.getText())) {
            shapeType = ShapeType.CIRCLE;
        } else if ("Rectangle".equals(button.getText())) {
            shapeType = ShapeType.RECTANGLE;
        }
    }

    public void changeColor(ActionEvent actionEvent) {

        color = myColorPicker.getValue();


    }
}