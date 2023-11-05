package clases;

/**
 * La clase Item representa un elemento que constituye un pedido.
 */
public class Item {

    /**
     * Identificador único del ítem.
     */
    private Integer id;

    /**
     * Código del pedido al que pertenece el ítem.
     */
    private String codigo_pedido;

    /**
     * Cantidad del producto en el ítem.
     */
    private Integer cantidad;

    /**
     * Producto asociado al ítem.
     */
    private Producto producto;

    public Item(Integer id, String codigo_pedido, Integer cantidad, Producto producto) {
        this.id = id;
        this.codigo_pedido = codigo_pedido;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    /**
     * Constructor por defecto que crea un objeto Item vacío sin atributos inicializados.
     */
    public Item(){
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getCodigo_pedido() {
        return codigo_pedido;
    }


    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }


    public Integer getCantidad() {
        return cantidad;
    }


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public Producto getProducto() {
        return producto;
    }


    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    // Devuleve una cadena que representa el objeto Item.

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", codigo_pedido='" + codigo_pedido + '\'' +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }
}
