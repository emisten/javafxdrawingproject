package com.example.javafxdrawingproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    private final double x;
    private final double y;
    private double shapeSize;
    private Color color;
    private boolean selected;


    public Shape(double x, double y, double shapeSize, Color color) {
        this.x = x;
        this.y = y;
        this.shapeSize = shapeSize;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public double getShapeSize() {
        return shapeSize;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSize(double shapeSize) {
        this.shapeSize = shapeSize;
    }
    public void setColor (Color color) {
        this.color = color;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public double getX() {
        return x - shapeSize / 2;
    }

    public double getY() {
        return y - shapeSize / 2;
    }
    public static Shape createShape(ShapeType type, double x, double y, double shapeSize, Color color){
        return switch (type) {
            case CIRCLE -> new Circle(x, y, shapeSize, color);
            case RECTANGLE -> new Rectangle(x,y, shapeSize, color);
        };
    }

    public abstract void draw (GraphicsContext gc);

}
