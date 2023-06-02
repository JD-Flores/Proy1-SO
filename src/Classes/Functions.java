
package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    
    public String readPlantData(String name) {
        String contenido_txt = "";
        String line;
        File file = new File("Src\\Txt\\"+name+"Data.txt");
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
    
    public int[] transformVehicleData(String Data, String name) {
        
        String info = Data.split(name+":\n")[1];
        
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
    
    public void GuardarDatos(String BuChasis, String BuCarro, String BuMotor, String BuRuedas, String BuAcce, String BuEnsam, String BuDeadline, String MaChasis, String MaCarro, String MaMotor, String MaRuedas, String MaAcce, String MaEnsam, String MaDeadline, String dayDuration){
        String contenido_txt = "";
        contenido_txt = "dayDuration: "+dayDuration;
        File file = new File("Src\\Txt\\dayDuration.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            } else {
                FileWriter fw = new FileWriter(file);
                fw.write(contenido_txt);
                fw.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        contenido_txt = "Bugatti:\n" +
                        "Creadores de chasis: " + BuChasis + "\n" +
                        "Creadores de carroceria: " + BuCarro + "\n" +
                        "Creadores de motores: " + BuMotor + "\n" +
                        "Creadores de ruedas: " + BuRuedas + "\n" +
                        "Creadores de accesorios: " + BuAcce + "\n" +
                        "Ensambladores: " + BuEnsam + "\n" +
                        "Deadline: " + BuDeadline;
        file = new File("Src\\Txt\\BugattiData.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            } else {
                FileWriter fw = new FileWriter(file);
                fw.write(contenido_txt);
                fw.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        contenido_txt = "Maserati:\n" +
                        "Creadores de chasis: " + MaChasis + "\n" +
                        "Creadores de carroceria: " + MaCarro + "\n" +
                        "Creadores de motores: " + MaMotor + "\n" +
                        "Creadores de ruedas: " + MaRuedas + "\n" +
                        "Creadores de accesorios: " + MaAcce + "\n" +
                        "Ensambladores: " + MaEnsam + "\n" +
                        "Deadline: " + MaDeadline;
        file = new File("Src\\Txt\\MaseratiData.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            } else {
                FileWriter fw = new FileWriter(file);
                fw.write(contenido_txt);
                fw.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
