package model;

import java.util.ArrayList;
import java.util.List;

public class DetallePedido {
    //ATRIBUTOS
    private String producto;
    private int cantidad;
    private double precioUnitario;

    //RELACIONES
    private List<Producto> listProductosPedido;

    /**
     * Método constructor de Detalle Pedido
     * @param producto
     * @param cantidad
     * @param precioUnitario
     */
    public DetallePedido(String producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.listProductosPedido = new ArrayList<>();
    }

    //======================================= MÉTODOS =======================================

    public List<Producto> getListProductosPedido() {
        return listProductosPedido;
    }

    public void setListProductosPedido(List<Producto> listProductosPedido) {
        this.listProductosPedido = listProductosPedido;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
