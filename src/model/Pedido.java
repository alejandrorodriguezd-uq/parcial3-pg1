package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //ATRIBUTOS
    private int codigo;
    private LocalDate fecha;

    //RELACION
    private ModalidadEntrega modalidadEntrega;
    private EstadoPedido estadoPedido;
    private List<Pedido> listDetallesPedido;
    Domicilio empresaDomicilio;
    Cliente cliente;

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
        this.listDetallesPedido = new ArrayList<>();
    }



}
