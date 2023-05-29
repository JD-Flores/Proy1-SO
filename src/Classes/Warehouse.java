package Classes;

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
    private int standardCounter = 0;
    
    public int standardVehicle;
    public int specialVehicle;
    
    public Warehouse(int maxChasis, int maxWheels, int maxCarro, int maxMotor, int maxAcces){
        this.maxChasisQty = maxChasis;
        this.maxWheelsQty = maxWheels;
        this.maxCarroQty = maxCarro;
        this.maxMotorQty = maxMotor;
        this.maxAccesQty = maxAcces;
        
        
        this.chasisQty = 0;
        this.wheelsQty = 0;
        this.carroQty = 0;
        this.motorQty = 0;
        this.accesQty = 0;
        
        this.standardVehicle = 0;
        this.specialVehicle = 0;
        
        
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
                    
                    System.out.println("chasis: " + this.chasisQty);
                }
                
                break;
            case "ruedas":
                if (this.wheelsQty < this.maxWheelsQty) {
                    this.wheelsQty += finishedPart;
                    
                    System.out.println("ruedas: " + this.wheelsQty);
                }
                break;
            case "motor":
                if (this.motorQty < this.maxMotorQty) {
                    this.motorQty += finishedPart;
                    
                    System.out.println("motor: " + this.motorQty);
                }
                break;
            case "carroceria":
                if (this.carroQty < this.maxCarroQty) {
                    this.carroQty += finishedPart;
                    
                    System.out.println("carroceria: " + this.carroQty);
                }
                break;            
            case "accesorios":
                if (this.accesQty < this.maxAccesQty) {
                    this.accesQty += finishedPart;
                    
                    System.out.println("accesorios: " + this.accesQty);
                }
                break;default:
                break;
        }
    }
    
    public void assembleVehicle(String plantName){
        if (plantName.equals("Bugatti")){
            if (standardCounter == 5){
                if (checkSpecialMats()) {
                    this.carroQty -= 2;
                    this.chasisQty -= 1;
                    this.motorQty -= 4;
                    this.wheelsQty -= 4;
                    this.accesQty -=2;
                    this.specialVehicle += 1;
                    this.standardCounter = 0;
                    System.out.println("Vehiculo especial: " + this.specialVehicle);
                } 
            } else {
                if (checkStandardMats()) {
                    this.carroQty -= 2;
                    this.chasisQty -= 1;
                    this.motorQty -= 4;
                    this.wheelsQty -= 4;
                    this.standardVehicle += 1;
                    this.standardCounter +=1;
                    System.out.println("Vehiculo estandar: " + this.standardVehicle);
                }
            }
            
        } else {
            
            //Quita si puede las partes correspondientes a un vehiculo de maserati
            
        }
    }
    
    public boolean checkSpecialMats() {
        
        // chequea lo necesario para un vehiculo marca bugatti
        
       return ((this.carroQty >= 2) && (this.chasisQty >= 1 )&& (this.motorQty >= 4) && (this.wheelsQty >= 4) && (this.accesQty >= 2));
    }
    
    
    public boolean checkStandardMats() {
        
        // chequea lo necesario para un vehiculo marca bugatti
        return ((this.carroQty >= 2) && (this.chasisQty >= 1) && (this.motorQty >= 4) && (this.wheelsQty >= 4));
    }
    
 }