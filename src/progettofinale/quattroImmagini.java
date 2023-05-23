/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettofinale;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elisa-stefano-diego
 */
public class QuattroImmagini extends javax.swing.JFrame {

    PrintWriter writer;
    String nome;
    int n_profilo;
    private String data1, data2, data3;

    /**
     * Creates new form Login
     */
    public QuattroImmagini() {

        initComponents();
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        profilo1_button.setVisible(false);
        profilo2_button.setVisible(false);
        profilo3_button.setVisible(false);
        boolean[] profili = {false, false, false};
        int i = 0;
        try {
            File myObj = new File("startup.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data != null) {
                    profili[i] = true;

                    i++;
                }
                if (i == 1) {

                    profilo1_button.setVisible(true);
                    profilo1_button.setText(data);

                }
                if (i == 2) {

                    profilo2_button.setVisible(true);
                    profilo2_button.setText(data);

                }
                if (i == 3) {

                    profilo3_button.setVisible(true);
                    profilo3_button.setText(data);
                    jButton1.setVisible(false);

                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    ////////////////////////////////////////////separatore////////////////////////////////////////////
    public QuattroImmagini(int value) {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        profilo1_button.setVisible(false);
        profilo2_button.setVisible(false);
        profilo3_button.setVisible(false);
        boolean[] profili = {false, false, false};

        try {
            File myObj = new File("startup.txt");
            Scanner myReader = new Scanner(myObj);

            if (value == 1) {
                if (myReader.hasNextLine()) {
                    data3 = myReader.nextLine();
                    System.out.println(data3);
                }
                if (myReader.hasNextLine()) {
                    data1 = myReader.nextLine();
                    System.out.println(data1);
                }
                if (myReader.hasNextLine()) {
                    data2 = myReader.nextLine();
                }
            } else if (value == 2) {
                if (myReader.hasNextLine()) {
                    data1 = myReader.nextLine();
                }
                if (myReader.hasNextLine()) {
                    data3 = myReader.nextLine();
                }
                if (myReader.hasNextLine()) {
                    data2 = myReader.nextLine();
                }

            } else {
                if (myReader.hasNextLine()) {
                    data1 = myReader.nextLine();
                }
                if (myReader.hasNextLine()) {
                    data2 = myReader.nextLine();
                }

            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();

        try {
            writer = new PrintWriter("startup.txt");
            writer.print("");
            writer.close();

            System.out.println("stampa eseguita correttamente");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("startup.txt");

            Scanner myReader = new Scanner(myObj);

            if (data1 != null) {
                stringBuilder.append(data1);
                System.out.println("la stampa va : " + data1);
                stringBuilder.append("\n");
            }

            if (data2 != null) {
                stringBuilder.append(data2);
                stringBuilder.append("\n");

            }
            myReader.close();

        } catch (FileNotFoundException e) {

            System.out.println("An error occurred.");

            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("startup.txt");

            myWriter.write(stringBuilder.toString());

            myWriter.close();

            System.out.println("Scrittura avvenuta con successo");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        /* try {
              writer = new PrintWriter(new BufferedWriter(new FileWriter("startup.txt", true)));
            writer.print(data2);
            writer.close();
            
            System.out.println("stampa eseguita correttamente");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/
        int i = 0;
        try {
            File myObj = new File("startup.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data != null) {
                    profili[i] = true;

                    i++;
                }
                if (i == 1) {

                    profilo1_button.setVisible(true);
                    profilo1_button.setText(data);

                }
                if (i == 2) {

                    profilo2_button.setVisible(true);
                    profilo2_button.setText(data);

                }
                if (i == 3) {

                    profilo3_button.setVisible(true);
                    profilo3_button.setText(data);
                    jButton1.setVisible(false);

                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////separatore////////////////////////////////////////////
    public QuattroImmagini(int value, String nome_nuovo) {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        profilo1_button.setVisible(false);
        profilo2_button.setVisible(false);
        profilo3_button.setVisible(false);
        boolean[] profili = {false, false, false};

        try {
            File myObj = new File("startup.txt");
            Scanner myReader = new Scanner(myObj);

            if (value == 1) {
                if (myReader.hasNextLine()) {
                    data1 = myReader.nextLine();
                    data1 = nome_nuovo;

                }
                if (myReader.hasNextLine()) {
                    data2 = myReader.nextLine();
                    System.out.println(data1);
                }
                if (myReader.hasNextLine()) {
                    data3 = myReader.nextLine();
                }
            } else if (value == 2) {
                if (myReader.hasNextLine()) {
                    data1 = myReader.nextLine();
                }
                if (myReader.hasNextLine()) {
                    data2 = myReader.nextLine();
                    data2 = nome_nuovo;
                }
                if (myReader.hasNextLine()) {
                    data3 = myReader.nextLine();
                }

            } else {
                if (myReader.hasNextLine()) {
                    data1 = myReader.nextLine();
                }
                if (myReader.hasNextLine()) {
                    data2 = myReader.nextLine();
                }

                if (myReader.hasNextLine()) {
                    data3 = myReader.nextLine();
                }
                data3 = nome_nuovo;
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();

        try {
            writer = new PrintWriter("startup.txt");
            writer.print("");
            writer.close();

            System.out.println("stampa eseguita correttamente");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("startup.txt");

            Scanner myReader = new Scanner(myObj);

            if (data1 != null) {
                stringBuilder.append(data1);
                System.out.println("la stampa va : " + data1);
                stringBuilder.append("\n");
            }

            if (data2 != null) {
                stringBuilder.append(data2);
                stringBuilder.append("\n");

            }

            if (data3 != null) {
                stringBuilder.append(data3);
                stringBuilder.append("\n");

            }

            myReader.close();

        } catch (FileNotFoundException e) {

            System.out.println("An error occurred.");

            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("startup.txt");

            myWriter.write(stringBuilder.toString());

            myWriter.close();

            System.out.println("Scrittura avvenuta con successo");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int i = 0;
        try {
            File myObj = new File("startup.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data != null) {
                    profili[i] = true;

                    i++;
                }
                if (i == 1) {

                    profilo1_button.setVisible(true);
                    profilo1_button.setText(data);

                }
                if (i == 2) {

                    profilo2_button.setVisible(true);
                    profilo2_button.setText(data);

                }
                if (i == 3) {

                    profilo3_button.setVisible(true);
                    profilo3_button.setText(data);
                    jButton1.setVisible(false);

                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (value == 1) {
            nome = profilo1_button.getText();
            n_profilo = 1;

            Gioco1 g = new Gioco1(nome, n_profilo);
            g.setVisible(true);
            this.setVisible(false);
        }
        if (value == 2) {
            nome = profilo2_button.getText();
            n_profilo = 2;

            Gioco1 g = new Gioco1(nome, n_profilo);
            g.setVisible(true);
            this.setVisible(false);
        }
        if (value == 3) {
            nome = profilo3_button.getText();
            n_profilo = 3;

            Gioco1 g = new Gioco1(nome, n_profilo);
            g.setVisible(true);
            this.setVisible(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        profilo2 = new javax.swing.JPanel();
        profilo2_button = new javax.swing.JButton();
        profilo1 = new javax.swing.JPanel();
        profilo1_button = new javax.swing.JButton();
        profilo3 = new javax.swing.JPanel();
        profilo3_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        profilo2.setBackground(new java.awt.Color(204, 255, 204));

        profilo2_button.setBackground(new java.awt.Color(0, 153, 255));
        profilo2_button.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        profilo2_button.setForeground(new java.awt.Color(255, 255, 255));
        profilo2_button.setText("profilo2");
        profilo2_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilo2_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilo2Layout = new javax.swing.GroupLayout(profilo2);
        profilo2.setLayout(profilo2Layout);
        profilo2Layout.setHorizontalGroup(
            profilo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profilo2_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );
        profilo2Layout.setVerticalGroup(
            profilo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilo2Layout.createSequentialGroup()
                .addComponent(profilo2_button, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        profilo1.setBackground(new java.awt.Color(204, 255, 204));

        profilo1_button.setBackground(new java.awt.Color(0, 0, 255));
        profilo1_button.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        profilo1_button.setForeground(new java.awt.Color(255, 255, 255));
        profilo1_button.setText("profilo1");
        profilo1_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilo1_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilo1Layout = new javax.swing.GroupLayout(profilo1);
        profilo1.setLayout(profilo1Layout);
        profilo1Layout.setHorizontalGroup(
            profilo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilo1_button, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addGap(56, 56, 56))
        );
        profilo1Layout.setVerticalGroup(
            profilo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilo1Layout.createSequentialGroup()
                .addComponent(profilo1_button, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        profilo3.setBackground(new java.awt.Color(204, 255, 204));

        profilo3_button.setBackground(new java.awt.Color(51, 255, 204));
        profilo3_button.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        profilo3_button.setForeground(new java.awt.Color(255, 255, 255));
        profilo3_button.setText("profilo3");
        profilo3_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilo3_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilo3Layout = new javax.swing.GroupLayout(profilo3);
        profilo3.setLayout(profilo3Layout);
        profilo3Layout.setHorizontalGroup(
            profilo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilo3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(profilo3_button, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        profilo3Layout.setVerticalGroup(
            profilo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilo3Layout.createSequentialGroup()
                .addComponent(profilo3_button, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jButton1.setBackground(new java.awt.Color(48, 51, 107));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AGGIUNGI NUOVO GIOCATORE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progettofinale/reset.jpg"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SELEZIONA IL GIOCATORE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(304, 304, 304))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(profilo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(profilo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(profilo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profilo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profilo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PrintWriter writer;
        try {
            writer = new PrintWriter("startup.txt");
            writer.print("");
            writer.close();
            System.out.println("reset eseguito con successo");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Registrazione r = new Registrazione();
        r.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void profilo1_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilo1_buttonActionPerformed
        nome = profilo1_button.getText();
        n_profilo = 1;

        Gioco1 g = new Gioco1(nome, n_profilo);
        g.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_profilo1_buttonActionPerformed

    private void profilo2_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilo2_buttonActionPerformed
        nome = profilo2_button.getText();
        n_profilo = 2;

        Gioco1 g = new Gioco1(nome, n_profilo);
        g.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_profilo2_buttonActionPerformed

    private void profilo3_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilo3_buttonActionPerformed
        nome = profilo3_button.getText();
        n_profilo = 3;

        Gioco1 g = new Gioco1(nome, n_profilo);
        g.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_profilo3_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(QuattroImmagini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuattroImmagini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuattroImmagini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuattroImmagini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuattroImmagini().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel profilo1;
    private javax.swing.JButton profilo1_button;
    private javax.swing.JPanel profilo2;
    private javax.swing.JButton profilo2_button;
    private javax.swing.JPanel profilo3;
    private javax.swing.JButton profilo3_button;
    // End of variables declaration//GEN-END:variables
}
