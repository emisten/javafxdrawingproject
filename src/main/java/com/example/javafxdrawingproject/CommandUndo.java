package com.example.javafxdrawingproject;

import java.util.*;

public class CommandUndo {
    Deque<CommandUndo> undoStack = new ArrayDeque<>();

    public static void main(String[] args) {
        List<String> shapes = new ArrayList<>();



        shapes.add("Hej");
        Undo undo1 = ()-> shapes.remove("Hej");

    }


}
@FunctionalInterface
interface Undo {
    void execute();
}