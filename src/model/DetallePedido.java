package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DetallePedido {
    //ATRIBUTOS
    private int cantidad;
    private double precioUnitario;

    //RELACIONES
    Producto producto;

    /**
     * metodo constructor de producto
     * @param cantidad de productos
     * @param precioUnitario del producto
     * @param producto
     */

    public DetallePedido(int cantidad, double precioUnitario, Producto producto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.producto = producto;
    }

    //======================================= MÉTODOS =======================================

    /**
     * metodo para agregar productos
     * @return
     */

    public static ArrayList<DetallePedido> agregarProductos(){

        ArrayList<DetallePedido> listDetalle=new ArrayList<>();
        int opcion=0;
        do{
            int codigo= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto"));
            Producto producto= Producto.buscarProducto(codigo);

            if (producto!=null){
                int cant= Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad"));
                if(cant>0){
                    double precioUnitario= producto.getPrecioVenta();
                    if(producto.verificarControlCalidad()){
                        DetallePedido detalle= new DetallePedido(cant,precioUnitario,producto);
                        listDetalle.add(detalle);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se puede agregar producto. No cumple con el control de claidad");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se puede agregar producto con cantidad 0");
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se puede agregar producto inexistente");

            }
            opcion= Integer.parseInt(JOptionPane.showInputDialog("Quiere agregar otro producto? 1.si 2.No"));

        }while(opcion==1);

        return listDetalle;

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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
