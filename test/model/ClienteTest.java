
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void configurarCliente() {
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
    }

    @Test
    @DisplayName("Registra correctamente un cliente")
    void registrarCliente() {
        String resultado = cliente.registrarCliente(
                123456,
                300123456,
                "Juan Perez",
                "juan@gmail.com",
                "Carrera 10"
        );

        assertEquals("Cliente registrado", resultado);
        assertEquals(1, Restaurante.listClientesRestaurante.size());
        assertNotNull(Restaurante.listClientesRestaurante.get(0));
        assertEquals(
                123456,
                Restaurante.listClientesRestaurante.get(0).getDocumento()
        );
    }

    @Test
    @DisplayName("Impide registrar clientes con documentos duplicados")
    void registrarClienteDuplicado() {
        Restaurante.listClientesRestaurante.add(cliente);

        String resultado = cliente.registrarCliente(
                123456,
                300987654,
                "Carlos Lopez",
                "carlos@gmail.com",
                "Calle 20"
        );

        assertEquals(
                "No se pudo registrar. Ya hay un cliente con este documento",
                resultado
        );

        assertEquals(1, Restaurante.listClientesRestaurante.size());
    }

    @Test
    @DisplayName("Encuentra un cliente registrado por su documento")
    void buscarClienteExistente() {
        Restaurante.listClientesRestaurante.add(cliente);

        Cliente encontrado = cliente.busccarCliente(123456);

        assertNotNull(encontrado);
        assertEquals(123456, encontrado.getDocumento());
        assertEquals("Juan Perez", encontrado.getNombreCompleto());
    }

    @Test
    @DisplayName("Devuelve null cuando el cliente no está registrado")
    void buscarClienteInexistente() {
        Cliente encontrado = cliente.busccarCliente(999999);

        assertNull(encontrado);
    }

    @Test
    @DisplayName("Consulta correctamente el historial de pedidos")
    void consultarHistorialPedidos() {
        Restaurante.listClientesRestaurante.add(cliente);

        Pedido pedido = new Pedido(
                101,
                LocalDate.of(2026, 11, 12),
                null,
                null,
                new ArrayList<>(),
                null,
                cliente,
                0
        );

        cliente.getListPedidosCliente().add(pedido);

        String historial = cliente.consultarHistorialPedidos(123456);

        assertNotNull(historial);
        assertTrue(historial.contains("codigo=101"));
    }
}
