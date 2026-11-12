package model;

public class Bebida extends Producto{
    //ATRIBUTOS
    private int volumenMililitros;
    private double temperaturaServicio;
    private boolean esFria, requierePreparacionEspecial;

    /**
     * Método constructor de Bebida
     * @param tiempoPreparacion
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param precioBase
     * @param volumenMililitros
     * @param temperaturaServicio
     * @param esFria
     * @param requierePreparacionEspecial
     */
    public Bebida(int tiempoPreparacion, String codigo, String nombre, String descripcion, double precioBase, int volumenMililitros, double temperaturaServicio, boolean esFria, boolean requierePreparacionEspecial) {
        super(tiempoPreparacion, codigo, nombre, descripcion, precioBase);
        this.volumenMililitros = volumenMililitros;
        this.temperaturaServicio = temperaturaServicio;
        this.esFria = esFria;
        this.requierePreparacionEspecial = requierePreparacionEspecial;
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
                ", requierePreparacionEspecial=" + requierePreparacionEspecial +
                '}';
    }
}