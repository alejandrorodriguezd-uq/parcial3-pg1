
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;
    private Cliente cliente;

    @BeforeEach
    void configurarPedido() {
        new Restaurante(
                "El Buen Comer",
                123456,
                "Calle Principal"
        );

        cliente = new Cliente(
                123456,
                300123456,
                "Juan Perez",
                "juan@gmail.com",
                "Carrera 10"
        );

        pedido = new Pedido(
                101,
                LocalDate.of(2026, 11, 12),
                null,
                null,
                new ArrayList<>(),
                null,
                cliente,
                50000
        );
    }

    @Test
    @DisplayName("Encuentra un pedido registrado por su código")
    void buscarPedidoExistente() {
        Restaurante.listPedidosRestaurante.add(pedido);

        Pedido encontrado = pedido.busccarPedido(101);

        assertNotNull(encontrado);
        assertEquals(101, encontrado.getCodigo());
    }

    @Test
    @DisplayName("Devuelve null cuando el pedido no existe")
    void buscarPedidoInexistente() {
        Pedido encontrado = pedido.busccarPedido(999);

        assertNull(encontrado);
    }

    @Test
    @DisplayName("Actualiza correctamente el precio total del pedido")
    void actualizarPrecioTotal() {
        pedido.setPrecioTotal(75000);

        assertEquals(75000, pedido.getPrecioTotal());
    }

    @Test
    @DisplayName("Actualiza correctamente el código y la fecha")
    void actualizarCodigoYFecha() {
        LocalDate nuevaFecha = LocalDate.of(2026, 12, 1);

        pedido.setCodigo(202);
        pedido.setFecha(nuevaFecha);

        assertEquals(202, pedido.getCodigo());
        assertEquals(nuevaFecha, pedido.getFecha());
    }

    @Test
    @DisplayName("Muestra correctamente la información del pedido")
    void mostrarInformacionPedido() {
        String resultado = pedido.toString();

        assertNotNull(resultado);
        assertTrue(resultado.contains("codigo=101"));
        assertTrue(resultado.contains("precioTotal=50000.0"));
        assertTrue(resultado.contains("Juan Perez"));
    }
}
