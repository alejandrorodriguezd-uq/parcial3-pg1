
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaTest {

    private Bebida bebida;

    @BeforeEach
    void configurarBebida() {
        bebida = new Bebida(
                5,
                1,
                "Jugo de prueba",
                "Jugo natural",
                10000,
                11000,
                500,
                5.0,
                true,
                false
        );
    }

    @Test
    @DisplayName("Calcula el precio de venta sin preparación especial")
    void calcularPrecioVentaNormal() {
        double resultado = bebida.calcularPrecioVenta(
                10000, false, false
        );

        assertEquals(11000.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Calcula el precio de venta con preparación especial")
    void calcularPrecioVentaEspecial() {
        double resultado = bebida.calcularPrecioVenta(
                10000, true, false
        );

        assertEquals(14000.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Verifica la calidad de una bebida fría")
    void verificarCalidadBebidaFria() {
        bebida.setEsFria(true);

        bebida.setVolumenMililitros(150);
        bebida.setTemperaturaServicio(0);
        assertTrue(bebida.verificarControlCalidad());

        bebida.setVolumenMililitros(1500);
        bebida.setTemperaturaServicio(10);
        assertTrue(bebida.verificarControlCalidad());
    }

    @Test
    @DisplayName("Verifica la calidad de una bebida caliente")
    void verificarCalidadBebidaCaliente() {
        bebida.setEsFria(false);

        bebida.setTemperaturaServicio(55);
        assertTrue(bebida.verificarControlCalidad());

        bebida.setTemperaturaServicio(85);
        assertTrue(bebida.verificarControlCalidad());

        bebida.setTemperaturaServicio(54);
        assertFalse(bebida.verificarControlCalidad());

        bebida.setTemperaturaServicio(86);
        assertFalse(bebida.verificarControlCalidad());
    }

    @Test
    @DisplayName("Rechaza bebidas con volumen fuera del rango permitido")
    void verificarVolumenFueraDeRango() {
        bebida.setVolumenMililitros(149);
        assertFalse(bebida.verificarControlCalidad());

        bebida.setVolumenMililitros(1501);
        assertFalse(bebida.verificarControlCalidad());
    }
}
