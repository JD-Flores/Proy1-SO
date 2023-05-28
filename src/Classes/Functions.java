/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan Diego
 */
public class Functions {
    public boolean checkWorkers(int chasis, int carroceria, int motor, int ruedas, int accesorios, int max, int ensamblador){
        int suma = chasis + carroceria + motor + ruedas + accesorios + ensamblador;
        if (suma == max) {
            JOptionPane.showMessageDialog(null, "no puede haber mas de "+max+" trabajadores");
            return true;
        }
        return true;
    };
}
