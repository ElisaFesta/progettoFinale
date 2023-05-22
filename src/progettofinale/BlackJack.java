package progettofinale;

import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author elisa-stefano-diego
 */

public class BlackJack extends javax.swing.JFrame {
    public BlackJack() {
        initComponents();
        setVisible(true);
        setSize(690,430);
        setResizable(false);
        setLocationRelativeTo(null);
        deal.setEnabled(false);
        hit.setEnabled(false);
        stand.setEnabled(false);
        uno.setEnabled(false);
        cinque.setEnabled(false);
        ventiCinque.setEnabled(false);
        cento.setEnabled(false);
        cinqueCento.setEnabled(false);
    }
    
    // Classi utilizzate dal software - non grafiche
    private GiocatoreBJ giocatore = new GiocatoreBJ();
    private BancoBJ banco = new BancoBJ();
    // Memorizzo le carte giocate
    private LinkedList<CartaBJGUI> carte_giocate = new LinkedList<CartaBJGUI>();
    // Posizione carte
    private int x_g=5,y_g=300;
    private int x_b=5,y_b=300;

    private boolean blackJackBanco = false;
    
    // Controllo del BlacjJack
    private void controllaBJ() {
      if((blackJack("G")==true) || (blackJack("B")==true)) {
            if((blackJack("B") && blackJack("G"))) {
                JOptionPane.showMessageDialog(null,"BlackJack di banco e giocatore.");
                nuovaMano();
            }
            else if(!blackJack("B") && blackJack("G")) {	  
                JOptionPane.showMessageDialog(null,"BlackJack!\nHai vinto!");
                punti_giocatore.setText("Punti Giocatore: "+giocatore.getPuntiMano());
                giocatore.setPortafoglio(giocatore.getPortafoglio()+(giocatore.getPuntata()*2)); 
                buttonGame(false);
                nuovaMano();
            }
            else if(blackJack("B") && !blackJack("G")) {
                System.out.println(blackJack("B"));
                JOptionPane.showMessageDialog(null,"BlackJack!\nIl Banco ha vinto!");
                blackJackBanco = true;
                nuovaMano();
            }
        }
    }

    // Controlli per la vittoria
    private void controllaPunti() {
      if((giocatore.getPuntiMano() == 21) && (blackJackBanco==false)) {
            // Vengono contate le carte fino a che il punteggio non è maggiore di 16 a quel punto ci si ferma
            while(banco.getPuntiMano() <= 16) {
                daiCartaBanco();
            }
            // Se il banco supera il numero 21 sballa; il giocatore ha vinto
            if(banco.getPuntiMano() > 21) { 
                JOptionPane.showMessageDialog(null,"Il Banco Sballa"); 
                giocatore.setPortafoglio(giocatore.getPortafoglio()+(giocatore.getPuntata()*2)); 
                nuovaMano();
            }
            // Se il banco ha meno di 21 punti; il giocatore ha vinto
            else if(banco.getPuntiMano() < giocatore.getPuntiMano()) {
                JOptionPane.showMessageDialog(null,"Hai vinto!");
                giocatore.setPortafoglio(giocatore.getPortafoglio()+(giocatore.getPuntata()*2)); 
                nuovaMano();
            }
            // Se banco e giocatore hanno entrambi 21; pareggiano
            else if(banco.getPuntiMano() == giocatore.getPuntiMano()) {
                JOptionPane.showMessageDialog(null,"Pareggio!");
                giocatore.setPortafoglio(giocatore.getPortafoglio()+giocatore.getPuntata()); 
                nuovaMano();
            }
          }
          // Se il giocatore sballa
          else if((giocatore.getPuntiMano() > 21) && (banco.getPuntiMano() <=21)) {
                JOptionPane.showMessageDialog(null,"Hai sballato!");
                nuovaMano();
          }
          // Se il banco sballa
          else if((banco.getPuntiMano() > 21) && (giocatore.getPuntiMano() <= 21)) {
                JOptionPane.showMessageDialog(null,"Il Banco sballa!");
                giocatore.setPortafoglio(giocatore.getPortafoglio()+(giocatore.getPuntata()*2));
                nuovaMano();
          }
          // Se giocatore < banco e banco compreso tra 17 e 21; il banco vince
        else if((giocatore.getPuntiMano() < banco.getPuntiMano()) && (banco.getPuntiMano() <= 21) && (banco.getPuntiMano() >= 17)) {
                JOptionPane.showMessageDialog(null,"Il Banco vince!");
                nuovaMano();
          }
          // Se giocatore > banco e banco compreso tra 17 e 21; giocatore vince.
          else if(giocatore.getPuntiMano() > banco.getPuntiMano() && (banco.getPuntiMano() <= 21) && (banco.getPuntiMano() >= 17)) {
                JOptionPane.showMessageDialog(null,"Hai vinto!");
                giocatore.setPortafoglio(giocatore.getPortafoglio()+(giocatore.getPuntata()*2));
                nuovaMano();
          }
          // banco e giocatore > 21; entranbi hanno sballato
          else if((giocatore.getPuntiMano() > 21) && (banco.getPuntiMano() > 21)) {
                JOptionPane.showMessageDialog(null,"Il Banco ed il Giocatore hanno sballato!");
                giocatore.setPortafoglio(giocatore.getPortafoglio()+giocatore.getPuntata());
                nuovaMano();
          }
          // Banco == giocatore; in cui giocatore diverso da 21 e banco con più di 1 carta giocata
          else if(giocatore.getPuntiMano() == banco.getPuntiMano() && (giocatore.getPuntiMano() != 21) && (banco.getNGiocate() != 1)) {
                JOptionPane.showMessageDialog(null,"Pareggio!");
                giocatore.setPortafoglio(giocatore.getPortafoglio()+giocatore.getPuntata());
                nuovaMano();
          }
    }
    
    // Assegna una carta al banco
    private void daiCartaBanco() {
        CartaBJ c;
	CartaBJGUI cg;
	
	// Ottengo la prima carta del mazo
	c = MazzoBJ.getCarta();
	banco.setPunti(PuntiCarte.getValoreCarta(""+c.getValore()));
	cg = new CartaBJGUI(c);
        
        // Aggiunta della carta al pannello ed ai contenitori
	pannello_carteB.add(cg);
	carte_giocate.add(cg);
	banco.addCartaGiocata(c);
        
	// Setto la posizione della carta sulla finestra
	cg.setBounds(x_b*banco.getNGiocate(),y_b,cg.getWidth(),cg.getHeight());

	punti_banco.setText("Punti Banco: "+banco.getPuntiMano());
	
	// Effettuo una stampa del pannello e lo valido
        pannello_carteB.repaint();
	pannello_carteB.validate();
    }

    private void daiCartaGiocatore() {
        CartaBJ c1;
        CartaBJGUI cg1;

        // Ottengo la prima carta del mazzo
        c1 = MazzoBJ.getCarta();
        giocatore.setPuntiMano(PuntiCarte.getValoreCarta(""+c1.getValore()));
        cg1 = new CartaBJGUI(c1);
        
        // Aggiunta della carta al pannello ed ai contenitori
        pannello_carteG.add(cg1);
        carte_giocate.add(cg1);
        giocatore.addCartaGiocata(c1); 
        
        // Setto la posizione della carta sul pannello
        cg1.setBounds(x_g*giocatore.getNGiocate(),y_g,cg1.getWidth(),cg1.getHeight());

        punti_giocatore.setText("Punti Giocatore: "+giocatore.getPuntiMano());

        // Effettuo una stampa del pannello e lo valido
        pannello_carteG.repaint();
        pannello_carteG.validate();
    }	

    // Viene chiamato ogni volta che inizia una nuova mano
    private void nuovaMano() {
        giocatore.azzeraMano();
        banco.azzera();
        carte_giocate.clear();

        pannello_carteB.removeAll();
        pannello_carteB.repaint();
        pannello_carteB.validate();
        pannello_carteG.removeAll();
        pannello_carteG.repaint();
        pannello_carteG.validate();
        punti_giocatore.setText("Punti giocatore:");
        punti_banco.setText("Punti banco:");

        balance.setText("Saldo: "+giocatore.getPortafoglio()+"$");
        scommessa.setText("Scommessa: "+giocatore.getPuntata()+"$");

        MazzoBJ.mischiaMazzo();

        fichesEnabled(true);
        buttonGame(false);

        blackJackBanco = false;
    }

    private void fichesEnabled(boolean value) {
        uno.setEnabled(value);
        cinque.setEnabled(value);
        ventiCinque.setEnabled(value);
        cento.setEnabled(value);
        cinqueCento.setEnabled(value);
    }

    private void buttonGame(boolean value) {
        stand.setEnabled(value);
        hit.setEnabled(value);
        deal.setEnabled(value);
    }

    // Controllo il black Jack; il parametro passato mi permette di sapere su che oggetto � stato chiamato
    private boolean blackJack(String obj) {
        String val1="";
        String val2="";
        if(("B".equals(obj)) && (banco.getNGiocate() == 2)) {
          val1 = banco.getValoreCarta(0);
          val2 = banco.getValoreCarta(1);
        } 
        else if(("G".equals(obj)) && (giocatore.getNGiocate() == 2)) {
          val1 = giocatore.getValoreCarta(0);
          val2 = giocatore.getValoreCarta(1);
        }
        else {
          return false;
        }
        if(val1.equals("A") && (PuntiCarte.getValoreCarta(val2) == 10)) {
          return true;
        }
        else if(val2.equals("A") && (PuntiCarte.getValoreCarta(val1) == 10)) {
          return true;
        }
        return false;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uno = new javax.swing.JButton();
        cinque = new javax.swing.JButton();
        ventiCinque = new javax.swing.JButton();
        cento = new javax.swing.JButton();
        cinqueCento = new javax.swing.JButton();
        punti_banco = new javax.swing.JLabel();
        punti_giocatore = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        scommessa = new javax.swing.JLabel();
        deal = new javax.swing.JButton();
        hit = new javax.swing.JButton();
        stand = new javax.swing.JButton();
        new_game = new javax.swing.JButton();
        pannello_carteB = new javax.swing.JPanel();
        pannello_carteG = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        uno.setText("1");
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });
        getContentPane().add(uno);
        uno.setBounds(20, 20, 40, 23);

        cinque.setText("5");
        cinque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinqueActionPerformed(evt);
            }
        });
        getContentPane().add(cinque);
        cinque.setBounds(70, 20, 40, 23);

        ventiCinque.setText("25");
        ventiCinque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventiCinqueActionPerformed(evt);
            }
        });
        getContentPane().add(ventiCinque);
        ventiCinque.setBounds(120, 20, 50, 23);

        cento.setText("100");
        cento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centoActionPerformed(evt);
            }
        });
        getContentPane().add(cento);
        cento.setBounds(20, 50, 70, 23);

        cinqueCento.setText("500");
        cinqueCento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinqueCentoActionPerformed(evt);
            }
        });
        getContentPane().add(cinqueCento);
        cinqueCento.setBounds(100, 50, 70, 23);

        punti_banco.setBackground(new java.awt.Color(255, 255, 255));
        punti_banco.setText("Punti banco:");
        punti_banco.setOpaque(true);
        getContentPane().add(punti_banco);
        punti_banco.setBounds(470, 30, 150, 16);

        punti_giocatore.setBackground(new java.awt.Color(255, 255, 255));
        punti_giocatore.setText("Punti giocatore:");
        punti_giocatore.setOpaque(true);
        getContentPane().add(punti_giocatore);
        punti_giocatore.setBounds(470, 50, 150, 16);

        balance.setBackground(new java.awt.Color(255, 255, 255));
        balance.setText("Saldo:");
        balance.setOpaque(true);
        getContentPane().add(balance);
        balance.setBounds(130, 90, 120, 16);

        scommessa.setBackground(new java.awt.Color(255, 255, 255));
        scommessa.setText("Scomessa:");
        scommessa.setOpaque(true);
        getContentPane().add(scommessa);
        scommessa.setBounds(130, 110, 120, 16);

        deal.setText("inizio");
        deal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealActionPerformed(evt);
            }
        });
        getContentPane().add(deal);
        deal.setBounds(40, 330, 70, 23);

        hit.setText("carta");
        hit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitActionPerformed(evt);
            }
        });
        getContentPane().add(hit);
        hit.setBounds(10, 360, 70, 23);

        stand.setText("stai");
        stand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standActionPerformed(evt);
            }
        });
        getContentPane().add(stand);
        stand.setBounds(90, 360, 70, 23);

        new_game.setText("NEW GAME");
        new_game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_gameActionPerformed(evt);
            }
        });
        getContentPane().add(new_game);
        new_game.setBounds(560, 360, 100, 23);

        pannello_carteB.setBackground(new java.awt.Color(0, 102, 51));
        getContentPane().add(pannello_carteB);
        pannello_carteB.setBounds(260, 160, 170, 90);

        pannello_carteG.setBackground(new java.awt.Color(0, 102, 51));
        getContentPane().add(pannello_carteG);
        pannello_carteG.setBounds(260, 250, 170, 110);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/progettofinale/tavoloblackjack1.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 722, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void standActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standActionPerformed
        while(banco.getPuntiMano() <= 16) {
            daiCartaBanco();
            controllaBJ();
        }
        controllaPunti();
        controllaBJ();
    }//GEN-LAST:event_standActionPerformed

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed
        if(giocatore.getPortafoglio() < 1) 
            return;
        deal.setEnabled(true);
        giocatore.setPuntata(1);
        giocatore.setPortafoglio(giocatore.getPortafoglio()-1);
        balance.setText("Saldo: "+giocatore.getPortafoglio()+"$");
        scommessa.setText("Scommessa: "+giocatore.getPuntata()+"$");
    }//GEN-LAST:event_unoActionPerformed

    private void cinqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinqueActionPerformed
        if(giocatore.getPortafoglio() < 5) 
            return;
        deal.setEnabled(true);
        giocatore.setPuntata(5);
        giocatore.setPortafoglio(giocatore.getPortafoglio()-5);
        balance.setText("Saldo: "+giocatore.getPortafoglio()+"$");
        scommessa.setText("Scommessa: "+giocatore.getPuntata()+"$");
    }//GEN-LAST:event_cinqueActionPerformed

    private void ventiCinqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventiCinqueActionPerformed
        if(giocatore.getPortafoglio() < 25) 
            return;
        deal.setEnabled(true);	
        giocatore.setPuntata(25);
        giocatore.setPortafoglio(giocatore.getPortafoglio()-25);
	balance.setText("Saldo: "+giocatore.getPortafoglio()+"$");
        scommessa.setText("Scommessa: "+giocatore.getPuntata()+"$");
    }//GEN-LAST:event_ventiCinqueActionPerformed

    private void centoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_centoActionPerformed
        if(giocatore.getPortafoglio() < 100) 
            return;	
        deal.setEnabled(true);
        giocatore.setPuntata(100);
	giocatore.setPortafoglio(giocatore.getPortafoglio()-100);
	balance.setText("Saldo: "+giocatore.getPortafoglio()+"$");
        scommessa.setText("Scommessa: "+giocatore.getPuntata()+"$");	
    }//GEN-LAST:event_centoActionPerformed

    private void cinqueCentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinqueCentoActionPerformed
        if(giocatore.getPortafoglio() < 500) 
            return;
        deal.setEnabled(true);
	giocatore.setPuntata(500);
	giocatore.setPortafoglio(giocatore.getPortafoglio()-500);
	balance.setText("Saldo: "+giocatore.getPortafoglio()+"$");
        scommessa.setText("Scommessa: "+giocatore.getPuntata()+"$");		
    }//GEN-LAST:event_cinqueCentoActionPerformed

    private void dealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealActionPerformed
        // Disattivo i bottoni delle fiches e il deal
        fichesEnabled(false);
        //attivo hit e stand
        deal.setEnabled(false);
        hit.setEnabled(true);
        stand.setEnabled(true);
        daiCartaGiocatore();
        daiCartaBanco();
    }//GEN-LAST:event_dealActionPerformed

    private void hitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitActionPerformed
        controllaPunti();
        daiCartaGiocatore();
        controllaPunti();
        controllaBJ();
    }//GEN-LAST:event_hitActionPerformed

    private void new_gameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_gameActionPerformed
        // Svuoto le varie collection ed azzero le variabili
        giocatore.azzera();
	banco.azzera();
	carte_giocate.clear();
	
	// Rimuovo gli elementi grafici dal pannello
	pannello_carteB.removeAll();
	pannello_carteB.repaint();
	pannello_carteB.validate();
        pannello_carteG.removeAll();
	pannello_carteG.repaint();
	pannello_carteG.validate();
	
	punti_giocatore.setText("Punti Giocatore: ");
	punti_banco.setText("Punti Banco: ");
	
	balance.setText("Saldo: "+giocatore.getPortafoglio()+"$");
	scommessa.setText("Scommessa: "+giocatore.getPuntata()+"$");
	// Mischio le carte
	MazzoBJ.mischiaMazzo();
	
	fichesEnabled(true);
	buttonGame(false);
	
	blackJackBanco = false;
    }//GEN-LAST:event_new_gameActionPerformed

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
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlackJack().setVisible(true);
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balance;
    private javax.swing.JButton cento;
    private javax.swing.JButton cinque;
    private javax.swing.JButton cinqueCento;
    private javax.swing.JButton deal;
    private javax.swing.JButton hit;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton new_game;
    private javax.swing.JPanel pannello_carteB;
    private javax.swing.JPanel pannello_carteG;
    private javax.swing.JLabel punti_banco;
    private javax.swing.JLabel punti_giocatore;
    private javax.swing.JLabel scommessa;
    private javax.swing.JButton stand;
    private javax.swing.JButton uno;
    private javax.swing.JButton ventiCinque;
    // End of variables declaration//GEN-END:variables
}
