/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Diego
 */
public class Worker extends Thread {
    private float productionPerDay;
    private float salary;
    private float accSalary;
    private long dayDurationInMs;
    private String type;
    private float productionCounter;
    private VehiclePlant plant;
    
    
    public Worker(float productionPerDay, float salary, long dayDuration, String type, VehiclePlant plant) {
        this.productionPerDay = productionPerDay;
        this.salary = salary;
        this.accSalary = 0;
        this.dayDurationInMs = dayDuration;
        this.type = type;
        this.productionCounter = 0;
        this.plant = plant;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        while(true) {
             try {
                 
             payCheck();
             produceForTheDay();
                 
                 
            sleep(this.dayDurationInMs);
            
            
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
       
    }
    
    public void payCheck() {
        this.accSalary += this.salary;
    }
    
    public void produceForTheDay(){
        this.productionCounter += this.productionPerDay;
      
        
        if (this.productionCounter >= 1) {
            try {
                
                plant.mutex.acquire();
                plant.warehouse.updateStorage(this.type, (int) this.productionCounter );
                plant.mutex.release();
                
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            // intentar acceder al almacén
            
            this.productionCounter = 0;
        } 
    }
}
