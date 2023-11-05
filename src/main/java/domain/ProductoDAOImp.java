package domain;

import clases.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementación de la interfaz ProductoDAO
 */
public class ProductoDAOImp implements ProductoDAO {

    private static Connection connection;
    /**
     *  Consulta SQL para cargar el producto relacionado con su id.
     */
    private final static String queryLoad = "select * from Producto where id = ?";

    public ProductoDAOImp(Connection conn) {
        connection = conn;
    }

    /**
     * Carga un producto específico desde la base de datos utilizando su ID.
     */
    @Override
    public Producto loadProduct(Integer id) {
        Producto producto = null;
        try {
            //Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoad);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                producto = new Producto();
                producto.setId(resultSet.getInt("id"));
                producto.setNombre(resultSet.getString("nombreProducto"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCantidad_disponible(resultSet.getInt("cantidadDisponible"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return producto;
    }
}
