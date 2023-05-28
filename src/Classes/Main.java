
package Classes;

import Interfaces.Menu;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        Functions func = new Functions();
        String BugattiData = func.readBugattiData();
        JOptionPane.showMessageDialog(null, BugattiData);
        
        int[] BugattiArray = func.transformBugattiData(BugattiData);

        
        
        VehiclePlant BuVehiclePlant = new VehiclePlant("Bugatti", 15, 1000, BugattiArray);
        
        // Menu menu = new Menu();


        // crear 2 company simulators (Bugatti y Maserati) con los datos de los trabajadores sacados del txt
        
    }
    
}
