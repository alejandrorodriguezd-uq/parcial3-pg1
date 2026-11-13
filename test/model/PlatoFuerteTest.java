package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatoFuerteTest {

    private PlatoFuerte platoFuerte;

    @BeforeEach
    void configurarPlato() {
        platoFuerte = new PlatoFuerte(
                10,
                1,
                "Plato de prueba",
                "Descripción del plato",
                10000,
                12000,
                200,
                true,
                TipoPreparacion.ASADO
        );
    }

    @Test
    @DisplayName("Calcula el precio de venta con un aumento del 20%")
    void calcularPrecioVenta() {
        double resultado = platoFuerte.calcularPrecioVenta(
                10000, false, false
        );

        assertEquals(12000.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Aprueba un plato que cumple los límites de calidad")
    void verificarCalidadPlatoValido() {
        assertTrue(platoFuerte.verificarControlCalidad());

        platoFuerte.setPesoGramos(900);
        platoFuerte.setTiempoPreparacion(60);

        assertTrue(platoFuerte.verificarControlCalidad());
    }

    @Test
    @DisplayName("Rechaza un plato cuyo peso está fuera del rango permitido")
    void verificarPesoFueraDeRango() {
        platoFuerte.setPesoGramos(199);
        assertFalse(platoFuerte.verificarControlCalidad());

        platoFuerte.setPesoGramos(901);
        assertFalse(platoFuerte.verificarControlCalidad());
    }

    @Test
    @DisplayName("Rechaza un plato cuyo tiempo de preparación está fuera del rango")
    void verificarTiempoPreparacionFueraDeRango() {
        platoFuerte.setTiempoPreparacion(9);
        assertFalse(platoFuerte.verificarControlCalidad());

        platoFuerte.setTiempoPreparacion(61);
        assertFalse(platoFuerte.verificarControlCalidad());
    }

    @Test
    @DisplayName("Rechaza un plato cuya cocción no está aprobada")
    void verificarCoccionNoAprobada() {
        platoFuerte.setCoccionAprobada(false);

        assertFalse(platoFuerte.verificarControlCalidad());
    }
}