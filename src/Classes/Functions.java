
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
        
        for (int i = 0; i < 7; i++) {
            array[i] = array[i].split(": ")[1];
        }
        
        
        int[] array2 = new int[7];
        
        for (int i = 0; i<7; i++) {
            array2[i] = Integer.parseInt(array[i]);
        }
        return array2;        
        
    }
    
    public String readMaseratiData() {
        String contenido_txt = "";
        String line;
        File file = new File("Src\\Txt\\MaseratiData.txt");
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
    
    public int[] transformMaseratiData(String Data) {
        
        String info = Data.split("Maserati:\n")[1];
        
        String[] array = info.split("\n");
        
        for (int i = 0; i < 7; i++) {
            array[i] = array[i].split(": ")[1];
        }
        
        
        int[] array2 = new int[7];
        
        for (int i = 0; i<7; i++) {
            array2[i] = Integer.parseInt(array[i]);
        }
        return array2;
        
    }
    
    public int readDayDurationData() {
        String contenido_txt = "";
        String line;
        File file = new File("Src\\Txt\\dayDuration.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                try (BufferedReader br = new BufferedReader(fr)) {
                    if (((line = br.readLine()) != null) && !line.isEmpty()) {
                        contenido_txt += line;
                    }
                }
              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
 
        contenido_txt = contenido_txt.split(" ")[1];
        return Integer.parseInt(contenido_txt);
        
    }
}
