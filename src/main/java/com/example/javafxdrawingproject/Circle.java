package com.example.javafxdrawingproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape{
    public Circle(double x, double y, double shapeSize, Color color) {
        super(x, y, shapeSize, color );
    }
    public void draw (GraphicsContext gc) {
        gc.setFill(getColor());
        gc.fillOval(getX(), getY(), getShapeSize(), getShapeSize());
        if (isSelected()) {
            gc.setStroke(Color.GREEN);
            gc.setLineWidth(2);
            gc.strokeOval(getX(), getY(), getShapeSize(), getShapeSize());
        }


    }
}
