package model;

public class Cliente {
    //ATRIBUTOS
    private String documento, telefono, nombreCompleto, correoElectronico, direccionResidencia;

    /**
     * Método constructor de Cliente
     * @param documento
     * @param telefono
     * @param nombreCompleto
     * @param correoElectronico
     * @param direccionResidencia
     */
    public Cliente(String documento, String telefono, String nombreCompleto, String correoElectronico, String direccionResidencia) {
        this.documento = documento;
        this.telefono = telefono;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
    }

    //======================================= MÉTODOS =======================================


    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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