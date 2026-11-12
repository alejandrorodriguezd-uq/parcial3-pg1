package model;

public class Postre extends Producto{
    //ATRIBUTOS
    private double pesoGramos, temperaturaAlmacenamiento;
    private boolean requiereRefrigeracion;

    /**
     * Método constructor de Postre
     * @param tiempoPreparacion
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param precioBase
     * @param pesoGramos
     * @param temperaturaAlmacenamiento
     * @param requiereRefrigeracion
     */
    public Postre(int tiempoPreparacion, String codigo, String nombre, String descripcion, double precioBase, double pesoGramos, double temperaturaAlmacenamiento, boolean requiereRefrigeracion) {
        super(tiempoPreparacion, codigo, nombre, descripcion, precioBase);
        this.pesoGramos = pesoGramos;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    //======================================= MÉTODOS =======================================


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
