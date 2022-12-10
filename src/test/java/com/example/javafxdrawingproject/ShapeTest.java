package com.example.javafxdrawingproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ShapeTest {
    @Test
    public void test_createShape_shouldReturnCorrectType() {

        Shape shouldBeRectangle = Shape.createShape(ShapeType.RECTANGLE, 0, 0, 0, null);
        assertTrue(shouldBeRectangle instanceof Rectangle);

        Shape shouldBeCircle = Shape.createShape(ShapeType.CIRCLE, 0, 0, 0, null);
        assertTrue(shouldBeCircle instanceof Circle);

    }

}