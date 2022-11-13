package com.example.javafxdrawingproject;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Shape {
    public Rectangle(double x, double y) {
        super(x, y);
    }
    public void draw (GraphicsContext gc, double shapeSize) {
        gc.fillRect(getX(), getY(), shapeSize, shapeSize);
    }
}
