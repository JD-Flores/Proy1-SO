/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Functions;
import Classes.Global;
import Classes.VehiclePlant;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Windows
 */
public class Menu extends javax.swing.JFrame {

    private Functions func = new Functions();
    
    String BugattiData = func.readPlantData("Bugatti");
    int[] BugattiArray = func.transformVehicleData(BugattiData, "Bugatti");
    //León Serpa - Bugatti - Ult. num. carnet: 5
    float[] BugattiProductionArray = {(float)0.34, (float)0.34, 2, 5, (float)0.5, (float)0.5};
    int[] BugattiAssemblyNeeds = {2,1,4,4,2};
    int[] BugattiPricesArray = {550000, 600000};
    int BugattiDeadlineInDays = BugattiArray[6];
    
    String MaseratiData = func.readPlantData("Maserati");
    int[] MaseratiArray = func.transformVehicleData(MaseratiData, "Maserati");
    //Juan Flores - Maserati - Ult. num. carnet: 7
    float[] MaseratiProductionArray = {(float)0.25, (float)0.25, 1, 5, (float)0.5, (float)0.5};
    int[] MaseratiAssemblyNeeds = {1,1,2,4,3};
    int[] MaseratiPricesArray = {350000,700000};
    int MaseratiDeadlineInDays = MaseratiArray[6];
    
    int dayDurationInMs = func.readDayDurationData();
    
    int chasisB;
    int carroB;
    int motorB;
    int ruedasB;
    int acceB;
    int ensamB;
    int maxB;
    
    int chasisM;
    int carroM;
    int motorM;
    int ruedasM;
    int acceM;
    int ensamM;
    int maxM;

    int suma=0;
    
    int[] BugattiStartArray = new int[6];
    int[] MaseratiStartArray = new int[6];
    
    VehiclePlant BuVehiclePlant;
    VehiclePlant MaVehiclePlant;
    
    
    public Menu() {
        initComponents();
        this.setTitle("Proyecto 1");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        
        suma = 0;
        for (int i = 0; i < BugattiArray.length-1; i++) {
            suma += BugattiArray[i];
        }
        if (suma <= 15) {
            NChasisBugatti.setText(Integer.toString(BugattiArray[0]));
            NCarroBugatti.setText(Integer.toString(BugattiArray[1]));
            NMotorBugatti.setText(Integer.toString(BugattiArray[2]));
            NRuedasBugatti.setText(Integer.toString(BugattiArray[3]));
            NAcceBugatti.setText(Integer.toString(BugattiArray[4]));
            NEnsamB.setText(Integer.toString(BugattiArray[5]));
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al cargar trabajadores: La suma de los trabajadores de Bugatti es mayor a 15");
        }
            
        suma=0;
        for (int i = 0; i < MaseratiArray.length-1; i++) {
            suma += MaseratiArray[i];
        }
        if (suma <= 17) {
            NChasisMaserati.setText(Integer.toString(MaseratiArray[0]));
            NCarroMaserati.setText(Integer.toString(MaseratiArray[1]));
            NMotorMaserati.setText(Integer.toString(MaseratiArray[2]));
            NRuedasMaserati.setText(Integer.toString(MaseratiArray[3]));
            NAcceMaserati.setText(Integer.toString(MaseratiArray[4]));
            NEnsamM.setText(Integer.toString(MaseratiArray[5]));
        } else {
            JOptionPane.showMessageDialog(null, "Fallo al cargar tarbajadores: La suma de los trabajadores de Maserati es mayor a 17");
        }
        
        
        this.chasisB = Integer.parseInt(NChasisBugatti.getText());
        this.carroB = Integer.parseInt(NCarroBugatti.getText());
        this.motorB = Integer.parseInt(NMotorBugatti.getText());
        this.ruedasB = Integer.parseInt(NRuedasBugatti.getText());
        this.acceB = Integer.parseInt(NAcceBugatti.getText());
        this.ensamB = Integer.parseInt(NEnsamM.getText());
        this.maxB = Integer.parseInt(NBugatti.getText());
        
        this.chasisM = Integer.parseInt(NChasisMaserati.getText());
        this.carroM = Integer.parseInt(NCarroMaserati.getText());
        this.motorM = Integer.parseInt(NMotorMaserati.getText());
        this.ruedasM = Integer.parseInt(NRuedasMaserati.getText());
        this.acceM = Integer.parseInt(NAcceMaserati.getText());
        this.ensamM = Integer.parseInt(NEnsamM.getText());
        this.maxM = Integer.parseInt(NMaserati.getText());
        
        this.BugattiDeadlineInDays = BugattiArray[6];
        BugattiDeadlineSpinner.setValue(BugattiDeadlineInDays);
        
        this.MaseratiDeadlineInDays = MaseratiArray[6];
        MaseratiDeadlineSpinner.setValue(MaseratiDeadlineInDays);
        
        this.dayDurationSpinner.setValue(dayDurationInMs);
        
        
    }
    
    private void startTimer() {
        int delay = 10; // milliseconds
        ActionListener taskPerformer = new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
                chasisBCounterLabel.setText(Integer.toString((int)Math.floor(BuVehiclePlant.warehouse.chasisQty)));
                carroBCounterLabel.setText(Integer.toString((int)Math.floor(BuVehiclePlant.warehouse.carroQty)));
                motorBCounterLabel.setText(Integer.toString((int)Math.floor(BuVehiclePlant.warehouse.motorQty)));
                ruedasBCounterLabel.setText(Integer.toString((int)Math.floor(BuVehiclePlant.warehouse.wheelsQty)));
                accesBCounterLabel.setText(Integer.toString((int)Math.floor(BuVehiclePlant.warehouse.accesQty)));
                specialVehicleBCounterLabel.setText(Integer.toString((int)Math.floor(BuVehiclePlant.warehouse.specialVehicle)));
                standardVehicleBCounterLabel.setText(Integer.toString((int)Math.floor(BuVehiclePlant.warehouse.standardVehicle)));

                chasisMCounterLabel.setText(Integer.toString((int)Math.floor(MaVehiclePlant.warehouse.chasisQty)));
                carroMCounterLabel.setText(Integer.toString((int)Math.floor(MaVehiclePlant.warehouse.carroQty)));
                motorMCounterLabel.setText(Integer.toString((int)Math.floor(MaVehiclePlant.warehouse.motorQty)));
                ruedasMCounterLabel.setText(Integer.toString((int)Math.floor(MaVehiclePlant.warehouse.wheelsQty)));
                accesMCounterLabel.setText(Integer.toString((int)Math.floor(MaVehiclePlant.warehouse.accesQty)));
                specialVehicleMCounterLabel.setText(Integer.toString((int)Math.floor(MaVehiclePlant.warehouse.specialVehicle)));
                standardVehicleMCounterLabel.setText(Integer.toString((int)Math.floor(MaVehiclePlant.warehouse.standardVehicle)));
                
                BuTimeUntilDeadline.setText(Integer.toString(BuVehiclePlant.dayCount%BuVehiclePlant.deadlineInDays));
                MaTimeUntilDeadline.setText(Integer.toString(MaVehiclePlant.dayCount%MaVehiclePlant.deadlineInDays));    
                
                dayCount.setText(Integer.toString(BuVehiclePlant.dayCount));
                
                BuFaltas.setText(Integer.toString(BuVehiclePlant.faltasManager));
                MaFaltas.setText(Integer.toString(MaVehiclePlant.faltasManager));
                
                BuPenalty.setText(Integer.toString(BuVehiclePlant.faltasManager*50)+"$");
                MaPenalty.setText(Integer.toString(MaVehiclePlant.faltasManager*50)+"$");
                
                BuWinnings.setText(Integer.toString(BuVehiclePlant.ganancias)+"$");
                BuCosts.setText(Integer.toString(BuVehiclePlant.costos)+"$");
                BuUtility.setText(Integer.toString(BuVehiclePlant.ganancias-BuVehiclePlant.costos)+"$");
                
                MaWinnings.setText(Integer.toString(MaVehiclePlant.ganancias)+"$");
                MaCosts.setText(Integer.toString(MaVehiclePlant.costos)+"$");
                MaUtility.setText(Integer.toString(MaVehiclePlant.ganancias-BuVehiclePlant.costos)+"$");
                
                
                if (BuVehiclePlant.isManagerWorking) {
                    managerStateBLabel.setText("Trabajando");
                } else  {
                    managerStateBLabel.setText("Viendo carreras");
                }
                
                if (MaVehiclePlant.isManagerWorking) {
                    managerStateMLabel.setText("Trabajando");
                }else{
                    managerStateMLabel.setText("Viendo carreras");
                }
                
                directorStateBLabel.setText(BuVehiclePlant.director.state);
                directorStateMLabel.setText(MaVehiclePlant.director.state);
                
           }
        };
      new javax.swing.Timer(delay, taskPerformer).start();
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NEnsamM = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        NMaserati = new javax.swing.JLabel();
        NAcceMaserati = new javax.swing.JLabel();
        NCarroBugatti = new javax.swing.JLabel();
        NMotorBugatti = new javax.swing.JLabel();
        NRuedasBugatti = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        NBugatti = new javax.swing.JLabel();
        NChasisBugatti = new javax.swing.JLabel();
        NChasisMaserati = new javax.swing.JLabel();
        NCarroMaserati = new javax.swing.JLabel();
        NMotorMaserati = new javax.swing.JLabel();
        NRuedasMaserati = new javax.swing.JLabel();
        Start = new javax.swing.JButton();
        Stop = new javax.swing.JButton();
        Play = new javax.swing.JButton();
        BEnsamM = new javax.swing.JButton();
        BAcceM = new javax.swing.JButton();
        BChasisB = new javax.swing.JButton();
        BCarroB = new javax.swing.JButton();
        SCarroB = new javax.swing.JButton();
        SMotorB = new javax.swing.JButton();
        BMotorB = new javax.swing.JButton();
        SRuedasB = new javax.swing.JButton();
        BRuedasB = new javax.swing.JButton();
        SEnsamM = new javax.swing.JButton();
        SChasisB = new javax.swing.JButton();
        SChasisM = new javax.swing.JButton();
        BChasisM = new javax.swing.JButton();
        SCarroM = new javax.swing.JButton();
        BCarroM = new javax.swing.JButton();
        SMotorM = new javax.swing.JButton();
        BMotorM = new javax.swing.JButton();
        SRuedasM = new javax.swing.JButton();
        BRuedasM = new javax.swing.JButton();
        SAcceM = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        NAcceBugatti = new javax.swing.JLabel();
        SAcceB = new javax.swing.JButton();
        BAcceB = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        NEnsamB = new javax.swing.JLabel();
        SEnsamB = new javax.swing.JButton();
        BEnsamB = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        dayDurationSpinner = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        MaseratiDeadlineSpinner = new javax.swing.JSpinner();
        jLabel29 = new javax.swing.JLabel();
        BugattiDeadlineSpinner = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        accesBCounterLabel = new javax.swing.JLabel();
        carroBCounterLabel = new javax.swing.JLabel();
        motorBCounterLabel = new javax.swing.JLabel();
        ruedasBCounterLabel = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        carroMCounterLabel = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        dayCount = new javax.swing.JLabel();
        MaUtility = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        MaTimeUntilDeadline = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        specialVehicleBCounterLabel = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        directorStateMLabel = new javax.swing.JLabel();
        managerStateMLabel = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        BuTimeUntilDeadline = new javax.swing.JLabel();
        MaFaltas = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        MaWinnings = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        MaCosts = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        chasisBCounterLabel = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        accesMCounterLabel = new javax.swing.JLabel();
        motorMCounterLabel = new javax.swing.JLabel();
        ruedasMCounterLabel = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        chasisMCounterLabel = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        standardVehicleBCounterLabel = new javax.swing.JLabel();
        standardVehicleMCounterLabel = new javax.swing.JLabel();
        specialVehicleMCounterLabel = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        managerStateBLabel = new javax.swing.JLabel();
        BuFaltas = new javax.swing.JLabel();
        BuPenalty = new javax.swing.JLabel();
        directorStateBLabel = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        BuWinnings = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        BuCosts = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        BuUtility = new javax.swing.JLabel();
        Stop2 = new javax.swing.JButton();
        Play1 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        MaPenalty = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        Stop1 = new javax.swing.JButton();
        Play2 = new javax.swing.JButton();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BugattiLogo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 240, 120));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MaseratiLogo.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 160));

        jLabel1.setText("Bugatti");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabel2.setText("Maserati");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, -1));

        jLabel5.setText("Numero de trabajadores:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 160, -1));

        NEnsamM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NEnsamM.setText("1");
        jPanel1.add(NEnsamM, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 20, -1));

        jLabel7.setText("Creadores de accesorios:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 150, -1));

        jLabel8.setText("Numero de trabajadores:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 160, -1));

        jLabel9.setText("Creadores de chasis:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 140, -1));

        jLabel10.setText("Creador de carrocería:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 140, -1));

        jLabel11.setText("Creadores de motor: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 140, -1));

        jLabel12.setText("Creadores de ruedas:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 140, -1));

        NMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NMaserati.setText("17");
        jPanel1.add(NMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 20, -1));

        NAcceMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NAcceMaserati.setText("1");
        jPanel1.add(NAcceMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 20, -1));

        NCarroBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NCarroBugatti.setText("1");
        jPanel1.add(NCarroBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 20, -1));

        NMotorBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NMotorBugatti.setText("1");
        jPanel1.add(NMotorBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 20, -1));

        NRuedasBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NRuedasBugatti.setText("1");
        jPanel1.add(NRuedasBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 20, -1));

        jLabel18.setText("Creadores de chasis:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 130, -1));

        jLabel19.setText("Creador de carrocería:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 130, -1));

        jLabel20.setText("Creadores de motor: ");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 130, -1));

        jLabel21.setText("Creadores de ruedas:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 130, -1));

        jLabel22.setText("Ensambladores:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 120, -1));

        NBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NBugatti.setText("15");
        jPanel1.add(NBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 20, -1));

        NChasisBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NChasisBugatti.setText("1");
        jPanel1.add(NChasisBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 20, -1));

        NChasisMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NChasisMaserati.setText("1");
        jPanel1.add(NChasisMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 20, -1));

        NCarroMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NCarroMaserati.setText("1");
        jPanel1.add(NCarroMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 20, -1));

        NMotorMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NMotorMaserati.setText("1");
        jPanel1.add(NMotorMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 20, -1));

        NRuedasMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NRuedasMaserati.setText("1");
        jPanel1.add(NRuedasMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 20, -1));

        Start.setText("Comenzar Simulación");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        jPanel1.add(Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 170, 50));

        Stop.setText("Parar");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });
        jPanel1.add(Stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 90, -1));

        Play.setText("Reanudar");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });
        jPanel1.add(Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 90, 20));

        BEnsamM.setText("-");
        BEnsamM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEnsamMActionPerformed(evt);
            }
        });
        jPanel1.add(BEnsamM, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 50, 20));

        BAcceM.setText("-");
        BAcceM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAcceMActionPerformed(evt);
            }
        });
        jPanel1.add(BAcceM, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 50, 20));

        BChasisB.setText("-");
        BChasisB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BChasisBActionPerformed(evt);
            }
        });
        jPanel1.add(BChasisB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 50, 20));

        BCarroB.setText("-");
        BCarroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCarroBActionPerformed(evt);
            }
        });
        jPanel1.add(BCarroB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 50, 20));

        SCarroB.setText("+");
        SCarroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SCarroBActionPerformed(evt);
            }
        });
        jPanel1.add(SCarroB, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 50, 20));

        SMotorB.setText("+");
        SMotorB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMotorBActionPerformed(evt);
            }
        });
        jPanel1.add(SMotorB, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 50, 20));

        BMotorB.setText("-");
        BMotorB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMotorBActionPerformed(evt);
            }
        });
        jPanel1.add(BMotorB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 50, 20));

        SRuedasB.setText("+");
        SRuedasB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SRuedasBActionPerformed(evt);
            }
        });
        jPanel1.add(SRuedasB, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 50, 20));

        BRuedasB.setText("-");
        BRuedasB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRuedasBActionPerformed(evt);
            }
        });
        jPanel1.add(BRuedasB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 50, 20));

        SEnsamM.setText("+");
        SEnsamM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEnsamMActionPerformed(evt);
            }
        });
        jPanel1.add(SEnsamM, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 50, 20));

        SChasisB.setText("+");
        SChasisB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SChasisBActionPerformed(evt);
            }
        });
        jPanel1.add(SChasisB, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 50, 20));

        SChasisM.setText("+");
        SChasisM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SChasisMActionPerformed(evt);
            }
        });
        jPanel1.add(SChasisM, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 50, 20));

        BChasisM.setText("-");
        BChasisM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BChasisMActionPerformed(evt);
            }
        });
        jPanel1.add(BChasisM, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 50, 20));

        SCarroM.setText("+");
        SCarroM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SCarroMActionPerformed(evt);
            }
        });
        jPanel1.add(SCarroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 50, 20));

        BCarroM.setText("-");
        BCarroM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCarroMActionPerformed(evt);
            }
        });
        jPanel1.add(BCarroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 50, 20));

        SMotorM.setText("+");
        SMotorM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMotorMActionPerformed(evt);
            }
        });
        jPanel1.add(SMotorM, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, 50, 20));

        BMotorM.setText("-");
        BMotorM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMotorMActionPerformed(evt);
            }
        });
        jPanel1.add(BMotorM, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 50, 20));

        SRuedasM.setText("+");
        SRuedasM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SRuedasMActionPerformed(evt);
            }
        });
        jPanel1.add(SRuedasM, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 50, 20));

        BRuedasM.setText("-");
        BRuedasM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRuedasMActionPerformed(evt);
            }
        });
        jPanel1.add(BRuedasM, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 50, 20));

        SAcceM.setText("+");
        SAcceM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAcceMActionPerformed(evt);
            }
        });
        jPanel1.add(SAcceM, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 50, 20));

        jLabel23.setText("Creadores de accesorios:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 150, -1));

        NAcceBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NAcceBugatti.setText("1");
        jPanel1.add(NAcceBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 20, -1));

        SAcceB.setText("+");
        SAcceB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAcceBActionPerformed(evt);
            }
        });
        jPanel1.add(SAcceB, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 50, 20));

        BAcceB.setText("-");
        BAcceB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAcceBActionPerformed(evt);
            }
        });
        jPanel1.add(BAcceB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 50, 20));

        jLabel24.setText("Ensambladores:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 110, -1));

        NEnsamB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NEnsamB.setText("1");
        jPanel1.add(NEnsamB, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 20, -1));

        SEnsamB.setText("+");
        SEnsamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEnsamBActionPerformed(evt);
            }
        });
        jPanel1.add(SEnsamB, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 50, 20));

        BEnsamB.setText("-");
        BEnsamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEnsamBActionPerformed(evt);
            }
        });
        jPanel1.add(BEnsamB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 50, 20));

        jLabel28.setText("Duración del día (en ms):");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 150, -1));
        jPanel1.add(dayDurationSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 100, -1));

        jLabel27.setText("Deadline:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));
        jPanel1.add(MaseratiDeadlineSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 80, -1));

        jLabel29.setText("Deadline:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));
        jPanel1.add(BugattiDeadlineSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 80, -1));

        jTabbedPane1.addTab("Configuración", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BugattiLogo.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 240, 120));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MaseratiLogo.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 160));

        jLabel14.setText("Almacén");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));

        jLabel15.setText("Accesorios:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 80, -1));

        jLabel16.setText("Max:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 40, -1));

        jLabel17.setText("Carrocería:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 70, -1));

        jLabel25.setText("Day Count:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 60, -1));

        jLabel26.setText("Ruedas:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 80, -1));

        accesBCounterLabel.setText("0");
        jPanel2.add(accesBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 20, -1));

        carroBCounterLabel.setText("0");
        jPanel2.add(carroBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 20, -1));

        motorBCounterLabel.setText("0");
        jPanel2.add(motorBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 20, -1));

        ruedasBCounterLabel.setText("0");
        jPanel2.add(ruedasBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 20, -1));

        jLabel32.setText("Chasis:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 60, -1));

        jLabel33.setText("Max:");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 40, -1));

        jLabel34.setText("Max:");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 40, -1));

        jLabel35.setText("Max:");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 40, -1));

        jLabel36.setText("Max:");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 40, -1));

        carroMCounterLabel.setText("0");
        jPanel2.add(carroMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 20, -1));

        jLabel38.setText("25");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 20, -1));

        jLabel39.setText("20");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 20, -1));

        jLabel40.setText("55");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 20, -1));

        dayCount.setText("0");
        jPanel2.add(dayCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 20, -1));

        MaUtility.setText("0");
        jPanel2.add(MaUtility, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 80, -1));

        jLabel44.setText("Utilidad total:");
        jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, -1, -1));

        jLabel45.setText("10");
        jPanel2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 20, -1));

        MaTimeUntilDeadline.setText("0");
        jPanel2.add(MaTimeUntilDeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 20, -1));

        jLabel47.setText("Vehículo con accesorios:");
        jPanel2.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, -1, -1));

        specialVehicleBCounterLabel.setText("0");
        jPanel2.add(specialVehicleBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 20, -1));

        jLabel49.setText("Días para la entrega:");
        jPanel2.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, -1, -1));

        jLabel50.setText("Dinero descontado: ");
        jPanel2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, -1, -1));

        directorStateMLabel.setText("Algo");
        jPanel2.add(directorStateMLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 140, -1));

        managerStateMLabel.setText("Algo");
        jPanel2.add(managerStateMLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 100, -1));

        jLabel53.setText("Gerente de operaciones:");
        jPanel2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));

        jLabel54.setText("Faltas:");
        jPanel2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, -1, -1));

        BuTimeUntilDeadline.setText("0");
        jPanel2.add(BuTimeUntilDeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 20, -1));

        MaFaltas.setText("0");
        jPanel2.add(MaFaltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 90, -1));

        jLabel57.setText("Vehículo estándar:");
        jPanel2.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, -1, -1));

        jLabel58.setText("35");
        jPanel2.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 20, -1));

        jLabel59.setText("Ganancia en Bruto:");
        jPanel2.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, -1, -1));

        MaWinnings.setText("0");
        jPanel2.add(MaWinnings, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 80, -1));

        jLabel61.setText("Costro operativo:");
        jPanel2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, -1, -1));

        MaCosts.setText("0");
        jPanel2.add(MaCosts, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, 80, -1));

        jLabel63.setText("Almacén");
        jPanel2.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel64.setText("Chasis:");
        jPanel2.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 80, -1));

        chasisBCounterLabel.setText("0");
        jPanel2.add(chasisBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 20, -1));

        jLabel66.setText("Carrocería:");
        jPanel2.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 80, -1));

        jLabel67.setText("Motor:");
        jPanel2.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 80, -1));

        jLabel68.setText("Ruedas:");
        jPanel2.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 80, -1));

        jLabel70.setText("Accesorios:");
        jPanel2.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 80, -1));

        jLabel69.setText("10");
        jPanel2.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 20, -1));

        accesMCounterLabel.setText("0");
        jPanel2.add(accesMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 20, -1));

        motorMCounterLabel.setText("0");
        jPanel2.add(motorMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 20, -1));

        ruedasMCounterLabel.setText("0");
        jPanel2.add(ruedasMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 20, -1));

        jLabel74.setText("Max:");
        jPanel2.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 40, -1));

        jLabel75.setText("Max:");
        jPanel2.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 40, -1));

        jLabel76.setText("Max:");
        jPanel2.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 40, -1));

        jLabel77.setText("Max:");
        jPanel2.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 40, -1));

        jLabel78.setText("Max:");
        jPanel2.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 40, -1));

        chasisMCounterLabel.setText("0");
        jPanel2.add(chasisMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 20, -1));

        jLabel80.setText("25");
        jPanel2.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 20, -1));

        jLabel81.setText("20");
        jPanel2.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 20, -1));

        jLabel82.setText("55");
        jPanel2.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 20, -1));

        jLabel83.setText("35");
        jPanel2.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 20, -1));

        jLabel84.setText("Vehículos estándar:");
        jPanel2.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel85.setText("Vehículos con accesorios:");
        jPanel2.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel86.setText("Días para la entrega:");
        jPanel2.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        standardVehicleBCounterLabel.setText("0");
        jPanel2.add(standardVehicleBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 20, -1));

        standardVehicleMCounterLabel.setText("0");
        jPanel2.add(standardVehicleMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 20, -1));

        specialVehicleMCounterLabel.setText("0");
        jPanel2.add(specialVehicleMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 20, -1));

        jLabel90.setText("Gerente de operaciones:");
        jPanel2.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel91.setText("Faltas:");
        jPanel2.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel92.setText("Dinero descontado: ");
        jPanel2.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel93.setText("Director de la planta:");
        jPanel2.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        managerStateBLabel.setText("Algo");
        jPanel2.add(managerStateBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 130, -1));

        BuFaltas.setText("0");
        jPanel2.add(BuFaltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 70, -1));

        BuPenalty.setText("0");
        jPanel2.add(BuPenalty, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 70, -1));

        directorStateBLabel.setText("Algo");
        jPanel2.add(directorStateBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 140, -1));

        jLabel98.setText("Ganancia en Bruto:");
        jPanel2.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        BuWinnings.setText("0");
        jPanel2.add(BuWinnings, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 90, -1));

        jLabel100.setText("Costro operativo:");
        jPanel2.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        BuCosts.setText("0");
        jPanel2.add(BuCosts, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 90, -1));

        jLabel102.setText("Utilidad total:");
        jPanel2.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        BuUtility.setText("0");
        jPanel2.add(BuUtility, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 90, -1));

        Stop2.setText("Parar");
        Stop2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stop2ActionPerformed(evt);
            }
        });
        jPanel2.add(Stop2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 90, -1));

        Play1.setText("Reanudar");
        Play1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Play1ActionPerformed(evt);
            }
        });
        jPanel2.add(Play1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 90, -1));

        jLabel106.setText("Bugatti");
        jPanel2.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabel107.setText("Maserati");
        jPanel2.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, -1));

        jLabel46.setText("Director de la planta:");
        jPanel2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, -1, -1));

        MaPenalty.setText("0");
        jPanel2.add(MaPenalty, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 90, -1));

        jLabel30.setText("Motor:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 80, -1));

        jTabbedPane1.addTab("Simulación", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BugattiLogo.png"))); // NOI18N
        jPanel3.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 240, 120));

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MaseratiLogo.png"))); // NOI18N
        jPanel3.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 160));

        Stop1.setText("Parar");
        Stop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stop1ActionPerformed(evt);
            }
        });
        jPanel3.add(Stop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 90, -1));

        Play2.setText("Reanudar");
        Play2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Play2ActionPerformed(evt);
            }
        });
        jPanel3.add(Play2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 90, -1));

        jLabel108.setText("Bugatti");
        jPanel3.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabel109.setText("Maserati");
        jPanel3.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, -1));

        jTabbedPane1.addTab("    Gráficos   ", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        dayDurationInMs = (int) dayDurationSpinner.getValue();
        BugattiDeadlineInDays = (int) BugattiDeadlineSpinner.getValue();
        
        BugattiStartArray[0] = chasisB;
        BugattiStartArray[1] = carroB;
        BugattiStartArray[2] = motorB;
        BugattiStartArray[3] = ruedasB;
        BugattiStartArray[4] = acceB;
        BugattiStartArray[5] = ensamB;

        BuVehiclePlant = new VehiclePlant("Bugatti", 15, dayDurationInMs, BugattiStartArray, BugattiProductionArray, BugattiAssemblyNeeds, BugattiPricesArray, BugattiDeadlineInDays);
        
        MaseratiDeadlineInDays = (int) MaseratiDeadlineSpinner.getValue();
        
        MaseratiStartArray[0] = chasisM;
        MaseratiStartArray[1] = carroM;
        MaseratiStartArray[2] = motorM;
        MaseratiStartArray[3] = ruedasM;
        MaseratiStartArray[4] = acceM;
        MaseratiStartArray[5] = ensamM;

        MaVehiclePlant = new VehiclePlant("Maserati", 17, dayDurationInMs, MaseratiStartArray, MaseratiProductionArray, MaseratiAssemblyNeeds, BugattiPricesArray, MaseratiDeadlineInDays);
        startTimer();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_StartActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        Global.play = false;
    }//GEN-LAST:event_StopActionPerformed

    private void SChasisBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SChasisBActionPerformed
        
        if(func.checkWorkers(chasisB, carroB, motorB, ruedasB, acceB, maxB, ensamB)) {
            chasisB += 1;
            NChasisBugatti.setText(Integer.toString(chasisB));
        }
        
    }//GEN-LAST:event_SChasisBActionPerformed

    private void SCarroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SCarroBActionPerformed

        if(func.checkWorkers(chasisB, carroB, motorB, ruedasB, acceB, maxB, ensamB)) {
            carroB += 1;
            NCarroBugatti.setText(Integer.toString(carroB));
        }
    }//GEN-LAST:event_SCarroBActionPerformed

    private void SMotorBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMotorBActionPerformed
        if(func.checkWorkers(chasisB, carroB, motorB, ruedasB, acceB, maxB, ensamB)) {
            motorB += 1;
            NMotorBugatti.setText(Integer.toString(carroB));
        }
    }//GEN-LAST:event_SMotorBActionPerformed

    private void SRuedasBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SRuedasBActionPerformed
        if(func.checkWorkers(chasisB, carroB, motorB, ruedasB, acceB, maxB, ensamB)) {
            ruedasB += 1;
            NRuedasBugatti.setText(Integer.toString(ruedasB));
        }
    }//GEN-LAST:event_SRuedasBActionPerformed

    private void SEnsamMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEnsamMActionPerformed
        if(func.checkWorkers(chasisM, carroM, motorM, ruedasM, acceM, maxM, ensamM)) {
            ensamM += 1;
            NEnsamM.setText(Integer.toString(ensamM));
        }
    }//GEN-LAST:event_SEnsamMActionPerformed

    private void SChasisMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SChasisMActionPerformed
        if(func.checkWorkers(chasisM, carroM, motorM, ruedasM, acceM, maxM, ensamM)) {
            chasisM += 1;
            NChasisMaserati.setText(Integer.toString(chasisM));
        }
    }//GEN-LAST:event_SChasisMActionPerformed

    private void SCarroMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SCarroMActionPerformed
        if(func.checkWorkers(chasisM, carroM, motorM, ruedasM, acceM, maxM, ensamM)) {
            carroM += 1;
            NCarroMaserati.setText(Integer.toString(carroM));
        }
    }//GEN-LAST:event_SCarroMActionPerformed

    private void SMotorMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMotorMActionPerformed
        if(func.checkWorkers(chasisM, carroM, motorM, ruedasM, acceM, maxM, ensamM)) {
            motorM += 1;
            NMotorMaserati.setText(Integer.toString(motorM));
        }
    }//GEN-LAST:event_SMotorMActionPerformed

    private void SRuedasMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SRuedasMActionPerformed
        if(func.checkWorkers(chasisM, carroM, motorM, ruedasM, acceM, maxM, ensamM)) {
            ruedasM += 1;
            NRuedasMaserati.setText(Integer.toString(ruedasM));
        }
    }//GEN-LAST:event_SRuedasMActionPerformed

    private void SAcceMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAcceMActionPerformed
        if(func.checkWorkers(chasisM, carroM, motorM, ruedasM, acceM, maxM, ensamM)) {
            acceM += 1;
            NAcceMaserati.setText(Integer.toString(acceM));
        }
    }//GEN-LAST:event_SAcceMActionPerformed

    private void BChasisBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BChasisBActionPerformed
        if (chasisB == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            chasisB -= 1;
            NChasisBugatti.setText(Integer.toString(chasisB));
        }
    }//GEN-LAST:event_BChasisBActionPerformed

    private void BCarroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCarroBActionPerformed
        if (carroB == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            carroB -= 1;
            NCarroBugatti.setText(Integer.toString(carroB));
        }
    }//GEN-LAST:event_BCarroBActionPerformed

    private void BMotorBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMotorBActionPerformed
        if (motorB == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            motorB -= 1;
            NMotorBugatti.setText(Integer.toString(motorB));
        }
    }//GEN-LAST:event_BMotorBActionPerformed

    private void BRuedasBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRuedasBActionPerformed
        if (ruedasB == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            ruedasB -= 1;
            NRuedasBugatti.setText(Integer.toString(ruedasB));
        }
    }//GEN-LAST:event_BRuedasBActionPerformed

    private void BEnsamMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEnsamMActionPerformed
        if (ensamM == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            ensamM -= 1;
            NEnsamM.setText(Integer.toString(ensamM));
        }
    }//GEN-LAST:event_BEnsamMActionPerformed

    private void BChasisMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BChasisMActionPerformed
        if (chasisM == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            chasisM -= 1;
            NChasisMaserati.setText(Integer.toString(chasisM));
        }
    }//GEN-LAST:event_BChasisMActionPerformed

    private void BCarroMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCarroMActionPerformed
        if (carroM == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            carroM -= 1;
            NCarroMaserati.setText(Integer.toString(carroM));
        }
    }//GEN-LAST:event_BCarroMActionPerformed

    private void BMotorMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMotorMActionPerformed
        if (motorM == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            motorM -= 1;
            NMotorMaserati.setText(Integer.toString(motorM));
        }
    }//GEN-LAST:event_BMotorMActionPerformed

    private void BRuedasMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRuedasMActionPerformed
        if (ruedasM == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            ruedasM -= 1;
            NRuedasMaserati.setText(Integer.toString(ruedasM));
        }
    }//GEN-LAST:event_BRuedasMActionPerformed

    private void BAcceMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAcceMActionPerformed
        if (acceM == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            acceM -= 1;
            NAcceMaserati.setText(Integer.toString(acceM));
        }
    }//GEN-LAST:event_BAcceMActionPerformed

    private void SAcceBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAcceBActionPerformed
        if(func.checkWorkers(chasisB, carroB, motorB, ruedasB, acceB, maxB, ensamB)) {
            acceB += 1;
            NAcceBugatti.setText(Integer.toString(acceB));
        }
    }//GEN-LAST:event_SAcceBActionPerformed

    private void BAcceBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAcceBActionPerformed
        if (acceB == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            acceB -= 1;
            NAcceBugatti.setText(Integer.toString(acceB));
        }
    }//GEN-LAST:event_BAcceBActionPerformed

    private void SEnsamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEnsamBActionPerformed
        if(func.checkWorkers(chasisB, carroB, motorB, ruedasB, acceB, maxB, ensamB)) {
            ensamB += 1;
            NEnsamB.setText(Integer.toString(ensamB));
        }
    }//GEN-LAST:event_SEnsamBActionPerformed

    private void BEnsamBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEnsamBActionPerformed
        if (ensamB == 1) {
            JOptionPane.showMessageDialog(null, "no puede haber menos de 1 trabajador por área");
        } else {
            ensamB -= 1;
            NEnsamB.setText(Integer.toString(ensamB));
        }
    }//GEN-LAST:event_BEnsamBActionPerformed

    private void Stop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stop1ActionPerformed
        Global.play = false;
    }//GEN-LAST:event_Stop1ActionPerformed

    private void Stop2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stop2ActionPerformed
        Global.play = false;
    }//GEN-LAST:event_Stop2ActionPerformed

    private void Play1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Play1ActionPerformed
        Global.play = true;
    }//GEN-LAST:event_Play1ActionPerformed

    private void Play2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Play2ActionPerformed
        Global.play = true;
    }//GEN-LAST:event_Play2ActionPerformed

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        Global.play = true;
    }//GEN-LAST:event_PlayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAcceB;
    private javax.swing.JButton BAcceM;
    private javax.swing.JButton BCarroB;
    private javax.swing.JButton BCarroM;
    private javax.swing.JButton BChasisB;
    private javax.swing.JButton BChasisM;
    private javax.swing.JButton BEnsamB;
    private javax.swing.JButton BEnsamM;
    private javax.swing.JButton BMotorB;
    private javax.swing.JButton BMotorM;
    private javax.swing.JButton BRuedasB;
    private javax.swing.JButton BRuedasM;
    private javax.swing.JLabel BuCosts;
    private javax.swing.JLabel BuFaltas;
    private javax.swing.JLabel BuPenalty;
    private javax.swing.JLabel BuTimeUntilDeadline;
    private javax.swing.JLabel BuUtility;
    private javax.swing.JLabel BuWinnings;
    private javax.swing.JSpinner BugattiDeadlineSpinner;
    private javax.swing.JLabel MaCosts;
    private javax.swing.JLabel MaFaltas;
    private javax.swing.JLabel MaPenalty;
    private javax.swing.JLabel MaTimeUntilDeadline;
    private javax.swing.JLabel MaUtility;
    private javax.swing.JLabel MaWinnings;
    private javax.swing.JSpinner MaseratiDeadlineSpinner;
    private javax.swing.JLabel NAcceBugatti;
    private javax.swing.JLabel NAcceMaserati;
    private javax.swing.JLabel NBugatti;
    private javax.swing.JLabel NCarroBugatti;
    private javax.swing.JLabel NCarroMaserati;
    private javax.swing.JLabel NChasisBugatti;
    private javax.swing.JLabel NChasisMaserati;
    private javax.swing.JLabel NEnsamB;
    private javax.swing.JLabel NEnsamM;
    private javax.swing.JLabel NMaserati;
    private javax.swing.JLabel NMotorBugatti;
    private javax.swing.JLabel NMotorMaserati;
    private javax.swing.JLabel NRuedasBugatti;
    private javax.swing.JLabel NRuedasMaserati;
    private javax.swing.JButton Play;
    private javax.swing.JButton Play1;
    private javax.swing.JButton Play2;
    private javax.swing.JButton SAcceB;
    private javax.swing.JButton SAcceM;
    private javax.swing.JButton SCarroB;
    private javax.swing.JButton SCarroM;
    private javax.swing.JButton SChasisB;
    private javax.swing.JButton SChasisM;
    private javax.swing.JButton SEnsamB;
    private javax.swing.JButton SEnsamM;
    private javax.swing.JButton SMotorB;
    private javax.swing.JButton SMotorM;
    private javax.swing.JButton SRuedasB;
    private javax.swing.JButton SRuedasM;
    private javax.swing.JButton Start;
    private javax.swing.JButton Stop;
    private javax.swing.JButton Stop1;
    private javax.swing.JButton Stop2;
    private javax.swing.JLabel accesBCounterLabel;
    private javax.swing.JLabel accesMCounterLabel;
    private javax.swing.JLabel carroBCounterLabel;
    private javax.swing.JLabel carroMCounterLabel;
    private javax.swing.JLabel chasisBCounterLabel;
    private javax.swing.JLabel chasisMCounterLabel;
    private javax.swing.JLabel dayCount;
    private javax.swing.JSpinner dayDurationSpinner;
    private javax.swing.JLabel directorStateBLabel;
    private javax.swing.JLabel directorStateMLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel managerStateBLabel;
    private javax.swing.JLabel managerStateMLabel;
    private javax.swing.JLabel motorBCounterLabel;
    private javax.swing.JLabel motorMCounterLabel;
    private javax.swing.JLabel ruedasBCounterLabel;
    private javax.swing.JLabel ruedasMCounterLabel;
    private javax.swing.JLabel specialVehicleBCounterLabel;
    private javax.swing.JLabel specialVehicleMCounterLabel;
    private javax.swing.JLabel standardVehicleBCounterLabel;
    private javax.swing.JLabel standardVehicleMCounterLabel;
    // End of variables declaration//GEN-END:variables
}
