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
    public String state;
    
    
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
        
        if (this.type.equals("manager")) {
            
            while (true) {
                                while (Global.play) {
                    int count = 0;
                    while (count < 32) {

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
                    plant.dayCount++;


                }
                try {
                    sleep(this.dayDurationInMs);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
            
        } else if (this.type.equals("director")){
            
            while (true) {
                while(Global.play) {
                    if((plant.dayCount!=0)&&(plant.dayCount % plant.deadlineInDays == 0)) {
                        try {
                            state = "Enviando vehículos";
                            sellVehicles();
                            sleep(this.dayDurationInMs);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Random random = new Random();
                        int randomTime = random.nextInt((int) this.dayDurationInMs);
                        state = "Labores administrativas";
                        try {
                            sleep(randomTime);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        state = "Revisando al gerente";
                        if(!plant.isManagerWorking) {
                            punishManager();
                            try {
                                sleep(this.dayDurationInMs*25/(60*24));
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            try {
                                sleep(this.dayDurationInMs*25/(60*24));
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (!plant.isManagerWorking) {
                                punishManager();
                            }
                        }
                        state = "Labores administrativas";
                        try {
                            sleep(this.dayDurationInMs-randomTime);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    payCheck();
                }
                try {
                    sleep(this.dayDurationInMs);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


            
        } else {
            while(true) {
                while(Global.play) {
                    try {

                        payCheck();
                        produceForTheDay();
                        sleep(this.dayDurationInMs);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
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
        plant.costos -= 50;
        plant.faltasManager ++;
    }
    
    public void sellVehicles(){
        plant.ganancias += plant.warehouse.standardVehicle*plant.pricesArray[0];
        plant.warehouse.standardVehicle = 0;
        plant.ganancias += plant.warehouse.specialVehicle*plant.pricesArray[1];
        plant.warehouse.specialVehicle = 0;
    }

    public float getProductionCounter() {
        return productionCounter;
    }

    public void setProductionCounter(float productionCounter) {
        this.productionCounter = productionCounter;
    }
    
    
}