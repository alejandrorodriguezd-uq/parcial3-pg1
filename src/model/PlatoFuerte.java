package model;

public class PlatoFuerte extends Producto{
    //ATRIBUTOS
    private double pesoGramos;
    private boolean coccionAprobada;

    //RELACIONES
    private TipoPreparacion tipoPreparacion;

    /**
     * Método Constructor del Plato Fuerte
     * @param tiempoPreparacion del plato fuerte
     * @param codigo del plato fuerte
     * @param nombre del plato fuerte
     * @param descripcion del plato fuerte
     * @param precioBase del plato fuerte
     * @param precioVenta del plato fuerte
     * @param pesoGramos del plato fuerte
     * @param coccionAprobada del plato fuerte
     * @param tipoPreparacion del plato fuerte
     */
    public PlatoFuerte(int tiempoPreparacion, int codigo, String nombre, String descripcion, double precioBase, double precioVenta, double pesoGramos, boolean coccionAprobada, TipoPreparacion tipoPreparacion) {
        super(tiempoPreparacion, codigo, nombre, descripcion, precioBase, precioVenta);
        this.pesoGramos = pesoGramos;
        this.coccionAprobada = coccionAprobada;
        this.tipoPreparacion = tipoPreparacion;
    }
    //======================================= MÉTODOS =======================================

    /**
     * Metodo para regsitrar Plato fuerte
     * @param tiempoPreparacion del plato fuerte
     * @param codigo del plato fuerte
     * @param nombre del plato fuerte
     * @param descripcion del plato fuerte
     * @param precioBase del plato fuerte
     * @param pesoGramos del plato fuerte
     * @param coccionAprobada del plato fuerte
     * @param tipoPreparacion del plato fuerte
     */

    public String registrarPlatoFuerte(int tiempoPreparacion, int codigo, String nombre, String descripcion, double precioBase, double pesoGramos, boolean coccionAprobada, TipoPreparacion tipoPreparacion){
        String mensaje ="";
        Producto producto= buscarProducto(codigo);
        if(producto==null){
            double precioVenta= calcularPrecioVenta(precioBase, false, false );
            Producto nuevoProducto= new PlatoFuerte(tiempoPreparacion,codigo,nombre,descripcion,precioBase,precioVenta,pesoGramos,coccionAprobada, tipoPreparacion);
            Restaurante.listProductosRestaurante.add(nuevoProducto);
            mensaje="Producto resgistrado exitosamnete";
        }else{
            mensaje="No se pudo hacer registro del producto. Ya existe";
        }
        return mensaje;
    }


    /**
     * para calcular el precio de venta del plato fuerte
     * @param precioBase del producto
     * @param preparacionEspecial no aplica
     * @param refrigeracion no aplica
     * @return
     */
    @Override
    public double calcularPrecioVenta(double precioBase, boolean preparacionEspecial, boolean refrigeracion) {

        double precioVenta=precioBase+(precioBase*0.20);

        return precioVenta;
    }

    /**
     * Metdodo para verificar el control de calidad de los platos fuertes
     * @return
     */
    @Override
    public boolean verificarControlCalidad(){

        boolean aprobado= false;

        if((pesoGramos >= 200 && pesoGramos <= 900)&&(getTiempoPreparacion() >= 10 && getTiempoPreparacion() <= 60)&&coccionAprobada){
            aprobado= true;
        }

        return aprobado;
    }


    public double getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(double pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public boolean isCoccionAprobada() {
        return coccionAprobada;
    }

    public void setCoccionAprobada(boolean coccionAprobada) {
        this.coccionAprobada = coccionAprobada;
    }

    public TipoPreparacion getTipoPreparacion() {
        return tipoPreparacion;
    }

    public void setTipoPreparacion(TipoPreparacion tipoPreparacion) {
        this.tipoPreparacion = tipoPreparacion;
    }



    @Override
    public String toString() {
        return "PlatoFuerte{" +
                "pesoGramos=" + pesoGramos +
                ", coccionAprobada=" + coccionAprobada +
                ", tipoPreparacion=" + tipoPreparacion +
                '}';
    }
}
