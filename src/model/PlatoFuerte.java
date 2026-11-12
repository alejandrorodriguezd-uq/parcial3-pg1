package model;

public class PlatoFuerte extends Producto{
    //ATRIBUTOS
    private double pesoGramos;
    private boolean coccionAprobada;

    //RELACIONES
    private TipoPreparacion tipoPreparacion;

    /**
     * Método Constructor del Plato Fuerte
     * @param tiempoPreparacion
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param precioBase
     * @param pesoGramos
     * @param coccionAprobada
     * @param tipoPreparacion
     */
    public PlatoFuerte(int tiempoPreparacion, String codigo, String nombre, String descripcion, double precioBase, double pesoGramos, boolean coccionAprobada, TipoPreparacion tipoPreparacion) {
        super(tiempoPreparacion, codigo, nombre, descripcion, precioBase);
        this.pesoGramos = pesoGramos;
        this.coccionAprobada = coccionAprobada;
        this.tipoPreparacion = tipoPreparacion;
    }

    //======================================= MÉTODOS =======================================


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
