package exception;

/**
 * Esta excepción se lanza cuando se intenta acceder a un usuario que no existe.
 */
public class UsuarioInexistente extends Exception {

    public UsuarioInexistente(String message) {
        super(message);
    }
}
