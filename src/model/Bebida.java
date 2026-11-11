package model;

public class Bebida {
    //ATRIBUTOS
    private int volumenMililitros;
    private double temperaturaServicio;
    private boolean esFria, requierePreparacionEspecial;

    /**
     * Método constructor de Bebida
     * @param volumenMililitros
     * @param temperaturaServicio
     * @param esFria
     * @param requierePreparacionEspecial
     */
    public Bebida(int volumenMililitros, double temperaturaServicio, boolean esFria, boolean requierePreparacionEspecial) {
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