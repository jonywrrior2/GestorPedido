package domain;

import clases.Usuario;
import exception.ContrasenhaIncorrecta;
import exception.UsuarioInexistente;

/**
 * Definicion o plantilla de los metodos del Usuario.
 */
public interface UsuarioDAO {

    /**
     * El Usuario puede hacer login con su email y pass.
     * @param email      La dirección de correo electrónico del usuario.
     * @param contrasenha La contraseña del usuario.
     * @return El usuario encontrado en la base de datos.
     */
    public Usuario loadUser(String email, String contrasenha) throws UsuarioInexistente, ContrasenhaIncorrecta;
}
