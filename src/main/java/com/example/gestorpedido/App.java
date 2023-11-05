package com.example.gestorpedido;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Stage myStage;


    @Override
    public void start(Stage stage) throws IOException {
        myStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setTitle("Gestor de pedidos");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * El método loadFXMLUsuario carga y muestra una nueva escena con los pedidps del usuario en la misma ventana.
     */
    public static void loadFXMLUsuario(String ruta) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ruta));
            Scene scene = new Scene(fxmlLoader.load(), 858, 625);
            myStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * El método loadFXMLDetalles carga y muestra una nueva escena con los items del pedido en la ventana.
     */
    public static void loadFXMLDetalles(String ruta) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ruta));
            Scene scene = new Scene(fxmlLoader.load(), 600, 427);
            myStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * El método loadFXMLLogin carga y muestra el Login del usuario
     */
    public static void loadFXMLLogin(String ruta) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ruta));
            Scene scene = new Scene(fxmlLoader.load(), 600, 427);
            myStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}