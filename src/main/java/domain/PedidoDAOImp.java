package domain;

import clases.Pedido;
import clases.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Implementación de la interfaz PedidoDAO
 */
public class PedidoDAOImp implements PedidoDAO {


    private static Connection connection;

    /**
     *  Consulta SQL para cargar todos los pedidos relacionados con un usuario específico.
     */
    private final static String queryLoadAll = "select * from Pedido where usuario = ?";

    public PedidoDAOImp(Connection conn) {
        this.connection = conn;
    }


    @Override
    public ArrayList<Pedido> loadAll(Integer id) {
        //Se crea un ArryList de 'Pedido' donde se cargarán cada uno de los pedidos.
        ArrayList<Pedido> salida = new ArrayList<>();
        try {
            //Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            ItemDAOImp itemDAOImp = new ItemDAOImp(DBConnection.getConnection());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(resultSet.getInt("id"));
                pedido.setCodigo_pedido(resultSet.getString("codigo"));

                pedido.setFecha(new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate("fecha")));

                pedido.setUsuarioId(resultSet.getInt("usuario"));
                pedido.setTotal(resultSet.getInt("total"));

                pedido.setItems(itemDAOImp.loadAll(pedido.getCodigo_pedido()));

                Session.setPedido(pedido);
                salida.add(pedido);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }
}