module com.example.gestorpedido {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gestorpedido to javafx.fxml;
    exports com.example.gestorpedido;
    exports com.example.gestorpedido.controllers;
    opens com.example.gestorpedido.controllers to javafx.fxml;
}