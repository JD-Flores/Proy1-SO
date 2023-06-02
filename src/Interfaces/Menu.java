/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Functions;
import Classes.Global;
import Classes.VehiclePlant;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.ApplicationFrame;


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
    
    int lastDayCount;
    int utilidad;
    
    private XYSeries seriesBu;
    private XYSeries seriesMa;
    
    XYSeriesCollection dataset = new XYSeriesCollection( );
    
    
    
    public void Guardar(){
        func.GuardarDatos(NChasisBugatti.getText(), NCarroBugatti.getText(), NMotorBugatti.getText(), NRuedasBugatti.getText(), NAcceBugatti.getText(), NEnsamB.getText(), Integer.toString((int) BugattiDeadlineSpinner.getValue()), NChasisMaserati.getText(), NCarroMaserati.getText(), NMotorMaserati.getText(), NRuedasMaserati.getText(), NAcceMaserati.getText(), NEnsamM.getText(), Integer.toString((int) MaseratiDeadlineSpinner.getValue()), Integer.toString((int) dayDurationSpinner.getValue()));
    }
    
    
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
        
        seriesBu = new XYSeries("Bugatti");
        seriesMa = new XYSeries("Maserati");
        
        dataset.addSeries(seriesBu);
        dataset.addSeries(seriesMa);

        JFreeChart lineChart = ChartFactory.createXYLineChart("Utilidad con respecto al tiempo", "Tiempo (días)", "Utilidad ($)", dataset);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        jPanel4.removeAll();
        jPanel4.setLayout(new BorderLayout());
        jPanel4.add(chartPanel,BorderLayout.NORTH);

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
                
                BuTimeUntilDeadline.setText(Integer.toString(BugattiDeadlineInDays-BuVehiclePlant.dayCount%BuVehiclePlant.deadlineInDays));
                MaTimeUntilDeadline.setText(Integer.toString(MaseratiDeadlineInDays-MaVehiclePlant.dayCount%MaVehiclePlant.deadlineInDays));    
                
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
    
   private void startTimerGraph() {
       int delay = this.dayDurationInMs;
       ActionListener taskPerformer = new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               
               if (BuVehiclePlant.dayCount==0){
                   lastDayCount = 0;
               }
               if (BuVehiclePlant.dayCount!=lastDayCount){
                   double d = BuVehiclePlant.dayCount;
                    double u1 = BuVehiclePlant.ganancias-BuVehiclePlant.costos;
                    seriesBu.add(d, u1);
                    double u2 = MaVehiclePlant.ganancias-MaVehiclePlant.costos;
                    seriesMa.add(d, u2);
                    repaint();
               };
                            

        
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
        jLabel37 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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
        jLabel46 = new javax.swing.JLabel();
        MaPenalty = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        Stop1 = new javax.swing.JButton();
        Play2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        jLabel5.setText("Numero de trabajadores:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 160, -1));

        NEnsamM.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        NEnsamM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NEnsamM.setText("1");
        jPanel1.add(NEnsamM, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 20, -1));

        jLabel7.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        jLabel7.setText("Creadores de accesorios:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 150, -1));

        jLabel8.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Numero de trabajadores:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 180, -1));

        jLabel9.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        jLabel9.setText("Creadores de chasis:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 140, -1));

        jLabel10.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        jLabel10.setText("Creador de carrocería:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 140, -1));

        jLabel11.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        jLabel11.setText("Creadores de motor: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 140, -1));

        jLabel12.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        jLabel12.setText("Creadores de ruedas:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 140, -1));

        NMaserati.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        NMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NMaserati.setText("17");
        jPanel1.add(NMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 20, -1));

        NAcceMaserati.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        NAcceMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NAcceMaserati.setText("1");
        jPanel1.add(NAcceMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 20, -1));

        NCarroBugatti.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        NCarroBugatti.setForeground(new java.awt.Color(240, 240, 240));
        NCarroBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NCarroBugatti.setText("1");
        jPanel1.add(NCarroBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 20, -1));

        NMotorBugatti.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        NMotorBugatti.setForeground(new java.awt.Color(240, 240, 240));
        NMotorBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NMotorBugatti.setText("1");
        jPanel1.add(NMotorBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 20, -1));

        NRuedasBugatti.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        NRuedasBugatti.setForeground(new java.awt.Color(240, 240, 240));
        NRuedasBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NRuedasBugatti.setText("1");
        jPanel1.add(NRuedasBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 20, -1));

        jLabel18.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("Creadores de chasis:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 150, -1));

        jLabel19.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(240, 240, 240));
        jLabel19.setText("Creador de carrocería:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 150, -1));

        jLabel20.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setText("Creadores de motor: ");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 150, -1));

        jLabel21.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(240, 240, 240));
        jLabel21.setText("Creadores de ruedas:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 150, -1));

        jLabel22.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        jLabel22.setText("Ensambladores:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 120, -1));

        NBugatti.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        NBugatti.setForeground(new java.awt.Color(240, 240, 240));
        NBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NBugatti.setText("15");
        jPanel1.add(NBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 20, -1));

        NChasisBugatti.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        NChasisBugatti.setForeground(new java.awt.Color(240, 240, 240));
        NChasisBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NChasisBugatti.setText("1");
        jPanel1.add(NChasisBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 20, -1));

        NChasisMaserati.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        NChasisMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NChasisMaserati.setText("1");
        jPanel1.add(NChasisMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 20, -1));

        NCarroMaserati.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        NCarroMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NCarroMaserati.setText("1");
        jPanel1.add(NCarroMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 20, -1));

        NMotorMaserati.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        NMotorMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NMotorMaserati.setText("1");
        jPanel1.add(NMotorMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 20, -1));

        NRuedasMaserati.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        NRuedasMaserati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NRuedasMaserati.setText("1");
        jPanel1.add(NRuedasMaserati, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 20, -1));

        Start.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        Start.setForeground(new java.awt.Color(51, 51, 51));
        Start.setText("Comenzar Simulación");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        jPanel1.add(Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 220, 50));

        Stop.setText("Parar");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });
        jPanel1.add(Stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, 90, 20));

        Play.setText("Reanudar");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });
        jPanel1.add(Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 90, 20));

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
        jPanel1.add(BChasisB, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 50, 20));

        BCarroB.setText("-");
        BCarroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCarroBActionPerformed(evt);
            }
        });
        jPanel1.add(BCarroB, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 50, 20));

        SCarroB.setText("+");
        SCarroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SCarroBActionPerformed(evt);
            }
        });
        jPanel1.add(SCarroB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 50, 20));

        SMotorB.setText("+");
        SMotorB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMotorBActionPerformed(evt);
            }
        });
        jPanel1.add(SMotorB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 50, 20));

        BMotorB.setText("-");
        BMotorB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMotorBActionPerformed(evt);
            }
        });
        jPanel1.add(BMotorB, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 50, 20));

        SRuedasB.setText("+");
        SRuedasB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SRuedasBActionPerformed(evt);
            }
        });
        jPanel1.add(SRuedasB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 50, 20));

        BRuedasB.setText("-");
        BRuedasB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRuedasBActionPerformed(evt);
            }
        });
        jPanel1.add(BRuedasB, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 50, 20));

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
        jPanel1.add(SChasisB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 50, 20));

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

        jLabel23.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(240, 240, 240));
        jLabel23.setText("Creadores de accesorios:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 170, -1));

        NAcceBugatti.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        NAcceBugatti.setForeground(new java.awt.Color(240, 240, 240));
        NAcceBugatti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NAcceBugatti.setText("1");
        jPanel1.add(NAcceBugatti, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 20, -1));

        SAcceB.setText("+");
        SAcceB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAcceBActionPerformed(evt);
            }
        });
        jPanel1.add(SAcceB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 50, 20));

        BAcceB.setText("-");
        BAcceB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAcceBActionPerformed(evt);
            }
        });
        jPanel1.add(BAcceB, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 50, 20));

        jLabel24.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(240, 240, 240));
        jLabel24.setText("Ensambladores:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 130, -1));

        NEnsamB.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        NEnsamB.setForeground(new java.awt.Color(240, 240, 240));
        NEnsamB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NEnsamB.setText("1");
        jPanel1.add(NEnsamB, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 20, -1));

        SEnsamB.setText("+");
        SEnsamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEnsamBActionPerformed(evt);
            }
        });
        jPanel1.add(SEnsamB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 50, 20));

        BEnsamB.setText("-");
        BEnsamB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEnsamBActionPerformed(evt);
            }
        });
        jPanel1.add(BEnsamB, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 50, 20));

        jLabel28.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(240, 240, 240));
        jLabel28.setText("Duración del día (en ms):");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 160, -1));
        jPanel1.add(dayDurationSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 100, -1));

        jLabel27.setFont(new java.awt.Font("Eras Bold ITC", 0, 10)); // NOI18N
        jLabel27.setText("Deadline:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 430, 80, -1));
        jPanel1.add(MaseratiDeadlineSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 80, -1));

        jLabel29.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(240, 240, 240));
        jLabel29.setText("Deadline:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 430, 70, -1));
        jPanel1.add(BugattiDeadlineSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 80, -1));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rsz_1bugattilogo.png"))); // NOI18N
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 190, 80));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rsz_1maseratilogo.png"))); // NOI18N
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, -16, 160, 210));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rsz_bugatticar.png"))); // NOI18N
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 310, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rsz_2rsz_rsz_2rsz_1maseraticar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 360, 220));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, -10, 450, 600));

        jPanel5.setBackground(new java.awt.Color(211, 60, 60));
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 440, 600));

        jTabbedPane1.addTab("Configuración", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rsz_1maseratilogo.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 160));

        jLabel14.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel14.setText("Almacén");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 200, 80, -1));

        jLabel15.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel15.setText("Accesorios:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 100, -1));

        jLabel16.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        jLabel16.setText("Max:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 60, -1));

        jLabel17.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel17.setText("Carrocería:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 90, -1));

        jLabel25.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Day Count:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 100, -1));

        jLabel26.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel26.setText("Ruedas:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 100, -1));

        accesBCounterLabel.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        accesBCounterLabel.setForeground(new java.awt.Color(240, 240, 240));
        accesBCounterLabel.setText("0");
        jPanel2.add(accesBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 40, -1));

        carroBCounterLabel.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        carroBCounterLabel.setForeground(new java.awt.Color(240, 240, 240));
        carroBCounterLabel.setText("0");
        jPanel2.add(carroBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 40, -1));

        motorBCounterLabel.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        motorBCounterLabel.setForeground(new java.awt.Color(240, 240, 240));
        motorBCounterLabel.setText("0");
        jPanel2.add(motorBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 40, -1));

        ruedasBCounterLabel.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        ruedasBCounterLabel.setForeground(new java.awt.Color(240, 240, 240));
        ruedasBCounterLabel.setText("0");
        jPanel2.add(ruedasBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 40, -1));

        jLabel32.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel32.setText("Chasis:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 80, -1));

        jLabel33.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel33.setText("Max:");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 60, -1));

        jLabel34.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(240, 240, 240));
        jLabel34.setText("Max:");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 60, -1));

        jLabel35.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(240, 240, 240));
        jLabel35.setText("Max:");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 60, -1));

        jLabel36.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(240, 240, 240));
        jLabel36.setText("Max:");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 60, -1));

        carroMCounterLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        carroMCounterLabel.setText("0");
        jPanel2.add(carroMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 40, -1));

        jLabel38.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(240, 240, 240));
        jLabel38.setText("25");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 40, -1));

        jLabel39.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(240, 240, 240));
        jLabel39.setText("20");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 40, -1));

        jLabel40.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(240, 240, 240));
        jLabel40.setText("55");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 40, -1));

        dayCount.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        dayCount.setText("0");
        jPanel2.add(dayCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 60, -1));

        MaUtility.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        MaUtility.setText("0");
        jPanel2.add(MaUtility, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 90, -1));

        jLabel44.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel44.setText("Utilidad total:");
        jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 310, 110, -1));

        jLabel45.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(240, 240, 240));
        jLabel45.setText("10");
        jPanel2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 40, -1));

        MaTimeUntilDeadline.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        MaTimeUntilDeadline.setText("0");
        jPanel2.add(MaTimeUntilDeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 50, -1));

        jLabel47.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel47.setText("Vehículo con accesorios:");
        jPanel2.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 370, 170, -1));

        specialVehicleBCounterLabel.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        specialVehicleBCounterLabel.setForeground(new java.awt.Color(240, 240, 240));
        specialVehicleBCounterLabel.setText("0");
        jPanel2.add(specialVehicleBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 40, -1));

        jLabel49.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel49.setText("Días para la entrega:");
        jPanel2.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 390, 150, -1));

        jLabel50.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel50.setText("Dinero descontado: ");
        jPanel2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 460, 150, -1));

        directorStateMLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        directorStateMLabel.setText("Algo");
        jPanel2.add(directorStateMLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 480, 170, -1));

        managerStateMLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        managerStateMLabel.setText("Algo");
        jPanel2.add(managerStateMLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 130, -1));

        jLabel53.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel53.setText("Gerente de operaciones:");
        jPanel2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 420, 170, -1));

        jLabel54.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel54.setText("Faltas:");
        jPanel2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 60, -1));

        BuTimeUntilDeadline.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        BuTimeUntilDeadline.setForeground(new java.awt.Color(240, 240, 240));
        BuTimeUntilDeadline.setText("0");
        jPanel2.add(BuTimeUntilDeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 40, -1));

        MaFaltas.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        MaFaltas.setText("0");
        jPanel2.add(MaFaltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 120, -1));

        jLabel57.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel57.setText("Vehículo estándar:");
        jPanel2.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 350, 140, -1));

        jLabel58.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(240, 240, 240));
        jLabel58.setText("35");
        jPanel2.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 40, -1));

        jLabel59.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel59.setText("Ganancia en Bruto:");
        jPanel2.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 250, 140, -1));

        MaWinnings.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        MaWinnings.setText("0");
        jPanel2.add(MaWinnings, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 90, -1));

        jLabel61.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel61.setText("Costro operativo:");
        jPanel2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 280, 130, -1));

        MaCosts.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        MaCosts.setText("0");
        jPanel2.add(MaCosts, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, 90, -1));

        jLabel63.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(240, 240, 240));
        jLabel63.setText("Almacén");
        jPanel2.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 200, 70, -1));

        jLabel64.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(240, 240, 240));
        jLabel64.setText("Chasis:");
        jPanel2.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, -1));

        chasisBCounterLabel.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        chasisBCounterLabel.setForeground(new java.awt.Color(240, 240, 240));
        chasisBCounterLabel.setText("0");
        jPanel2.add(chasisBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 40, -1));

        jLabel66.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(240, 240, 240));
        jLabel66.setText("Carrocería:");
        jPanel2.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 100, -1));

        jLabel67.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(240, 240, 240));
        jLabel67.setText("Motor:");
        jPanel2.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 100, -1));

        jLabel68.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(240, 240, 240));
        jLabel68.setText("Ruedas:");
        jPanel2.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 100, -1));

        jLabel70.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(240, 240, 240));
        jLabel70.setText("Accesorios:");
        jPanel2.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 100, -1));

        jLabel69.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel69.setText("10");
        jPanel2.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 40, -1));

        accesMCounterLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        accesMCounterLabel.setText("0");
        jPanel2.add(accesMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 40, -1));

        motorMCounterLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        motorMCounterLabel.setText("0");
        jPanel2.add(motorMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 40, -1));

        ruedasMCounterLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        ruedasMCounterLabel.setText("0");
        jPanel2.add(ruedasMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 40, -1));

        jLabel74.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(240, 240, 240));
        jLabel74.setText("Max:");
        jPanel2.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 60, -1));

        jLabel75.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel75.setText("Max:");
        jPanel2.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 60, -1));

        jLabel76.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel76.setText("Max:");
        jPanel2.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 60, -1));

        jLabel77.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel77.setText("Max:");
        jPanel2.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 60, -1));

        jLabel78.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel78.setText("Max:");
        jPanel2.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 60, -1));

        chasisMCounterLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        chasisMCounterLabel.setText("0");
        jPanel2.add(chasisMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 40, -1));

        jLabel80.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel80.setText("25");
        jPanel2.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 40, -1));

        jLabel81.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel81.setText("20");
        jPanel2.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 40, -1));

        jLabel82.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel82.setText("55");
        jPanel2.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 40, -1));

        jLabel83.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel83.setText("35");
        jPanel2.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 40, -1));

        jLabel84.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(240, 240, 240));
        jLabel84.setText("Vehículos estándar:");
        jPanel2.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 140, -1));

        jLabel85.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(240, 240, 240));
        jLabel85.setText("Vehículos con accesorios:");
        jPanel2.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 370, 180, -1));

        jLabel86.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(240, 240, 240));
        jLabel86.setText("Días para la entrega:");
        jPanel2.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 390, 150, -1));

        standardVehicleBCounterLabel.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        standardVehicleBCounterLabel.setForeground(new java.awt.Color(240, 240, 240));
        standardVehicleBCounterLabel.setText("0");
        jPanel2.add(standardVehicleBCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 40, -1));

        standardVehicleMCounterLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        standardVehicleMCounterLabel.setText("0");
        jPanel2.add(standardVehicleMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 50, -1));

        specialVehicleMCounterLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        specialVehicleMCounterLabel.setText("0");
        jPanel2.add(specialVehicleMCounterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 50, -1));

        jLabel90.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(240, 240, 240));
        jLabel90.setText("Gerente de operaciones:");
        jPanel2.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 420, 170, -1));

        jLabel91.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(240, 240, 240));
        jLabel91.setText("Faltas:");
        jPanel2.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 440, 60, -1));

        jLabel92.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(240, 240, 240));
        jLabel92.setText("Dinero descontado: ");
        jPanel2.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 460, 140, -1));

        jLabel93.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(240, 240, 240));
        jLabel93.setText("Director de la planta:");
        jPanel2.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 480, 150, -1));

        managerStateBLabel.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        managerStateBLabel.setForeground(new java.awt.Color(240, 240, 240));
        managerStateBLabel.setText("Algo");
        jPanel2.add(managerStateBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 150, -1));

        BuFaltas.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        BuFaltas.setForeground(new java.awt.Color(240, 240, 240));
        BuFaltas.setText("0");
        jPanel2.add(BuFaltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 90, -1));

        BuPenalty.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        BuPenalty.setForeground(new java.awt.Color(240, 240, 240));
        BuPenalty.setText("0");
        jPanel2.add(BuPenalty, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 90, -1));

        directorStateBLabel.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        directorStateBLabel.setForeground(new java.awt.Color(240, 240, 240));
        directorStateBLabel.setText("Algo");
        jPanel2.add(directorStateBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 160, -1));

        jLabel98.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(240, 240, 240));
        jLabel98.setText("Ganancia en Bruto:");
        jPanel2.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 250, 140, -1));

        BuWinnings.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        BuWinnings.setForeground(new java.awt.Color(240, 240, 240));
        BuWinnings.setText("0");
        jPanel2.add(BuWinnings, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 100, -1));

        jLabel100.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(240, 240, 240));
        jLabel100.setText("Costro operativo:");
        jPanel2.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 280, 130, -1));

        BuCosts.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        BuCosts.setForeground(new java.awt.Color(240, 240, 240));
        BuCosts.setText("0");
        jPanel2.add(BuCosts, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 100, -1));

        jLabel102.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(240, 240, 240));
        jLabel102.setText("Utilidad total:");
        jPanel2.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 310, 110, -1));

        BuUtility.setFont(new java.awt.Font("Fugaz One", 0, 12)); // NOI18N
        BuUtility.setForeground(new java.awt.Color(240, 240, 240));
        BuUtility.setText("0");
        jPanel2.add(BuUtility, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 100, -1));

        Stop2.setText("Parar");
        Stop2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stop2ActionPerformed(evt);
            }
        });
        jPanel2.add(Stop2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 100, -1));

        Play1.setText("Reanudar");
        Play1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Play1ActionPerformed(evt);
            }
        });
        jPanel2.add(Play1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 100, -1));

        jLabel46.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel46.setText("Director de la planta:");
        jPanel2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 480, 150, -1));

        MaPenalty.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        MaPenalty.setText("0");
        jPanel2.add(MaPenalty, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, 120, -1));

        jLabel30.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel30.setText("Motor:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 100, -1));

        jPanel9.setBackground(new java.awt.Color(211, 60, 60));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BugattiLogo.png"))); // NOI18N
        jPanel9.add(jLabel42);

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 440, 600));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, -10, 450, 600));

        jTabbedPane1.addTab("Simulación", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 60, 20));
        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 80, 40));

        jPanel13.setBackground(new java.awt.Color(255, 0, 0));
        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 60, 20));
        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 80, 40));

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BugattiLogo.png"))); // NOI18N
        jPanel3.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 240, 120));

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rsz_1maseratilogo.png"))); // NOI18N
        jPanel3.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 200, 160));

        Stop1.setText("Parar");
        Stop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stop1ActionPerformed(evt);
            }
        });
        jPanel3.add(Stop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 100, -1));

        Play2.setText("Reanudar");
        Play2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Play2ActionPerformed(evt);
            }
        });
        jPanel3.add(Play2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 100, -1));
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 720, 320));

        jPanel11.setBackground(new java.awt.Color(211, 60, 60));
        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 440, 600));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, -10, 450, 600));

        jTabbedPane1.addTab("    Gráficos   ", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        
        Global.play = true;
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
        startTimerGraph();
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
            NMotorBugatti.setText(Integer.toString(motorB));
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
