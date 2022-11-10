module com.example.javafxdrawingproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxdrawingproject to javafx.fxml;
    exports com.example.javafxdrawingproject;
}