package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    //ATRIBUTOS
    private String  nombreCompleto, correoElectronico, direccionResidencia;
    private int telefono, documento;
    
    //RELACIONES
    private List<Pedido> listPedidosCliente;

    /**
     * Método constructor de Cliente
     * @param documento del cliente
     * @param telefono del cliente
     * @param nombreCompleto del cliente
     * @param correoElectronico del cliente
     * @param direccionResidencia del cliente
     */
    public Cliente(int  documento, int telefono, String nombreCompleto, String correoElectronico, String direccionResidencia) {
        this.documento = documento;
        this.telefono = telefono;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.listPedidosCliente = new ArrayList<>();
    }

    //======================================= MÉTODOS =======================================

    /**
     * Metodod para registrar clientes
     * @param documento del cliente
     * @param telefono del cliente
     * @param nombreCompleto del cliente
     * @param correoElectronico del cliente
     * @param direccionResidencia del cliente
     * @return
     */

    public String registrarCliente (int documento, int telefono, String nombreCompleto, String correoElectronico, String direccionResidencia){
         String mensaje= "";
         Cliente cliente =busccarCliente(documento);
         if(cliente==null){
             Cliente nuevoCliente= new Cliente(documento,telefono,nombreCompleto,correoElectronico,direccionResidencia);
             Restaurante.listClientesRestaurante.add(cliente);
             mensaje="Cliente registrado";
         }else{
             mensaje="No se pudo registrar. Ya hay un cliente con este documento";
         }
         return mensaje;
    }

    /**
     * Metodo para buscar cliente
     * @param documento del cliente
     * @return
     */

    public Cliente busccarCliente(int documento){

        Cliente existe= null;
        for( int i= 0; i<Restaurante.listClientesRestaurante.size(); i++){

            Cliente cliente= Restaurante.listClientesRestaurante.get(i);
            if(cliente.getDocumento()==documento){
                existe=cliente;
            }
        }
        return existe;
    }

    /**
     * metodo para consultar histrial de pedidos del cleinte
     * @param documento del cliente
     * @return
     */

    public String consultarHistorialPedidos(int documento){
        Cliente cliente= busccarCliente(documento);
        String mensaje="";
        for(Pedido pedido: cliente.listPedidosCliente ){
            mensaje+=pedido.toString()+"\n";
        }
        return mensaje;
    }



    public List<Pedido> getListPedidosCliente() {
        return listPedidosCliente;
    }

    public void setListPedidosCliente(List<Pedido> listPedidosCliente) {
        this.listPedidosCliente = listPedidosCliente;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
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