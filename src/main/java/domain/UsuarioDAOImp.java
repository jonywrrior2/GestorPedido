package domain;

import clases.Usuario;
import exception.ContrasenhaIncorrecta;
import exception.UsuarioInexistente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementación de la interfaz UsuarioDAO
 */
public class UsuarioDAOImp implements UsuarioDAO {

    private static Connection connection;
    /**
     *  Consulta SQL para cargar el usuario relacionados con un email concordante con el de la DB.
     */
    private static String loadUser = "select * from Usuario where email = ?";

    public UsuarioDAOImp(Connection conn) {
        connection = conn;
    }

    /**
     * Carga un usuario desde la base de datos utilizando su dirección de correo electrónico y contraseña.
     *
     * @param email       La dirección de correo electrónico del usuario.
     * @param contrasenha La contraseña del usuario.
     */
    @Override
    public Usuario loadUser(String email, String contrasenha) throws UsuarioInexistente, ContrasenhaIncorrecta {
        Usuario usuario;
        try {
            //Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(loadUser);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario(email, contrasenha);
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setContrasenha(resultSet.getString("pass"));
                usuario.setEmail(resultSet.getString("email"));


                //Se comprueba si la contraseña proporcionada coincide con la almacenada en la base de datos.
                if (!contrasenha.equals(usuario.getContrasenha())) {
                    throw new ContrasenhaIncorrecta("Contraseña incorrecta");
                }
            } else {
                throw new UsuarioInexistente("El usuario no existe");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
