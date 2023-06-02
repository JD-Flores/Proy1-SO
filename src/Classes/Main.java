
package Classes;

import Interfaces.Menu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Main {

    public static void main(String[] args) {
        
        /*Functions func = new Functions();
        String BugattiData = func.readBugattiData();
        JOptionPane.showMessageDialog(null, BugattiData); */
        
        
        Menu menu = new Menu();
        menu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        menu.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent event) {
            exitProcedure();
        }
        public void exitProcedure() {
            menu.Guardar();
            menu.dispose();
            System.exit(0);
}
        });

}
    
}
