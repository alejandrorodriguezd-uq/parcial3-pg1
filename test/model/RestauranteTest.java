
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteTest {

    private Restaurante restaurante;

    @BeforeEach
    void configurarRestaurante() {
        restaurante = new Restaurante("El Buen Comer", 123456, "Calle 10");
    }

    @Test
    @DisplayName("Crea correctamente un restaurante")
    void crearRestaurante() {
        assertEquals("El Buen Comer", restaurante.getNombreComercial());
        assertEquals(123456, restaurante.getNit());
        assertEquals("Calle 10", restaurante.getDireccion());

        assertNotNull(restaurante.getListProductosRestaurante());
        assertNotNull(restaurante.getListPedidosRestaurante());
        assertNotNull(restaurante.getListClientesRestaurante());

        assertTrue(restaurante.getListProductosRestaurante().isEmpty());
        assertTrue(restaurante.getListPedidosRestaurante().isEmpty());
        assertTrue(restaurante.getListClientesRestaurante().isEmpty());
    }

    @Test
    @DisplayName("Actualiza correctamente el nombre comercial")
    void actualizarNombreComercial() {
        restaurante.setNombreComercial("Restaurante Nuevo");

        assertEquals("Restaurante Nuevo", restaurante.getNombreComercial());
    }

    @Test
    @DisplayName("Actualiza correctamente el NIT")
    void actualizarNit() {
        restaurante.setNit(987654);

        assertEquals(987654, restaurante.getNit());
    }

    @Test
    @DisplayName("Actualiza correctamente la dirección")
    void actualizarDireccion() {
        restaurante.setDireccion("Avenida Principal");

        assertEquals("Avenida Principal", restaurante.getDireccion());
    }

    @Test
    @DisplayName("Actualiza correctamente las listas del restaurante")
    void actualizarListasRestaurante() {
        List<Producto> productos = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        restaurante.setListProductosRestaurante(productos);
        restaurante.setListPedidosRestaurante(pedidos);
        restaurante.setListClientesRestaurante(clientes);

        assertEquals(productos, restaurante.getListProductosRestaurante());
        assertEquals(pedidos, restaurante.getListPedidosRestaurante());
        assertEquals(clientes, restaurante.getListClientesRestaurante());
    }

    @Test
    @DisplayName("Muestra correctamente la información del restaurante")
    void mostrarInformacionRestaurante() {
        String resultado = restaurante.toString();

        assertNotNull(resultado);
        assertTrue(resultado.contains("El Buen Comer"));
        assertTrue(resultado.contains("123456"));
        assertTrue(resultado.contains("Calle 10"));
    }
}
