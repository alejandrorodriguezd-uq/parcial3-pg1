package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    //ATRIBUTOS
    private String nombreComercial, direccion;
    private int nit;

    //RELACIONES
    public static List<Producto> listProductosRestaurante;
    public static List<Pedido> listPedidosRestaurante;
    public static  List<Cliente> listClientesRestaurante;

    /**
     * Método constructor de Restaurante
     * @param nombreComercial del restaurante
     * @param nit del restaurante
     * @param direccion del restaurante
     */
    public Restaurante(String nombreComercial, int nit, String direccion) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.listProductosRestaurante = new ArrayList<>();
        this.listClientesRestaurante = new ArrayList<>();
        this.listPedidosRestaurante = new ArrayList<>();
    }


    //======================================= MÉTODOS =======================================

    public List<Producto> getListProductosRestaurante() {
        return listProductosRestaurante;
    }

    public void setListProductosRestaurante(List<Producto> listProductosRestaurante) {
        this.listProductosRestaurante = listProductosRestaurante;
    }

    public List<Pedido> getListPedidosRestaurante() {
        return listPedidosRestaurante;
    }

    public void setListPedidosRestaurante(List<Pedido> listPedidosRestaurante) {
        this.listPedidosRestaurante = listPedidosRestaurante;
    }

    public List<Cliente> getListClientesRestaurante() {
        return listClientesRestaurante;
    }

    public void setListClientesRestaurante(List<Cliente> listClientesRestaurante) {
        this.listClientesRestaurante = listClientesRestaurante;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
