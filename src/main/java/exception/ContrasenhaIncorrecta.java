package exception;

/**
 * Esta excepción se lanza cuando se proporciona una contraseña incorrecta.
 */
public class ContrasenhaIncorrecta extends Exception {

    public ContrasenhaIncorrecta(String message) {
        super(message);
    }
}
