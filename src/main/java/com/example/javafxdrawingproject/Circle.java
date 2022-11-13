package com.example.javafxdrawingproject;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape{
    public Circle(double x, double y) {
        super(x, y);
    }
    public void draw (GraphicsContext gc, double shapeSize) {
        gc.fillOval(getX(), getY(), shapeSize, shapeSize);
    }
}
