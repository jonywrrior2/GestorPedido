package domain;

import clases.Item;

import java.util.ArrayList;

/**
 * Definicion o plantilla de los metodos del item.
 */
public interface ItemDAO {

    /**
     * Trae todos los items relacionados con un pedido específico.
     * @param codigoPedido El código del pedido para el cual se desean cargar los elementos.
     */
    public ArrayList<Item> loadAll(String codigoPedido);
}
