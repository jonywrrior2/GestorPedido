package clases;

import exception.ContrasenhaIncorrecta;
import exception.UsuarioInexistente;

import java.util.ArrayList;

/**
 * La clase Usuario representa a un usuario registrado en la base de datos. Los usuarios tienen pedidos asociados a ellos.
 */
public class Usuario {

    private Integer id;


    private String nombre;

    private String contrasenha;

    private String email;

    /**
     * Lista de pedidos asociados al usuario.
     */
    private ArrayList<Pedido> pedido;


    public Usuario(Integer id, String nombre, String contrasenha, String email) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenha = contrasenha;
        this.email = email;
    }

    /**
     * Constructor de la clase Usuario que recibe el email y la contraseña para la verificacion y autenticacion con la DB.
     *
     * @param email       La dirección de correo electrónico del usuario.
     * @param contrasenha La contraseña del usuario.
     * @throws UsuarioInexistente    Excepción lanzada cuando el usuario no existe.
     * @throws ContrasenhaIncorrecta Excepción lanzada cuando la contraseña es incorrecta.
     */
    public Usuario(String email, String contrasenha) throws UsuarioInexistente, ContrasenhaIncorrecta {
        this.pedido = new ArrayList<Pedido>();
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    // Devuelve Una cadena que muestra los atributos del usuario.

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contrasenha='" + contrasenha + '\'' +
                ", email='" + email + '\'' +
                ", pedido=" + pedido +
                '}';
    }
}
