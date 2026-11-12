package model;

public abstract class Producto {
    //ATRIBUTOS
    private int tiempoPreparacion, codigo;
    private String  nombre, descripcion;
    private double precioBase, precioVenta;

    //RELACIONES

    /**
     * Método constructor de Producto
     * @param tiempoPreparacion del Producto
     * @param codigo del Producto
     * @param nombre del Producto
     * @param descripcion del Producto
     * @param precioBase del Producto
     * @param precioVenta del preducto
     */
    public Producto(int tiempoPreparacion, int codigo, String nombre, String descripcion, double precioBase,double precioVenta) {
        this.tiempoPreparacion = tiempoPreparacion;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.precioVenta=precioVenta;
    }

    //======================================= MÉTODOS =======================================

    /**
     * Metodo para buscarPorducto
     * @param codigo del Producto
     * @return
     */

    public static Producto buscarProducto ( int codigo){
        Producto existe = null;
        for (int i=0; i<Restaurante.listProductosRestaurante.size(); i++){
            Producto producto= Restaurante.listProductosRestaurante.get(i);
            if(producto.getCodigo()==codigo){
                existe=producto;
            }
        }
        return existe;
    }

    /**
     * metodo para calcular precio de venta de los productos
     * @param precioBase del producto
     * @return
     */
    public abstract double calcularPrecioVenta(double precioBase, boolean preparacionEspecial, boolean refrigeracion);

    /**
     * Metdodo para verificar el control de calidad de los productos
     * @return
     */
    public abstract boolean verificarControlCalidad();



    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
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
