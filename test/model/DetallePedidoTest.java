
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetallePedidoTest {

    private DetallePedido detalle;

    @BeforeEach
    void configurarDetalle() {
        detalle = new DetallePedido(2, 15000.0, null);
    }

    @Test
    @DisplayName("Crea correctamente un detalle de pedido")
    void crearDetallePedido() {
        assertEquals(2, detalle.getCantidad());
        assertEquals(15000.0, detalle.getPrecioUnitario(), 0.001);
        assertNull(detalle.getProducto());
    }

    @Test
    @DisplayName("Actualiza correctamente la cantidad")
    void actualizarCantidad() {
        detalle.setCantidad(5);

        assertEquals(5, detalle.getCantidad());
    }

    @Test
    @DisplayName("Actualiza correctamente el precio unitario")
    void actualizarPrecioUnitario() {
        detalle.setPrecioUnitario(20000.0);

        assertEquals(20000.0, detalle.getPrecioUnitario(), 0.001);
    }

    @Test
    @DisplayName("Permite asignar un producto nulo")
    void asignarProductoNulo() {
        detalle.setProducto(null);

        assertNull(detalle.getProducto());
    }

    @Test
    @DisplayName("Muestra correctamente la información del detalle")
    void mostrarInformacionDetalle() {
        String resultado = detalle.toString();

        assertNotNull(resultado);
        assertTrue(resultado.contains("cantidad=2"));
        assertTrue(resultado.contains("precioUnitario=15000.0"));
    }
}
