package com.example.javafxdrawingproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DrawingControllerTest {
    @Test
    public void test_overlaps_shouldIdentifyOverlap() {

        double mouseX = 1;
        double mouseY = 1;


        Shape shape = Shape.createShape(ShapeType.RECTANGLE, 1, 1, 50, null);
        boolean overlaps = DrawingController.overlaps(mouseX, mouseY, shape);
        assertTrue(overlaps);



    }
    @Test
    public void test_overlaps_shouldIdentifyNotOverlap() {

        double mouseX = 1;
        double mouseY = 1;


        Shape shape = Shape.createShape(ShapeType.RECTANGLE, 30, 30, 50, null);
        boolean overlaps = DrawingController.overlaps(mouseX, mouseY, shape);
        assertFalse(overlaps);
    }
}