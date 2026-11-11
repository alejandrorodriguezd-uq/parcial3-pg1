package model;

import java.time.LocalDate;

public class Pedido {
    //ATRIBUTOS
    private int codigo;
    private LocalDate fecha;
    Cliente cliente = ;

    //RELACION
    private ModalidadEntrega modalidadEntrega;
    private EstadoPedido estadoPedido;

    /**
     * Método constructor de Pedido
     * @param codigo
     * @param fecha
     * @param modalidadEntrega
     * @param estadoPedido
     */
    public Pedido(int codigo, LocalDate fecha, ModalidadEntrega modalidadEntrega, EstadoPedido estadoPedido) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.modalidadEntrega = modalidadEntrega;
        this.estadoPedido = estadoPedido;
    }
}
