package model;

import javax.swing.*;

public class EntregaSegura implements Domicilio{
    @Override
    public double CalcularDimicilio() {
        double precioTotal=0;
        double tarifaBase=7000;
        double kilomteros=0;

        do{
            kilomteros=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia del domicilio en kilometros "));

            if(kilomteros<=20){
                if(kilomteros>5){
                    precioTotal+=3000;
                }
                precioTotal+= tarifaBase+kilomteros*1000;
            }else{
                JOptionPane.showMessageDialog(null, "No se puede agendar una distancia mas de 12 km, intente nuevamnete");
            }

        }while ((kilomteros>20));
        return precioTotal;
    }
}
