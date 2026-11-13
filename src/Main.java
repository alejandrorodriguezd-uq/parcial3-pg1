import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.*;

public class Main {
    public static void main(String[] args){
        //INSTANCIAR CONTROLADOR
        Cliente gestorClientes = new Cliente(0, 0, "", "", "");
        Pedido gestorPedidos = new Pedido(
                0,
                LocalDate.now(),
                ModalidadEntrega.CONSUMO_EN_RESTAURANTE,
                EstadoPedido.PENDIENTE,
                new ArrayList<>(),
                null,
                gestorClientes,
                0.0
        );
        Postre gestorPostres = new Postre(0, 0, "", "", 0.0, 0.0, 0.0, 0.0, false);
        PlatoFuerte gestorPlatos = new PlatoFuerte(0, 0, "", "", 0.0, 0.0, 0.0, false, TipoPreparacion.ASADO);
        Bebida gestorBebidas = new Bebida(0, 0, "", "", 0.0, 0.0, 0, 0.0, false, false);

        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "----- MENÚ PRINCIPAL -----\n" +
                    "1. Registrar Productos\n" +
                    "2. Registrar Clientes\n" +
                    "3. Registrar Pedidos\n" +
                    "4. Calcular el total de una venta\n" +
                    "5. Consultar el historial de pedidos de un cliente\n" +
                    "6. Salir\n" +
                    "Selecciona una opción del menú"));

            switch (opcion) {

                // REGISTRAR PRODUCTOS
                case 1:{
                    int TipoProducto = Integer.parseInt(JOptionPane.showInputDialog(null, "" +
                            "Postre -> 1\n" +
                            "Plato Fuerte -> 2\n" +
                            "Bebida -> 3"));

                    //AGREGAR POSTRE
                    if (TipoProducto == 1) {
                        int timePreparacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tiempo de preparación"));
                        int code = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el código del postre: "));
                        String name = JOptionPane.showInputDialog(null, "Ingresa el nombre del postre: ");
                        String descript = JOptionPane.showInputDialog(null, "Ingresa la descripción del proyecto: ");
                        double precioB = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el precio base: "));
                        double pesoG = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el peso en gramos: "));
                        double tempAlmacenamiento = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa la temperatura en almacenamiento: "));
                        boolean refri = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Ingresa si requiere refrigeración (True / False): "));

                        String mensaje = gestorPostres.registrarPostre(timePreparacion, code, name, descript, precioB, pesoG, tempAlmacenamiento, refri);
                        JOptionPane.showMessageDialog(null, mensaje);
                    } //AGREGAR PLATO FUERTE
                    else if (TipoProducto == 2) {
                        int timePreparacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tiempo de preparación"));
                        int code = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el código del postre: "));
                        String name = JOptionPane.showInputDialog(null, "Ingresa el nombre del postre: ");
                        String descript = JOptionPane.showInputDialog(null, "Ingresa la descripción del proyecto: ");
                        double precioB = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el precio base: "));
                        double pesoG = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el peso en gramos: "));
                        boolean coccion = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Ingresa (True / False) si la cocción es aprobada: "));

                        int tipoP = Integer.parseInt(JOptionPane.showInputDialog(null, "1. ASADO \n2. FRITO \n3. HORNEADO \n4. A_LA_PLANCHA"));
                        TipoPreparacion tipoPreparacion = null;
                        // DESIGNAR TIPO DE PLATO
                        if (tipoP == 1) {
                            tipoPreparacion = TipoPreparacion.ASADO;
                        } else if (tipoP == 2) {
                            tipoPreparacion = TipoPreparacion.FRITO;
                        } else if (tipoP == 3) {
                            tipoPreparacion = TipoPreparacion.HORNEADO;
                        } else if (tipoP == 4) {
                            tipoPreparacion = TipoPreparacion.A_LA_PLANCHA;
                        } else {
                            JOptionPane.showMessageDialog(null, "Escoge una opción Válida.");
                            break;
                        }

                        String mensaje = gestorPlatos.registrarPlatoFuerte(timePreparacion, code, name, descript, precioB, pesoG, coccion, tipoPreparacion);
                        JOptionPane.showMessageDialog(null, mensaje);

                    } //AGREGAR BEBIDA
                    else if (TipoProducto == 3) {
                        int timePreparacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tiempo de preparación"));
                        int code = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el código del postre: "));
                        String name = JOptionPane.showInputDialog(null, "Ingresa el nombre del postre: ");
                        String descript = JOptionPane.showInputDialog(null, "Ingresa la descripción del proyecto: ");
                        double precioB = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el precio base: "));
                        int volMili = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la cantidad de mililítros que hayan en la bebida: "));
                        double tempServicio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa la temperatura de Servicio: "));
                        boolean frio = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Ingresa si es fría (True / False): "));
                        boolean prepaEspecial = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Ingresa si tiene preparación especial (True / False): "));

                        String mensaje = gestorBebidas.registrarBebida(timePreparacion, code, name, descript, precioB, volMili, tempServicio, frio, prepaEspecial);
                        JOptionPane.showMessageDialog(null, mensaje);

                    } else {
                        JOptionPane.showMessageDialog(null, "Escribe una opción válida.");
                    }

                    break;
                }
                // REGISTRAR CLIENTES
                case 2: {
                    int document = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el número de documento: "));
                    int tele = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el número de teléfono: "));
                    String name = JOptionPane.showInputDialog(null, "Ingresa el nombre del cliente: ");
                    String corre = JOptionPane.showInputDialog(null, "Ingresa el correo electrónico del cliente: ");
                    String dir = JOptionPane.showInputDialog(null, "Ingresa la dirección del cliente: ");

                    String mensaje = gestorClientes.registrarCliente(document, tele, name, corre, dir);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                }
                // REGISTRAR PEDIDOS
                case 3:{
                    int code = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el codigo del pedido: "));

                    String input = JOptionPane.showInputDialog(null, "Ingresa la fecha de hoy (dd/MM/yyyy):");
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate feche = LocalDate.parse(input, formato);

                    int tipoP = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Domicilio \n2. Comer en restaurante"));
                    //MODALIDAD ENTREGA
                    ModalidadEntrega modalidadEntrega = null;
                    // DESIGNAR TIPO DE PLATO
                    if (tipoP == 1) {
                                modalidadEntrega = ModalidadEntrega.DOMICILIO;
                    } else if (tipoP == 2) {
                        modalidadEntrega = ModalidadEntrega.CONSUMO_EN_RESTAURANTE;
                    } else {
                        JOptionPane.showMessageDialog(null, "Escoge una opción Válida.");
                        break;
                    }

                    EstadoPedido estadoPedido = EstadoPedido.PENDIENTE;

                    //DOMICILIO
                    Domicilio empresaDomicilio = null;
                    if (tipoP == 1){
                        int tipoD = Integer.parseInt(JOptionPane.showInputDialog(null, "1. EntregaSegura, 2. RapidoExpress, 3. automático"));
                        if (tipoD == 1){
                            empresaDomicilio = new EntregaSegura();

                        }else if(tipoD == 2){
                            empresaDomicilio = new RapidoExpress();

                        }else if(tipoD == 3){
                            empresaDomicilio = null;
                        }else{
                            JOptionPane.showMessageDialog(null, "Escoge una opción válida.");
                            break;
                        }
                    }

                    int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento del cliente: "));
                    Cliente cliente = Cliente.busccarCliente(documento);

                    String mensaje = gestorPedidos.registrarPedido(code, feche, modalidadEntrega, estadoPedido, empresaDomicilio, cliente);
                    JOptionPane.showMessageDialog(null, mensaje);

                    break;
                }
                // CALCULAR EL VALOR TOTAL DE UN PEDIDO
                case 4: {
                    int code = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el código de pedido: "));

                    String mensaje = Pedido.calcularPrecioPedido(code);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                }
                // CONSULTAR EL HISTORIAL DE PEDIDOS DE UN CLIENTE
                case 5: {
                    int code = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento del cliente: "));

                    String mensaje = Cliente.consultarHistorialPedidos(code);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                }
                default:

                    break;
            }

        }while(opcion !=6);
    }
}