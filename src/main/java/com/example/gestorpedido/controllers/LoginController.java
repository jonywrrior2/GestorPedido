package com.example.gestorpedido.controllers;

import clases.Session;
import clases.Usuario;
import com.example.gestorpedido.App;
import domain.DBConnection;
import domain.UsuarioDAOImp;
import exception.ContrasenhaIncorrecta;
import exception.UsuarioInexistente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * La clase LoginController controla la ventana de inicio de sesión.
 */
public class LoginController implements Initializable {


    @FXML
    public TextField userField;


    @FXML
    private PasswordField passField;

    /**
     * En el metodo login se verifica y comprueba q el usuario y contraeña sean correctos y se encuentren en la DB. Si es asi, se procede a mostrar los pedidos del usuarip
     */
    @FXML
    public void login(ActionEvent actionEvent) {
        String userEmail = userField.getText();
        String userPass = passField.getText();
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp(DBConnection.getConnection());
        try {
            Usuario usuario = usuarioDAOImp.loadUser(userEmail, userPass);
            Session.setUsuario(usuario);

            // Muestra un mensaje de confirmación en caso de un inicio de sesión exitoso.
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Gestor De Pedidos");
            alert.setHeaderText("Inicio de sesion correcto");
            alert.setContentText("Bienvenid@, " + usuario.getNombre());
            alert.showAndWait();
            App.loadFXMLUsuario("ventanaPedidos.fxml");

        } catch (UsuarioInexistente e) {
            // Muestra una alerta en caso de usuario inexistente.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Usuario no existente");
            alert.setContentText("No se ha pido encontrar al usuario.");
            alert.showAndWait();
        } catch (ContrasenhaIncorrecta e) {
            // Muestra una alerta en caso de contraseña incorrecta.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Contraseña incorrecta");
            alert.setContentText("La contraseña introducida es incorrecta.");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}