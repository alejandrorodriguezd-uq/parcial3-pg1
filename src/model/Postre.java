package model;

public class Postre extends Producto{
    //ATRIBUTOS
    private double pesoGramos, temperaturaAlmacenamiento;
    private boolean requiereRefrigeracion;

    /**
     * Método constructor de Postre
     * @param tiempoPreparacion del postre
     * @param codigo del postre
     * @param nombre del postre
     * @param descripcion del postre
     * @param precioBase del postre
     * @param precioVenta  del postre
     * @param pesoGramos del postre
     * @param temperaturaAlmacenamiento del postre
     * @param requiereRefrigeracion del postre
     */
    public Postre(int tiempoPreparacion, int codigo, String nombre, String descripcion, double precioBase, double precioVenta, double pesoGramos, double temperaturaAlmacenamiento, boolean requiereRefrigeracion) {
        super(tiempoPreparacion, codigo, nombre, descripcion, precioBase, precioVenta);
        this.pesoGramos = pesoGramos;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.requiereRefrigeracion = requiereRefrigeracion;
    }
    //======================================= MÉTODOS =======================================

    /**
     * Metdodo para registrar Postre
     * @param tiempoPreparacion del postre
     * @param codigo del postre
     * @param nombre del postre
     * @param descripcion del postre
     * @param precioBase del postre
     * @param pesoGramos del postre
     * @param temperaturaAlmacenamiento del postre
     * @param requiereRefrigeracion del postre
     * @return
     */

    public String registrarPostre (int tiempoPreparacion, int codigo, String nombre, String descripcion, double precioBase, double pesoGramos, double temperaturaAlmacenamiento, boolean requiereRefrigeracion){
        String mensaje ="";
        Producto producto= buscarProducto(codigo);
        if(producto==null){

            double precioVenta= calcularPrecioVenta(precioBase,false, requiereRefrigeracion);
            Producto nuevoProducto= new Postre(tiempoPreparacion,codigo,nombre,descripcion,precioBase,precioVenta,pesoGramos,temperaturaAlmacenamiento,requiereRefrigeracion);
            Restaurante.listProductosRestaurante.add(nuevoProducto);
            mensaje="Producto resgistrado exitosamnete";
        }else{
            mensaje="No se pudo hacer registro del producto. Ya existe";
        }
        return mensaje;
    }

    /**
     * Metodo para calcular el precio de venta de un postre
     * @param precioBase del producto
     * @param preparacionEspecial no aplica
     * @param refrigeracion del postre
     * @return
     */

    @Override
    public double calcularPrecioVenta(double precioBase, boolean preparacionEspecial, boolean refrigeracion) {
        double precioVenta=precioBase+(precioBase*0.15);
        if(refrigeracion){
            precioVenta+= precioBase*0.05;
        }

        return precioVenta;
    }

    /**
     * Metdodo para verificar el control de calidad de los postres
     * @return
     */
    @Override
    public boolean verificarControlCalidad() {

        boolean aprobado=true;
        if(pesoGramos < 80 || pesoGramos > 500){

           aprobado= false;
        }
        if(requiereRefrigeracion){
            if (temperaturaAlmacenamiento<0||temperaturaAlmacenamiento>6){
                aprobado= false;
            }
        }else{
            if(temperaturaAlmacenamiento<15||temperaturaAlmacenamiento>30){
                aprobado=false;
            }
        }


        return aprobado;
    }


    public double getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(double pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public double getTemperaturaAlmacenamiento() {
        return temperaturaAlmacenamiento;
    }

    public void setTemperaturaAlmacenamiento(double temperaturaAlmacenamiento) {
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
    }

    public boolean isRequiereRefrigeracion() {
        return requiereRefrigeracion;
    }

    public void setRequiereRefrigeracion(boolean requiereRefrigeracion) {
        this.requiereRefrigeracion = requiereRefrigeracion;
    }



    @Override
    public String toString() {
        return "Postre{" +
                "pesoGramos=" + pesoGramos +
                ", temperaturaAlmacenamiento=" + temperaturaAlmacenamiento +
                ", requiereRefrigeracion=" + requiereRefrigeracion +
                '}';
    }
}
