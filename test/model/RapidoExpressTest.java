
package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RapidoExpressTest {

    @Test
    @DisplayName("Calcula correctamente el domicilio para 5 kilómetros")
    void calcularDomicilioCincoKilometros() {
        RapidoExpress rapido = new RapidoExpress();

        double resultado = rapido.CalcularDimicilio();

        assertEquals(12500.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Calcula correctamente el domicilio para 12 kilómetros")
    void calcularDomicilioDoceKilometros() {
        RapidoExpress rapido = new RapidoExpress();

        double resultado = rapido.CalcularDimicilio();

        assertEquals(23000.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Vuelve a solicitar la distancia cuando supera los 12 kilómetros")
    void validarDistanciaMayorDoceKilometros() {
        RapidoExpress rapido = new RapidoExpress();

        double resultado = rapido.CalcularDimicilio();

        assertEquals(12500.0, resultado, 0.001);
    }
}
