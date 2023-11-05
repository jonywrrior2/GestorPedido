package domain;

import clases.Pedido;

import java.util.ArrayList;

/**
 * Definicion o plantilla de los metodos del Pedido.
 */
public interface PedidoDAO {

    /**
     * Recupera todos los pedidos asociados a un usuario específico.
     */
    public ArrayList<Pedido> loadAll(Integer id);
}
