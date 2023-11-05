package com.example.gestorpedido.controllers;

import clases.Item;
import clases.Session;
import com.example.gestorpedido.App;
import domain.DBConnection;
import domain.ItemDAOImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * La clase VentanaDetallesPedidoController controla la ventana de los pedidos.
 */
public class VentanaItemsPedidoController implements Initializable {


    @javafx.fxml.FXML
    private TableColumn<Item, String> cIdItem;


    @javafx.fxml.FXML
    private TableColumn<Item, String> cCPedido;


    @javafx.fxml.FXML
    private TableColumn<Item, String> cCantidad;


    @javafx.fxml.FXML
    private TableColumn<Item, String> cProducto;

    @javafx.fxml.FXML
    private TableView tvItem;

    private ObservableList<Item> observableListItem;


    /**
     * Inicializa la clase y se mappea las columnas de la tabla.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Mappeo de columnas en la tabla.
        cIdItem.setCellValueFactory((fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });

        cCPedido.setCellValueFactory((fila) -> {
            String cPedido = fila.getValue().getCodigo_pedido();
            return new SimpleStringProperty(cPedido);
        });

        cCantidad.setCellValueFactory((fila) -> {
            String cCantidad = String.valueOf(fila.getValue().getCantidad());
            return new SimpleStringProperty(cCantidad);
        });

        cProducto.setCellValueFactory((fila) -> {
            String cProducto = String.valueOf(fila.getValue().getProducto());
            return new SimpleStringProperty(cProducto);
        });

        //Se crea el observable y se llena la tabla con cada item.
        observableListItem = FXCollections.observableArrayList();
        ItemDAOImp dao = new ItemDAOImp(DBConnection.getConnection());
        Session.setItems(dao.loadAll(Session.getPedido().getCodigo_pedido()));
        observableListItem.addAll(Session.getItems());
        tvItem.setItems(observableListItem);
    }

    /**
     * Método por el que al hacer click en la opción 'Log out' del menu se cierra sesion y vuelve al login
     */

    public void logOut(ActionEvent actionEvent) {
        //Quita de la sesión al usuario actual.
        Session.setUsuario(null);
        // Maneja el evento de cierre de sesión y carga la ventana de login.
        App.loadFXMLLogin("login.fxml");
    }

    /**
     * En el método volverAtrás se vuelve a la ventana anterior (En este caso pasaria de los items a los pedidos del usuario).
     */
    public void volverAtrás(ActionEvent actionEvent) {
        // Maneja el evento de 'Volver' y carga la ventana de usuario.
        App.loadFXMLUsuario("ventanaPedidos.fxml");
    }


}
