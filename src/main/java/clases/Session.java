package clases;

import java.util.ArrayList;

/**
 * La clase Sesion almacena información sobre la sesión actual del usuario, incluyendo el pedido actual, la posición
 * del pedido seleccionado en la tabla, el usuario, el listado de pedidos, los productos y los items.
 */
public class Session {

    /**
     * Posición del pedido seleccionado en la tabla.
     */
    private static Integer pos = null;

    /**
     * Usuario actual en la sesión.
     */
    private static Usuario usuario;

    /**
     * Pedido en la sesión.
     */
    private static Pedido pedido;

    /**
     * Lista de pedidos en la sesión.
     */
    private static ArrayList<Pedido> pedidos = new ArrayList<>();

    /**
     * Lista de productos en la sesión.
     */
    private static ArrayList<Producto> productos = new ArrayList<>();

    /**
     * Lista de items en la sesión.
     */
    private static ArrayList<Item> items = new ArrayList<>();

    /**
     * Obtiene la posición del pedido seleccionado en la tabla y la devuelve
     */
    public static Integer getPos() {
        return pos;
    }

    public static void setPos(Integer pos) {
        Session.pos = pos;
    }


    public static Pedido getPedido() {
        return pedido;
    }

    public static void setPedido(Pedido pedido) {
        Session.pedido = pedido;
    }


    public static Usuario getUsuario() {
        return usuario;
    }


    public static void setUsuario(Usuario usuario) {
        Session.usuario = usuario;
    }


    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }


    public static void setPedidos(ArrayList<Pedido> pedidos) {
        Session.pedidos = pedidos;
    }


    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Producto> productos) {
        Session.productos = productos;
    }


    public static ArrayList<Item> getItems() {
        return items;
    }


    public static void setItems(ArrayList<Item> items) {
        Session.items = items;
    }
}