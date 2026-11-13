
package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntregaSeguraTest {

    @Test
    @DisplayName("Calcula el domicilio para una distancia de 5 kilómetros")
    void calcularDomicilioCincoKilometros() {
        EntregaSegura entrega = new EntregaSegura();

        double resultado = entrega.CalcularDimicilio();

        assertEquals(12000.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Agrega el costo adicional cuando supera los 5 kilómetros")
    void calcularDomicilioSeisKilometros() {
        EntregaSegura entrega = new EntregaSegura();

        double resultado = entrega.CalcularDimicilio();

        assertEquals(16000.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Calcula correctamente el domicilio para 20 kilómetros")
    void calcularDomicilioVeinteKilometros() {
        EntregaSegura entrega = new EntregaSegura();

        double resultado = entrega.CalcularDimicilio();

        assertEquals(30000.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Vuelve a solicitar la distancia cuando supera los 20 kilómetros")
    void validarDistanciaMayorVeinteKilometros() {
        EntregaSegura entrega = new EntregaSegura();

        double resultado = entrega.CalcularDimicilio();

        assertEquals(12000.0, resultado, 0.001);
    }
}
