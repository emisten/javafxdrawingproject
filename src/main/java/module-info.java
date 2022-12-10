module com.example.javafxdrawingproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens com.example.javafxdrawingproject to javafx.fxml;
    exports com.example.javafxdrawingproject;
}