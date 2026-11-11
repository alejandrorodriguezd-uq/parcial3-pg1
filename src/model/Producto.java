package model;

public abstract class Producto {
    //ATRIBUTOS
    private int tiempoPreparacion;
    private String codigo, nombre, descripcion;
    private double precioBase;

    /**
     * Método constructor de Producto
     * @param tiempoPreparacion
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param precioBase
     */
    public Producto(int tiempoPreparacion, String codigo, String nombre, String descripcion, double precioBase) {
        this.tiempoPreparacion = tiempoPreparacion;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
    }

    //======================================= MÉTODOS =======================================


    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "tiempoPreparacion=" + tiempoPreparacion +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioBase=" + precioBase +
                '}';
    }
}
