package model;

public class Bebida extends Producto{
    //ATRIBUTOS
    private int volumenMililitros;
    private double temperaturaServicio;
    private boolean esFria, requierePreparacionEspecial;

    /**
     * Metdodo constructor de la bebida
     * @param tiempoPreparacion de la bebida
     * @param codigo de la bebida
     * @param nombre de la bebida
     * @param descripcion de la bebida
     * @param precioBase de la bebida
     * @param precioVenta de la bebida
     * @param volumenMililitros de la bebida
     * @param temperaturaServicio de la bebida
     * @param esFria de la bebida
     * @param requierePreparacionEspecial de la bebida
     */

    public Bebida(int tiempoPreparacion, int codigo, String nombre, String descripcion, double precioBase, double precioVenta, int volumenMililitros, double temperaturaServicio, boolean esFria, boolean requierePreparacionEspecial) {
        super(tiempoPreparacion, codigo, nombre, descripcion, precioBase, precioVenta);
        this.volumenMililitros = volumenMililitros;
        this.temperaturaServicio = temperaturaServicio;
        this.esFria = esFria;
        this.requierePreparacionEspecial = requierePreparacionEspecial;
    }

    /**
     * Metodo para regsistrar bebida
     * @param tiempoPreparacion de la Bebida
     * @param codigo  de la Bebida
     * @param nombre de la Bebida
     * @param descripcion de la Bebida
     * @param precioBase de la Bebida
     * @param volumenMililitros de la Bebida
     * @param temperaturaServicio  de la Bebida
     * @param esFria  de la Bebida
     * @param requierePreparacionEspecial    de la Bebida
     * @return
     */

    public String registrarBebida(int tiempoPreparacion, int codigo, String nombre, String descripcion, double precioBase, int volumenMililitros, double temperaturaServicio, boolean esFria, boolean requierePreparacionEspecial){

        String mensaje ="";
        Producto producto= buscarProducto(codigo);
        if(producto==null){
            double precioVenta= calcularPrecioVenta(precioBase,requierePreparacionEspecial,esFria);
            Producto nuevoProducto= new Bebida(tiempoPreparacion,codigo,nombre,descripcion,precioBase,precioVenta,volumenMililitros,temperaturaServicio,esFria,requierePreparacionEspecial);
            Restaurante.listProductosRestaurante.add(nuevoProducto);
            mensaje="Producto resgistrado exitosamnete";
        }else{
            mensaje="No se pudo hacer registro del producto. Ya existe";
        }
        return mensaje;
    }

    /**
     * Meytodo para calcular elprecio de la venta de las bebidas
     * @param precioBase del producto
     * @param preparacionEspecial de la bebida
     * @param refrigeracion de la bebida
     * @return
     */
    @Override
    public double calcularPrecioVenta(double precioBase, boolean preparacionEspecial, boolean refrigeracion){

        double precioVenta= precioBase+(precioBase*0.10);
        if(preparacionEspecial){
            precioVenta+=3000;
        }
        return precioVenta;
    }

    /**
     * Metdodo para verificar el control de calidad de las bebidas
     * @return
     */

    @Override
    public boolean verificarControlCalidad() {

        boolean aprobado=true;
        if(volumenMililitros < 150 || volumenMililitros > 1500){
            aprobado= false;
        }

        if(esFria){
            if(temperaturaServicio <0 || temperaturaServicio>10){
                aprobado=false;
            }
        }else{

            if( temperaturaServicio < 55 || temperaturaServicio> 85){
                aprobado= false;
            }
        }
        return aprobado;
    }

    //======================================= MÉTODOS =======================================

    public int getVolumenMililitros() {
        return volumenMililitros;
    }

    public void setVolumenMililitros(int volumenMililitros) {
        this.volumenMililitros = volumenMililitros;
    }

    public double getTemperaturaServicio() {
        return temperaturaServicio;
    }

    public void setTemperaturaServicio(double temperaturaServicio) {
        this.temperaturaServicio = temperaturaServicio;
    }

    public boolean isEsFria() {
        return esFria;
    }

    public void setEsFria(boolean esFria) {
        this.esFria = esFria;
    }

    public boolean isRequierePreparacionEspecial() {
        return requierePreparacionEspecial;
    }

    public void setRequierePreparacionEspecial(boolean requierePreparacionEspecial) {
        this.requierePreparacionEspecial = requierePreparacionEspecial;
    }



    @Override
    public String toString() {
        return "Bebida{" +
                "volumenMililitros=" + volumenMililitros +
                ", temperaturaServicio=" + temperaturaServicio +
                ", esFria=" + esFria +
                '}';
    }
}