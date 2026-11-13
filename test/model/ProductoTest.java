
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    private Restaurante restaurante;

    @BeforeEach
    void configurarRestaurante() {
        restaurante = new Restaurante("El Buen Comer", 123456, "Calle 10");
    }

    // Implementación sencilla para poder probar la clase abstracta
    private Producto crearProducto(int tiempo, int codigo, String nombre,
                                   String descripcion, double precioBase,
                                   double precioVenta) {

        return new Producto(tiempo, codigo, nombre, descripcion, precioBase, precioVenta) {

            @Override
            public double calcularPrecioVenta(double precioBase,
                                              boolean preparacionEspecial,
                                              boolean refrigeracion) {
                return precioBase;
            }

            @Override
            public boolean verificarControlCalidad() {
                return true;
            }
        };
    }

    @Test
    @DisplayName("Crea correctamente un producto")
    void crearProducto() {
        Producto producto = crearProducto(
                20, 101, "Hamburguesa", "Hamburguesa especial", 10000.0, 15000.0
        );

        assertEquals(20, producto.getTiempoPreparacion());
        assertEquals(101, producto.getCodigo());
        assertEquals("Hamburguesa", producto.getNombre());
        assertEquals("Hamburguesa especial", producto.getDescripcion());
        assertEquals(10000.0, producto.getPrecioBase(), 0.001);
        assertEquals(15000.0, producto.getPrecioVenta(), 0.001);
    }

    @Test
    @DisplayName("Actualiza correctamente los atributos del producto")
    void actualizarAtributosProducto() {
        Producto producto = crearProducto(
                20, 101, "Hamburguesa", "Hamburguesa especial", 10000.0, 15000.0
        );

        producto.setTiempoPreparacion(30);
        producto.setCodigo(202);
        producto.setNombre("Pizza");
        producto.setDescripcion("Pizza familiar");
        producto.setPrecioBase(20000.0);
        producto.setPrecioVenta(25000.0);

        assertEquals(30, producto.getTiempoPreparacion());
        assertEquals(202, producto.getCodigo());
        assertEquals("Pizza", producto.getNombre());
        assertEquals("Pizza familiar", producto.getDescripcion());
        assertEquals(20000.0, producto.getPrecioBase(), 0.001);
        assertEquals(25000.0, producto.getPrecioVenta(), 0.001);
    }

    @Test
    @DisplayName("Encuentra un producto existente por su código")
    void buscarProductoExistente() {
        Producto producto = crearProducto(
                20, 101, "Hamburguesa", "Hamburguesa especial", 10000.0, 15000.0
        );

        restaurante.getListProductosRestaurante().add(producto);

        assertEquals(producto, Producto.buscarProducto(101));
    }

    @Test
    @DisplayName("Devuelve nulo cuando el producto no existe")
    void buscarProductoInexistente() {
        assertNull(Producto.buscarProducto(999));
    }

    @Test
    @DisplayName("Muestra correctamente la información del producto")
    void mostrarInformacionProducto() {
        Producto producto = crearProducto(
                20, 101, "Hamburguesa", "Hamburguesa especial", 10000.0, 15000.0
        );

        String resultado = producto.toString();

        assertNotNull(resultado);
        assertTrue(resultado.contains("Hamburguesa"));
        assertTrue(resultado.contains("101"));
        assertTrue(resultado.contains("10000.0"));
    }
}
