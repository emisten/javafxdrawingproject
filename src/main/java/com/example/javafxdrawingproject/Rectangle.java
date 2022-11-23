package com.example.javafxdrawingproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    public Rectangle(double x, double y, double shapeSize, Color color) {
        super(x, y, shapeSize, color);
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.fillRect(getX(), getY(), getShapeSize(), getShapeSize());
        if (isSelected()) {
            gc.setStroke(Color.GREEN);
            gc.strokeRect(getX(), getY(), getShapeSize(), getShapeSize());
        }
    }
}
