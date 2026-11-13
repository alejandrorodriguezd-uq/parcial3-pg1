
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostreTest {

    private Postre postre;

    @BeforeEach
    void configurarPostre() {
        postre = new Postre(
                15,
                20,
                "Postre de prueba",
                "Descripción del postre",
                10000,
                12000,
                200,
                4,
                true
        );
    }

    @Test
    @DisplayName("Calcula el precio de venta sin refrigeración")
    void calcularPrecioVentaSinRefrigeracion() {
        double resultado = postre.calcularPrecioVenta(
                10000, false, false
        );

        assertEquals(11500.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Calcula el precio de venta con refrigeración")
    void calcularPrecioVentaConRefrigeracion() {
        double resultado = postre.calcularPrecioVenta(
                10000, false, true
        );

        assertEquals(12000.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Aprueba un postre que requiere refrigeración")
    void verificarCalidadPostreRefrigerado() {
        postre.setRequiereRefrigeracion(true);

        postre.setPesoGramos(80);
        postre.setTemperaturaAlmacenamiento(0);
        assertTrue(postre.verificarControlCalidad());

        postre.setPesoGramos(500);
        postre.setTemperaturaAlmacenamiento(6);
        assertTrue(postre.verificarControlCalidad());
    }

    @Test
    @DisplayName("Aprueba un postre que no requiere refrigeración")
    void verificarCalidadPostreSinRefrigeracion() {
        postre.setRequiereRefrigeracion(false);

        postre.setPesoGramos(80);
        postre.setTemperaturaAlmacenamiento(15);
        assertTrue(postre.verificarControlCalidad());

        postre.setPesoGramos(500);
        postre.setTemperaturaAlmacenamiento(30);
        assertTrue(postre.verificarControlCalidad());
    }

    @Test
    @DisplayName("Rechaza postres con peso o temperatura fuera de los límites")
    void verificarCalidadFueraDeRango() {

        postre.setPesoGramos(79);
        assertFalse(postre.verificarControlCalidad());

        postre.setPesoGramos(501);
        assertFalse(postre.verificarControlCalidad());

        postre.setPesoGramos(200);

        postre.setRequiereRefrigeracion(true);
        postre.setTemperaturaAlmacenamiento(-1);
        assertFalse(postre.verificarControlCalidad());

        postre.setTemperaturaAlmacenamiento(7);
        assertFalse(postre.verificarControlCalidad());

        postre.setRequiereRefrigeracion(false);
        postre.setTemperaturaAlmacenamiento(14);
        assertFalse(postre.verificarControlCalidad());

        postre.setTemperaturaAlmacenamiento(31);
        assertFalse(postre.verificarControlCalidad());
    }
}
