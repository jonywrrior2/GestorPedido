package domain;

import clases.Producto;

/**
 * Definicion o plantilla de los metodos del Producto.
 */
public interface ProductoDAO {

    /**
     * Recupera un producto de la base de datos en función de su id.
     */
    public Producto loadProduct(Integer id);
}