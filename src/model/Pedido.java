package model;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //ATRIBUTOS
    private int codigo;
    private LocalDate fecha;
    private double precioTotal;

    //RELACION
    private ModalidadEntrega modalidadEntrega;
    private EstadoPedido estadoPedido;
    private List<DetallePedido> listDetallesPedido;
    Domicilio empresaDomicilio;
    Cliente cliente;

    /**
     * metoddo constructor de la clase pedido
     * @param codigo del Pedido
     * @param fecha del Pedido
     * @param modalidadEntrega del Pedido
     * @param estadoPedido del Pedido
     * @param listDetallesPedido del Pedido
     * @param empresaDomicilio del Pedido
     * @param cliente del Pedido
     */
    public Pedido(int codigo, LocalDate fecha, ModalidadEntrega modalidadEntrega, EstadoPedido estadoPedido, List<DetallePedido> listDetallesPedido, Domicilio empresaDomicilio, Cliente cliente, double precioTotal) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.modalidadEntrega = modalidadEntrega;
        this.estadoPedido = estadoPedido;
        this.listDetallesPedido = listDetallesPedido;
        this.empresaDomicilio = empresaDomicilio;
        this.cliente = cliente;
        this.precioTotal=precioTotal;
    }

    /**
     * metodo para registrar pedido
     * @param codigo del pedido
     * @param fecha del pedido
     * @param modalidadEntrega del pedido
     * @param estadoPedido del pedido
     * @param empresaDomicilio del pedido
     * @param cliente del pedido
     * @return
     */

    public String registrarPedido(int codigo, LocalDate fecha, ModalidadEntrega modalidadEntrega, EstadoPedido estadoPedido, Domicilio empresaDomicilio, Cliente cliente){
        String mensaje ="";
        Pedido pedido= busccarPedido(codigo);
        if(pedido==null){
            List<DetallePedido> listDetalle= DetallePedido.agregarProductos();
            Pedido nuevoPedido= new Pedido(codigo,fecha,modalidadEntrega,estadoPedido,listDetalle, empresaDomicilio,cliente,0);
            Restaurante.listPedidosRestaurante.add(nuevoPedido);
            cliente.getListPedidosCliente().add(nuevoPedido);
            JOptionPane.showMessageDialog(null, " Pedido agregado exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "el codigo de este pedido ya existe. Intente de nuevo");
        }
        return mensaje;
    }

    /**
     * Metodo para calcular precio total del pedido;
     * @param codigo del pedido
     * @return
     */
    public String calcularPrecioPedido(int codigo){
        double precioTotal=0;
        Pedido pedido= busccarPedido(codigo);
        List<DetallePedido> listDetalle= pedido.getListDetallesPedido();
        for(DetallePedido detalle: listDetalle){
            precioTotal+= detalle.getPrecioUnitario()*detalle.getCantidad();
        }

        JOptionPane.showMessageDialog(null, "costo total de productos es de: "+precioTotal);

        if(pedido.getEmpresaDomicilio()!=null){
            double valorDomicilio=pedido.getEmpresaDomicilio().CalcularDimicilio();
            precioTotal+=valorDomicilio ;
        }

        pedido.setPrecioTotal(precioTotal);

        return pedido.toString();
    }

    /**
     * metodo para buscar pedido
     * @param codigo del pedido
     * @return
     */

    public Pedido busccarPedido(int codigo){
        Pedido existe= null;
        for( int i= 0; i<Restaurante.listPedidosRestaurante.size(); i++){
            Pedido pedido= Restaurante.listPedidosRestaurante.get(i);
            if(pedido.getCodigo()==codigo){
                existe=pedido;
            }
        }
        return existe;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ModalidadEntrega getModalidadEntrega() {
        return modalidadEntrega;
    }

    public void setModalidadEntrega(ModalidadEntrega modalidadEntrega) {
        this.modalidadEntrega = modalidadEntrega;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public List<DetallePedido> getListDetallesPedido() {
        return listDetallesPedido;
    }

    public void setListDetallesPedido(List<DetallePedido> listDetallesPedido) {
        this.listDetallesPedido = listDetallesPedido;
    }

    public Domicilio getEmpresaDomicilio() {
        return empresaDomicilio;
    }

    public void setEmpresaDomicilio(Domicilio empresaDomicilio) {
        this.empresaDomicilio = empresaDomicilio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", fecha=" + fecha +
                ", precioTotal=" + precioTotal +
                ", modalidadEntrega=" + modalidadEntrega +
                ", estadoPedido=" + estadoPedido +
                ", empresaDomicilio=" + empresaDomicilio +
                ", cliente=" + cliente.getNombreCompleto() +
                '}';
    }
}
