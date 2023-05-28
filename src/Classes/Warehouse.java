/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Juan Diego
 */
public class Warehouse {
    public int chasisQty;
    public int wheelsQty;
    public int carroQty;
    public int motorQty;
    public int accesQty;
    
    public int maxChasisQty;
    public int maxWheelsQty;
    public int maxCarroQty;
    public int maxMotorQty;
    public int maxAccesQty;
    
    public Warehouse(int maxChasis, int maxWheels, int maxCarro, int maxMotor, int maxAcces){
        this.maxChasisQty = maxChasis;
        this.maxWheelsQty = maxWheels;
        this.maxCarroQty = maxCarro;
        this.motorQty = maxMotor;
        this.maxAccesQty = maxAcces;
        
        
        this.chasisQty = 0;
        this.wheelsQty = 0;
        this.carroQty = 0;
        this.motorQty = 0;
        this.accesQty = 0;
        
        
    {
        
    }
        
    }
    
    public void test(){
        System.out.println("Estoy en warehouse");
    }
    
    public void updateStorage(String workerType, int finishedPart) {
        
        switch (workerType) {
            case "chasis":
                
                if (this.chasisQty < this.maxChasisQty) {
                    this.chasisQty += finishedPart;
                    
                    System.out.println(this.chasisQty);
                }
                
                break;
            case "wheels":
                if (this.wheelsQty < this.maxWheelsQty) {
                    this.wheelsQty += finishedPart;
                    
                    System.out.println(this.wheelsQty);
                }
                break;
            case "motor":
                if (this.chasisQty < this.maxChasisQty) {
                    this.chasisQty += finishedPart;
                    
                    System.out.println(this.chasisQty);
                }
                break;
            case "carroceria":
                if (this.carroQty < this.maxCarroQty) {
                    this.carroQty += finishedPart;
                    
                    System.out.println(this.carroQty);
                }
                break;            
            case "accesorios":
                if (this.accesQty < this.maxAccesQty) {
                    this.accesQty += finishedPart;
                    
                    System.out.println(this.accesQty);
                }
                break;default:
                break;
        }
    }
}
