/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author isaac
 */
public class VehiclePlant {
    private String name;
    private int maxWorkerQty;
    private Worker[] workers;
    private long dayDurationInMs;
    private int[] workerArray;
    public Warehouse warehouse;
    public Semaphore mutex;
    
    
    public VehiclePlant (String name, int maxWorkers, long dayDuration, int[] workerArray) {
        this.name = name;
        this.maxWorkerQty = maxWorkers;
        this.dayDurationInMs = dayDuration;
        this.workers = new Worker[maxWorkerQty];
        this.warehouse = new Warehouse(25, 35, 20, 55, 10);
        this.mutex = new Semaphore(1);
        this.workerArray = workerArray;
        
        initializeWorkers();
        
        
    }
    public String getName() {
        return name;
    }
    
    public void initializeWorkers(){
        for (int i = 0; i<6; i++){
            for (int j = 0; j<workerArray[i]; j++) {
                if (name.equals("Bugatti")) {
                    //León Serpa: ultimo numero de carnet: 5
                    if (i == 0) {
                        Worker worker = new Worker((float) 0.34, 10, dayDurationInMs, "chasis", this);
                        worker.start();
                        workers[i] = worker;
                    }
                    else if (i == 1) {
                        Worker worker = new Worker((float) 0.34, 13, dayDurationInMs, "carroceria", this);
                        worker.start();
                        workers[i] = worker;
                    }
                    else if (i == 2) {
                        Worker worker = new Worker((float) 2, 20, dayDurationInMs, "motor", this);
                        worker.start();
                        workers[i] = worker;
                    }
                    else if (i == 3) {
                        Worker worker = new Worker((float) 5, 8, dayDurationInMs, "ruedas", this);
                        worker.start();
                        workers[i] = worker;
                    }
                    else if (i == 4) {
                        Worker worker = new Worker((float) 0.5, 17, dayDurationInMs, "accesorios", this);
                        worker.start();
                        workers[i] = worker;
                    }
                    else if (i == 5) {
                        Worker worker = new Worker((float) 0.5, 25, dayDurationInMs, "ensamblador", this);
                        worker.start();
                        workers[i] = worker;
                    }

                } else {
                    
                    // código de Maserati, depende del ultimo numero de tu carnet
                }
                
                
            }
        }
    }
}
