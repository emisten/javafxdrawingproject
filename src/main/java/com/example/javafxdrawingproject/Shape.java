package com.example.javafxdrawingproject;

import javafx.scene.canvas.GraphicsContext;

public abstract class Shape {
    private final double x;
    private final double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public static Shape createShape(ShapeType type, double x, double y){
        return switch (type) {
            case CIRCLE -> new Circle(x, y);
            case RECTANGLE -> new Rectangle(x,y);
        };
    }

    public abstract void draw (GraphicsContext gc, double shapeSize);
}
