package com.example.javafxdrawingproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DrawingController {

    @FXML
    private RadioButton selectButton;

    @FXML
    private RadioButton drawButton;

    @FXML
    private ColorPicker myColorPicker;

    private Color color = Color.BLACK;

    private ShapeType shapeType = ShapeType.CIRCLE;

    @FXML
    public TextField size;

    @FXML
    public Canvas canvas;

    private final List<Shape> shapes = new ArrayList<>();

    private final ToggleGroup modeToggleGroup = new ToggleGroup();


    public void initialize() {
        size.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    size.setText(newValue.replaceAll("\\D", ""));
                }
                RadioButton rb = (RadioButton) modeToggleGroup.getSelectedToggle();
                double shapeSize = Double.parseDouble(size.getText());

                if (rb == selectButton) {

                    for (Shape shape : shapes) {
                        if (shape.isSelected()) {
                            shape.setSize(shapeSize);
                            break;
                        }
                    }
                    refreshCanvas();
                }

            }

        });


        drawButton.setToggleGroup(modeToggleGroup);
        selectButton.setToggleGroup(modeToggleGroup);


        modeToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n) {

                RadioButton rb = (RadioButton) modeToggleGroup.getSelectedToggle();

                if (rb == drawButton) {
                    canvas.setOnMouseClicked(mouseEvent -> draw(mouseEvent));
                } else if (rb == selectButton) {
                    canvas.setOnMouseClicked(mouseEvent -> select(mouseEvent));

                }
            }
        });

    }


    public void draw(MouseEvent mouseEvent) {

        double shapeSize = Double.parseDouble(size.getText());
        Shape shape = Shape.createShape(shapeType, mouseEvent.getX(), mouseEvent.getY(), shapeSize, color);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        shape.draw(gc);
        shapes.add(shape);


        System.out.println("Shape: " + shapeType);
        System.out.println("Mouse x position: " + mouseEvent.getX());
        System.out.println("Mouse y position: " + mouseEvent.getY());

    }

    public void select(MouseEvent mouseEvent) {

        boolean foundOverlap = false;

        ListIterator<Shape> li = shapes.listIterator(shapes.size());
        while (li.hasPrevious()) {
            Shape shape = li.previous();
            if (overlaps(mouseEvent.getX(), mouseEvent.getY(), shape)
                    && !foundOverlap) {

                shape.setSelected(true);
                foundOverlap = true;


            } else {
                shape.setSelected(false);

            }

        }
        refreshCanvas();
    }

    public static boolean overlaps(double mouseX, double mouseY, Shape shape) {
        return
                mouseX >= shape.getX()
                        && mouseX <= shape.getX() + shape.getShapeSize()
                        && mouseY >= shape.getY()
                        && mouseY <= shape.getY() + shape.getShapeSize();
    }


    public void undo() {
        shapes.remove(shapes.size() - 1);
        refreshCanvas();
    }

    public void save() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG file (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Save Image");
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try {
                WritableImage wim = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
                canvas.snapshot(null, wim);
                ImageIO.write(SwingFXUtils.fromFXImage(wim,
                        null), "png", file);
                System.out.println("Pretending to write file!!!!");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    private void refreshCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shape shape : shapes) {
            shape.draw(gc);
        }
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
        RadioButton rb = (RadioButton) modeToggleGroup.getSelectedToggle();

        if (rb == selectButton) {

            for (Shape shape : shapes) {
                if (shape.isSelected()) {
                    shape.setColor(color);
                    break;
                }
            }
            refreshCanvas();

        }

    }
}