package progettofinale;

/**
 *
 * @author elisa-stefano-diego
 */

/*import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.System.*;
import java.lang.System.Logger.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;*/

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class GiocoBJ extends JFrame 
{
    ArrayList<CartaBJ> dealerHand;
    ArrayList<CartaBJ> playerHand;
    boolean faceDown = true;
    JButton btnCarta;
    JButton btnStai;
    JButton btnDouble;
    MazzoBJ mazzo;
    JLabel img = new JLabel();
    JLabel img2 = new JLabel();
    JLabel coperta = new JLabel();
    Container c = this.getContentPane();
    JLabel lblsp = new JLabel();
    JLabel lblsd = new JLabel();
    JLabel sal = new JLabel();
    int bet = 0;
    int saldo = 1000;
    int l, k;
    String[] quit = new String[]{"USCITA", "RIGIOCA"};

    GiocoBJ() 
    {
        super("BLACKJACK");
        c.setLayout(null);
        mazzo = new MazzoBJ();
        mazzo.shuffleDeck();
        dealerHand = new ArrayList<CartaBJ>();
        playerHand = new ArrayList<CartaBJ>();
        btnCarta = new JButton("CARTA");
        btnCarta.setBounds(520, 550, 100, 50);
        btnCarta.setBackground(Color.green);
        c.add(btnCarta);
        btnStai = new JButton("STAI");
        btnStai.setBounds(650, 550, 100, 50);
        btnStai.setBackground(Color.red);
        c.add(btnStai);
        btnDouble = new JButton("DOUBLE");
        btnDouble.setBounds(390, 550, 100, 50);
        btnDouble.setBackground(Color.orange);
        c.add(btnDouble);
        img.setIcon(new ImageIcon("immagini/" + "bggame.jpg"));
        img.setBounds(0, 0, 1136, 640);
        img.setHorizontalAlignment(JLabel.CENTER);
        c.add(img);

        setSize(1136, 640);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        setVisible(true);
        setFocusTraversalKeysEnabled(false);
        setLocationRelativeTo(null);
    }

    public void startGiocoBJ() throws IOException {
        String[] options = new String[]{"25", "50", "100", "250", "500"};

        sal.setBounds(70, 480, 120, 70);
        sal.setForeground(Color.white);
        sal.setFont(new Font("", Font.PLAIN, 35));
        sal.setText("" + saldo);
        img.add(sal);
        write(saldo);
        int scelta = JOptionPane.showOptionDialog(null, "Scegliere il valore della puntata!", "PUNTATA", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (scelta == 0) {//scelta della puntata
            bet = 25;
            saldo -= 25;
            sal.setBounds(80, 480, 120, 70);
            sal.setForeground(Color.white);
            sal.setFont(new Font("", Font.PLAIN, 33));
            sal.setText("" + saldo);
            img.add(sal);
            write(saldo);
        } else if (scelta == 1) {
            bet = 50;
            saldo -= 50;
            sal.setBounds(80, 480, 120, 70);
            sal.setForeground(Color.white);
            sal.setFont(new Font("", Font.PLAIN, 33));
            sal.setText("" + saldo);
            img.add(sal);
            write(saldo);
        } else if (scelta == 2) {
            bet = 100;
            saldo -= 100;
            sal.setBounds(80, 480, 120, 70);
            sal.setForeground(Color.white);
            sal.setFont(new Font("", Font.PLAIN, 33));
            sal.setText("" + saldo);
            img.add(sal);
            write(saldo);
        } else if (scelta == 3) {
            bet = 250;
            saldo -= 250;
            sal.setBounds(80, 480, 120, 70);
            sal.setForeground(Color.white);
            sal.setFont(new Font("", Font.PLAIN, 33));
            sal.setText("" + saldo);
            img.add(sal);
            write(saldo);
        } else if (scelta == 4) {
            bet = 500;
            saldo -= 500;
            sal.setBounds(80, 480, 120, 70);
            sal.setForeground(Color.white);
            sal.setFont(new Font("", Font.PLAIN, 33));
            sal.setText("" + saldo);
            img.add(sal);
            write(saldo);
        }
        for (k = 0; k < dealerHand.size(); k++) {//rimuovo le carte presenti nella mano del dealer per una nuova partita (nella prima partita questa istruzione è come se non ci fosse)
            dealerHand.remove(k);
        }
        for (l = 0; l < playerHand.size(); l++) {//rimuovo le carte presenti nella mano del giocatore per una nuova partita (nella prima partita questa istruzione è come se non ci fosse)
            playerHand.remove(l);
        }
        for (int i = 0; i < 2; i++) { //aggiungiamo la 1 e 2 carta del mazzo alla mano del dealer
            dealerHand.add(mazzo.getCarta(i));
            if (i == 0) {
                lblsd.setText("" + somma(dealerHand));
                lblsd.setBounds(470, 55, 90, 70);
                lblsd.setFont(new Font("", Font.PLAIN, 60));
                lblsd.setForeground(Color.white);
                img.add(lblsd);
            }
            coperta.setIcon(new ImageIcon("immagini/" + "coperta.jpg"));
            coperta.setBounds(550, 40, 200, 150);
            img.add(coperta);
        }
        for (int i = 2; i < 4; i++) { //aggiungiamo la 1 e 2 carta del mazzo alla mano del giocatore
            playerHand.add(mazzo.getCarta(i));
            if (i != 2) {
                lblsp.setText("" + somma(playerHand));
                lblsp.setBounds(530, 456, 90, 70);
                lblsp.setFont(new Font("", Font.PLAIN, 60));
                lblsp.setForeground(Color.white);
                img.add(lblsp);
            }
        }
        for (int i = 0; i < 4; i++) { //rimuoviamo le carte aggiunte
            mazzo.rimuoviCarta(0);
        }
        controllo(dealerHand);
        controllo(playerHand);
        btnCarta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aggiungiCarta(playerHand);
                lblsp.setText("" + somma(playerHand));
                lblsp.setBounds(530, 456, 90, 70);
                lblsp.setFont(new Font("", Font.PLAIN, 60));
                lblsp.setForeground(Color.white);
                img.add(lblsp);
                controllo(playerHand);

            }
        });
        btnDouble.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aggiungiCarta(playerHand);
                lblsp.setText("" + somma(playerHand));
                lblsp.setBounds(530, 456, 90, 70);
                lblsp.setFont(new Font("", Font.PLAIN, 60));
                lblsp.setForeground(Color.white);
                img.add(lblsp);
                img.add(lblsp);
                controllo(playerHand);
                if (somma(dealerHand) < 17) {
                    aggiungiCarta(dealerHand);
                    coperta.setVisible(false);
                    lblsd.setText("" + somma(dealerHand));
                    lblsd.setBounds(530, 55, 90, 70);
                    lblsd.setFont(new Font("", Font.PLAIN, 60));
                    lblsd.setForeground(Color.white);
                    img.add(lblsd);
                    controllo(dealerHand);
                }
            }
        });
        btnStai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (somma(dealerHand) < 17) {//finchè la somma delle carte del dealer è minore di 17 bisognerà continuare ad aggiungere carte
                    aggiungiCarta(dealerHand);
                    controllo(dealerHand);
                    coperta.setVisible(false);
                    lblsd.setText("" + somma(dealerHand));
                    lblsd.setBounds(530, 55, 90, 70);
                    lblsd.setFont(new Font("", Font.PLAIN, 60));
                    lblsd.setForeground(Color.white);
                    img.add(lblsd);
                }
                if ((somma(dealerHand) < 21) && somma(playerHand) < 21) {//se ambe due le mani sono minori di 21 bisogna controllare qual'è la più alta
                    if (somma(playerHand) > somma(dealerHand)) {
                        faceDown = false;
                        coperta.setVisible(false);
                        lblsd.setText("" + somma(dealerHand));
                        lblsd.setBounds(530, 55, 90, 70);
                        lblsd.setFont(new Font("", Font.PLAIN, 60));
                        lblsd.setForeground(Color.white);
                        JOptionPane.showMessageDialog(c, "HAI VINTO PERCHE' HAI UN PUNTEGGIO PIU' ALTO RISPETTO AL DEALER");
                        saldo = saldo + bet * 2;
                        sal.setBounds(80, 480, 120, 70);
                        sal.setForeground(Color.white);
                        sal.setFont(new Font("", Font.PLAIN, 33));
                        sal.setText("" + saldo);
                        img.add(sal);

                        try {
                            write(saldo);
                        } catch (IOException ex) {
                            Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (saldo == 0) {
                            System.exit(0);
                        }
                        int scelta = JOptionPane.showOptionDialog(null, "Scegliere cosa si vuole fare!", "SCELTA", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, quit, quit[0]);
                        if (scelta == 0) {
                            System.exit(0);
                        } else {
                            try {
                                startGiocoBJ();
                            } catch (IOException ex) {
                                Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (somma(playerHand) == somma(dealerHand)) {
                        faceDown = false;
                        coperta.setVisible(false);
                        lblsd.setText("" + somma(dealerHand));
                        lblsd.setBounds(530, 55, 90, 70);
                        lblsd.setFont(new Font("", Font.PLAIN, 60));
                        lblsd.setForeground(Color.white);
                        JOptionPane.showMessageDialog(c, "PAREGGIO, ENTRAMBE LE MANI HANNO LO STESSO RISULTATO");

                        saldo = saldo + bet;
                        sal.setBounds(80, 480, 120, 70);
                        sal.setForeground(Color.white);
                        sal.setFont(new Font("", Font.PLAIN, 33));
                        sal.setText("" + saldo);
                        img.add(sal);
                        try {
                            write(saldo);
                        } catch (IOException ex) {
                            Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (saldo == 0) {
                            System.exit(0);
                        }
                        int scelta = JOptionPane.showOptionDialog(null, "Scegliere cosa si vuole fare!", "SCELTA", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, quit, quit[0]);
                        if (scelta == 0) {
                            System.exit(0);
                        } else {
                            try {
                                startGiocoBJ();
                            } catch (IOException ex) {
                                Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {
                        faceDown = false;
                        coperta.setVisible(false);
                        lblsd.setText("" + somma(dealerHand));
                        lblsd.setBounds(530, 55, 90, 70);
                        lblsd.setFont(new Font("", Font.PLAIN, 60));
                        lblsd.setForeground(Color.white);
                        JOptionPane.showMessageDialog(c, "HAI PERSO, IL DEALER HA UN PUNTEGGIO PIU' ALTO RISPETTO AL GIOCATORE");

                        try {
                            write(saldo);
                        } catch (IOException ex) {
                            Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (saldo == 0) {
                            System.exit(0);
                        }
                        int scelta = JOptionPane.showOptionDialog(null, "Scegliere cosa si vuole fare!", "SCELTA", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, quit, quit[0]);
                        if (scelta == 0) {
                            System.exit(0);
                        } else {
                            try {
                                startGiocoBJ();
                            } catch (IOException ex) {
                                Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        });
    }

    public void controllo(ArrayList<CartaBJ> mano) {
        if (mano.equals(playerHand)) {//controlla se è la mano del giocatore e non del dealer
            if (somma(mano) == 21) {//tramite la funzione somma calcola se il giocatore ha blackjack o no
                faceDown = false;
                coperta.setVisible(false);
                lblsd.setText("" + somma(dealerHand));
                lblsd.setBounds(530, 55, 90, 70);
                lblsd.setFont(new Font("", Font.PLAIN, 60));
                lblsd.setForeground(Color.white);
                JOptionPane.showMessageDialog(c, "HAI VINTO, 21 VITTORIA GRANDE BALDORIA");

                saldo = saldo + bet * 2;
                sal.setBounds(80, 480, 120, 70);
                sal.setForeground(Color.white);
                sal.setFont(new Font("", Font.PLAIN, 33));
                sal.setText("" + saldo);
                img.add(sal);
                try {
                    write(saldo);
                } catch (IOException ex) {
                    Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (saldo == 0) {
                    System.exit(0);
                }
                int scelta = JOptionPane.showOptionDialog(null, "Scegliere cosa si vuole fare!", "SCELTA", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, quit, quit[0]);
                if (scelta == 0) {
                    System.exit(0);
                } else {
                    try {
                        startGiocoBJ();
                    } catch (IOException ex) {
                        Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (somma(mano) > 21) {
                faceDown = false;
                coperta.setVisible(false);
                lblsd.setText("" + somma(dealerHand));
                lblsd.setBounds(530, 55, 90, 70);
                lblsd.setFont(new Font("", Font.PLAIN, 60));
                lblsd.setForeground(Color.white);
                JOptionPane.showMessageDialog(c, "HAI SBALLATO, IL TUO PUNTEGGIO SUPERA IL 21 ");
                try {
                    write(saldo);
                } catch (IOException ex) {
                    Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (saldo == 0) {
                    System.exit(0);
                }
                int scelta = JOptionPane.showOptionDialog(null, "Scegliere cosa si vuole fare!", "SCELTA", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, quit, quit[0]);
                if (scelta == 0) {
                    System.exit(0);
                } else {
                    try {
                        startGiocoBJ();
                    } catch (IOException ex) {
                        Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {//controllo mano dealer
            if (somma(mano) == 21) {//tramite la funzione somma calcola se il giocatore ha blackjack o no
                coperta.setVisible(false);
                lblsd.setText("" + somma(dealerHand));
                lblsd.setBounds(530, 55, 90, 70);
                lblsd.setFont(new Font("", Font.PLAIN, 60));
                lblsd.setForeground(Color.white);
                faceDown = false;
                JOptionPane.showMessageDialog(c, "HAI PERSO, IL DEALER HA FATTO 21");
                try {
                    write(saldo);
                } catch (IOException ex) {
                    Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (saldo == 0) {
                    System.exit(0);
                }
                int scelta = JOptionPane.showOptionDialog(null, "Scegliere cosa si vuole fare!", "SCELTA", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, quit, quit[0]);
                if (scelta == 0) {
                    System.exit(0);
                } else {
                    try {
                        startGiocoBJ();
                    } catch (IOException ex) {
                        Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (somma(mano) > 21) {
                coperta.setVisible(false);
                lblsd.setText("" + somma(dealerHand));
                lblsd.setBounds(530, 55, 90, 70);
                lblsd.setFont(new Font("", Font.PLAIN, 60));
                lblsd.setForeground(Color.white);
                faceDown = false;
                JOptionPane.showMessageDialog(c, "HAI VINTO, IL DEALER HA SBALLATO, IL SUO PUNTEGGIO SUPERA IL 21 ");
                saldo = saldo + bet * 2;
                sal.setBounds(80, 480, 120, 70);
                sal.setForeground(Color.white);
                sal.setFont(new Font("", Font.PLAIN, 33));
                sal.setText("" + saldo);
                img.add(sal);
                try {
                    write(saldo);
                } catch (IOException ex) {
                    Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (saldo == 0) {
                    System.exit(0);
                }
                int scelta = JOptionPane.showOptionDialog(null, "Scegliere cosa si vuole fare!", "SCELTA", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, quit, quit[0]);
                if (scelta == 0) {
                    System.exit(0);
                } else {
                    try {
                        startGiocoBJ();
                    } catch (IOException ex) {
                        Logger.getLogger(GiocoBJ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public int somma(ArrayList<CartaBJ> mano) {
        int somma = 0;
        for (int i = 0; i < mano.size(); i++) {
            if (mano.get(i).getValore() == 11) {
                for (i = 0; i < mano.size(); i++) {
                    somma = somma + mano.get(i).getValore();
                }
            } else {
                for (i = 0; i < mano.size(); i++) {
                    somma = somma + mano.get(i).getValore();
                }
            }
        }
        System.out.println(somma);
        return somma;
    }

    public void aggiungiCarta(ArrayList<CartaBJ> mano) {
        mano.add(mazzo.getCarta(0)); //prende la carta
        mazzo.rimuoviCarta(0); //rimuove la carta aggiunta dal mazzo
        faceDown = true;
    }

    public void write(int saldo) throws FileNotFoundException, IOException {
        FileOutputStream f = new FileOutputStream("Bilancio.dat");
        ObjectOutputStream fOut = new ObjectOutputStream(f);
        try {
            fOut.writeObject(saldo);
        } catch (EOFException ex) {
        }
        fOut.flush();
        f.close();
    } 
}
