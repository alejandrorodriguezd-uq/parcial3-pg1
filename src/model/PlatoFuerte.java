package model;

public class PlatoFuerte {
    //ATRIBUTOS
    private double pesoGramos;
    private boolean coccionAprobada;

    //RELACIONES
    private TipoPreparacion tipoPreparacion;

    /**
     * Método constructor de PlatoFuerte
     * @param pesoGramos
     * @param coccionAprobada
     * @param tipoPreparacion
     */
    public PlatoFuerte(double pesoGramos, boolean coccionAprobada, TipoPreparacion tipoPreparacion) {
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
