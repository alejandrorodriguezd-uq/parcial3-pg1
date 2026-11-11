import javax.swing.JOptionPane;

public class Main {
    public void main(String[] args){
        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "----- MENÚ PRINCIPAL -----\n" +
                    "1. \n" +
                    "2. \n" +
                    "3. \n" +
                    "4. \n" +
                    "5. \n" +
                    "6. \n" +
                    "7. Salir\n" +
                    "Selecciona una opción del menú"));

            switch (opcion) {

                // REGISTRAR PRODUCTOS
                case 1:

                    break;

                // REGISTRAR CLIENTES
                case 2:

                    break;

                // REGISTRAR PEDIDOS
                case 3:

                    break;

                // CALCULAR EL VALOR TOTAL DE UN PEDIDO
                case 4:

                    break;

                // CONSULTAR EL HISTORIAL DE PEDIDOS DE UN CLIENTE
                case 5:

                    break;

                default:

                    break;
            }

        }while(opcion !=7);
    }
}