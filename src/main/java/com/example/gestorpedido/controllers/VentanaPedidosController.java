package com.example.gestorpedido.controllers;


import clases.Pedido;
import clases.Session;
import com.example.gestorpedido.App;
import domain.DBConnection;
import domain.PedidoDAOImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * La clase VentanaUsuarioController controla la ventana de los pedidos.
 */
public class VentanaPedidosController implements Initializable {

    @javafx.fxml.FXML
    private Label lbUsuario;


    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cIdPedido;


    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cCPedido;

    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cFecha;

    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cUsuario;


    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cTotal;


    @javafx.fxml.FXML
    private TableView<Pedido> tvPedidos;


    private ObservableList<Pedido> observablePedidos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Mappeo de las columnas de la tabla.
        cIdPedido.setCellValueFactory((fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });

        cFecha.setCellValueFactory((fila) -> {
            String fecha = fila.getValue().getFecha();
            return new SimpleStringProperty(fecha);
        });

        cCPedido.setCellValueFactory((fila) -> {
            String codigoPedido = fila.getValue().getCodigo_pedido();
            return new SimpleStringProperty(codigoPedido);
        });

        cUsuario.setCellValueFactory((fila) -> {
            String usuarioId = String.valueOf(fila.getValue().getUsuarioId());
            return new SimpleStringProperty(usuarioId);
        });

        cTotal.setCellValueFactory((fila) -> {
            String total = String.valueOf(fila.getValue().getTotal());
            return new SimpleStringProperty(total);
        });

        //Texto de bienvenida de la ventada en la que se muestran los pedidos de cada usuario.
        lbUsuario.setText("Bienvenid@: " + Session.getUsuario().getNombre());

        //Se crea el observable y se llena la tabla con cada pedido.
        observablePedidos = FXCollections.observableArrayList();
        PedidoDAOImp dao = new PedidoDAOImp(DBConnection.getConnection());
        Session.setPedidos(dao.loadAll(Session.getUsuario().getId()));
        observablePedidos.addAll(Session.getPedidos());
        tvPedidos.setItems(observablePedidos);

        //Al seleccionar un pedido en la tabla se llamará al método 'seleccionarPedido()'.
        tvPedidos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            seleccionarPedido(tvPedidos.getSelectionModel().getSelectedItem());
        });
    }

    /**
     * Maneja la selección de un pedido en la tabla y carga la ventana de los items del pedido.
     */
    private void seleccionarPedido(Pedido p) {
        Session.setPedido(p);
        Session.setPos(tvPedidos.getSelectionModel().getSelectedIndex());
        App.loadFXMLDetalles("ventanaItemsPedido.fxml");
    }

    /**
     * Método por el que al hacer click en el apartado 'Log out' del menu bar se vuelve
     * a la pantalla de login.
     */
    @Deprecated
    public void logOut(ActionEvent actionEvent) {
        //Quita de la sesión al usuario actual.
        Session.setUsuario(null);
        // Maneja el evento de cierre de sesión y carga la ventana de inicio de sesión.
        App.loadFXMLLogin("login.fxml");
    }
}