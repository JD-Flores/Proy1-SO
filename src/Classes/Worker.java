/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author isaac
 */
public class Worker extends Thread{
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
            sleep(this.dayDurationInMs);
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (this.type.equals("gerente")) {
            
            while (true) {
                int count = 0;
                while (count < 16) {
                    
                    try {
                        sleep( (int) this.dayDurationInMs / 48);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(plant.isManagerWorking) {
                        plant.isManagerWorking = false;
                    } else {
                        plant.isManagerWorking = true;
                    }
                    count++;
                }
                try {
                    sleep(this.dayDurationInMs/3);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
                payCheck();
                if(plant.dayCount>0){
                    plant.dayCount--;
                } 
               
                System.out.println("manager cobró y faltan "+plant.dayCount+" para la entrega");
                
            }
            
            
        } else if (this.type.equals("director")){
            
            while(true) {
                if(plant.dayCount == 0) {
                    try {
                        sellVehicles();
                        sleep(this.dayDurationInMs);
                       
                        plant.dayCount = 10;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Random random = new Random();
                    int randomTime = random.nextInt((int) this.dayDurationInMs);
                    try {
                        sleep(randomTime);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(plant.isManagerWorking) {
                        punishManager();
                        System.out.println("se ha penalizado al manager");
                        try {
                            sleep((this.dayDurationInMs*2*25)/30);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            sleep((this.dayDurationInMs*2*25)/30);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (plant.isManagerWorking) {
                            punishManager();
                            System.out.println("se ha penalizado al manager");
                        }
                    }
                    try {
                        sleep(this.dayDurationInMs-randomTime);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                payCheck();
                System.out.println("Director cobró");
            }
            
        } else {
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
        

        
       
    }
    
    public void payCheck() {
        this.accSalary += 24*this.salary;
        plant.costos += 24*this.salary;
    }
    
    public void produceForTheDay(){
        this.productionCounter += this.productionPerDay;
      
        
        if (this.productionCounter >= 1) {
            try {
                
                plant.mutex.acquire();
                if(type.equals("ensamblador")){
                    plant.warehouse.assembleVehicle(plant.getName());
                } else {
                    plant.warehouse.updateStorage(this.type, (int) this.productionCounter );
                }
                
                plant.mutex.release();
                
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            // intentar acceder al almacén
            
            this.productionCounter = 0;
        } 
    }
    
    public void punishManager() {
        plant.manager.accSalary -= 50;
        plant.faltasManager ++;
    }
    
    public void sellVehicles(){
        if (plant.getName().equals("Bugatti")){
            plant.ganancias += plant.warehouse.standardVehicle*550000;
            plant.warehouse.standardVehicle = 0;
            plant.ganancias += plant.warehouse.specialVehicle*600000;
            plant.warehouse.standardVehicle = 0;
        } else {
            
        }
    }
    
}