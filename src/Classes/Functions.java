
package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class Functions {
    
    public boolean checkWorkers(int chasis, int carroceria, int motor, int ruedas, int accesorios, int max, int ensamblador){
        int suma = chasis + carroceria + motor + ruedas + accesorios + ensamblador;
        if (suma == max) {
            JOptionPane.showMessageDialog(null, "no puede haber mas de "+max+" trabajadores");
            return false;
        }
        return true;
    };
    
    public String readBugattiData() {
        String contenido_txt = "";
        String line;
        File file = new File("Src\\Txt\\BugattiData.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        contenido_txt += line + "\n";
                    }
                }
                br.close();
              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return contenido_txt;
        
    }
    
    public int[] transformBugattiData(String Data) {
        
        String info = Data.split("Bugatti:\n")[1];
        
        String[] array = info.split("\n");
        
        array[0] = array[0].split("Creadores de chasis: ")[1];
        array[1] = array[1].split("Creadores de carroceria: ")[1];
        array[2] = array[2].split("Creadores de motores: ")[1];
        array[3] = array[3].split("Creadores de ruedas: ")[1];
        array[4] = array[4].split("Creadores de accesorios: ")[1];
        array[5] = array[5].split("Ensambladores: ")[1];
        
        
        int[] array2 = new int[6];
        
        for (int i = 0; i<6; i++) {
            array2[i] = Integer.parseInt(array[i]);
        }
        
        return array2;
        
        
    }
}
