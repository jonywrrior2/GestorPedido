package domain;

import clases.Item;
import clases.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementación de la interfaz ItemDAO
 */
public class ItemDAOImp implements ItemDAO {

    private static Connection connection;

    /**
     *  Consulta SQL para cargar todos los items de un pedido.
     */
    private final static String queryLoadAll = "select * from Item where codigoPedido = ?";


    public ItemDAOImp(Connection conn) {
        connection = conn;
    }

    @Override
    public ArrayList<Item> loadAll(String codigo) {
        //Se crea un ArryList de Item donde se cargarán cada uno de los items.
        ArrayList<Item> salida = new ArrayList<>();
        try {
            //Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            preparedStatement.setString(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setCodigo_pedido(resultSet.getString("codigoPedido"));
                item.setCantidad(resultSet.getInt("cantidad"));
                Integer productId = resultSet.getInt("idProducto");

                ProductoDAOImp productoDAOImp = new ProductoDAOImp(DBConnection.getConnection());
                Producto producto = productoDAOImp.loadProduct(productId);
                item.setProducto(producto);

                salida.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }
}







