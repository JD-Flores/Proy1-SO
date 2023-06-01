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
    private float[] productionArray;
    public Warehouse warehouse;
    public Semaphore mutex;
    public int dayCount;
    public boolean isManagerWorking;
    public Worker manager;
    public Worker director;
    public int faltasManager;
    public int costos;
    public int ganancias;
    private int salary;
    private String type;
    public int[] pricesArray;
    public int deadlineInDays;
    
    
    public VehiclePlant (String name, int maxWorkers, long dayDuration, int[] workerArray, float[] productionArray, int[] needsArray, int[] pricesArray, int deadlineInDays) {
        this.name = name;
        this.maxWorkerQty = maxWorkers;
        this.dayDurationInMs = dayDuration;
        this.workers = new Worker[maxWorkerQty];
        this.warehouse = new Warehouse(25, 35, 20, 55, 10, needsArray);
        this.mutex = new Semaphore(1);
        this.workerArray = workerArray;
        this.productionArray = productionArray;
        this.isManagerWorking = true;
        this.faltasManager = 0;
        this.pricesArray = pricesArray;
        this.deadlineInDays = deadlineInDays;
        
        
        this.dayCount = 10;
        
        initializeWorkers();
        
        
    }
    public String getName() {
        return name;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }
    
    
    
    public void initializeWorkers(){        
        Worker manager = new Worker ((float) 1, 20, dayDurationInMs, "manager", this);
        manager.start();
        this.manager = manager;
        
        Worker director = new Worker ((float) 1, 30, dayDurationInMs, "director", this);
        director.start();
        this.director = director;
        
        for (int i = 0; i<6; i++){
            for (int j = 0; j<workerArray[i]; j++) {
                //switch i with cases 0-5
                switch (i) {
                    case 0:
                        salary = 10;
                        type = "chasis";
                        break;
                    case 1:
                        salary = 13;
                        type = "carroceria";
                        break;
                    case 2:
                        salary = 20;
                        type = "motor";
                        break;
                    case 3:
                        salary = 8;
                        type = "ruedas";
                        break;
                    case 4:
                        salary = 17;
                        type = "accesorios";
                        break;
                    case 5:
                        salary = 25;
                        type = "ensamblador";
                        break;
                    default:
                        break;
                }
                Worker worker = new Worker(productionArray[i], salary, dayDurationInMs, type, this);
                    worker.start();
                    workers[i] = worker;
            }
        }
    }
}

