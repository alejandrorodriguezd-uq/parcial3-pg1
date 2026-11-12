package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    //ATRIBUTOS
    private String documento, nombreCompleto, correoElectronico, direccionResidencia;
    private int telefono;
    
    //RELACIONES
    private List<Pedido> listPedidosCliente;

    /**
     * Método constructor de Cliente
     * @param documento
     * @param telefono
     * @param nombreCompleto
     * @param correoElectronico
     * @param direccionResidencia
     */
    public Cliente(String documento, int telefono, String nombreCompleto, String correoElectronico, String direccionResidencia) {
        this.documento = documento;
        this.telefono = telefono;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.listPedidosCliente = new ArrayList<>();
    }

    //======================================= MÉTODOS =======================================

    public List<Pedido> getListPedidosCliente() {
        return listPedidosCliente;
    }

    public void setListPedidosCliente(List<Pedido> listPedidosCliente) {
        this.listPedidosCliente = listPedidosCliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento='" + documento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", direccionResidencia='" + direccionResidencia + '\'' +
                '}';
    }
}