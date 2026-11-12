package model;

import javax.swing.*;
import java.util.jar.JarOutputStream;

public class RapidoExpress implements Domicilio{

    @Override
    public double CalcularDimicilio() {
        double precioTotal=0;
        double tarifaBase= 5000;
        double kilomteros=0;
        do{
            kilomteros=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia del domicilio en kilometros "));

            if(kilomteros<=12){
                precioTotal+= tarifaBase+kilomteros*1500;
            }else{

                JOptionPane.showMessageDialog(null, "No se puede agendar una distancia mas de 12 km, intente nuevamnete");
            }
        }while(kilomteros>12);

        return precioTotal;
    }
}
