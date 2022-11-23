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

    }
}
