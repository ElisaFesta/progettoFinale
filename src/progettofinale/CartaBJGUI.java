package progettofinale;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *
 * @author elisa-stefano-diego
 */

public class CartaBJGUI extends JPanel {
    private CartaBJ carta;
    private final int W = 50, H = 70;
  
    // parametro Carta
    CartaBJGUI(CartaBJ carta) 
    {
        this.carta = carta;
	// Bordi del pannello della carta
	setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
  
    // Larghezza carta
    public int getWidth() {
      return W;
    }
    // Altezza carta
    public int getHeight() {
      return H;
    }

    // Disegna la carta
    public void paintComponent(Graphics g)
    {
        //Questa riga invoca il metodo paintComponent della classe genitore per assicurarsi che il componente venga disegnato correttamente 
        //prima di eseguire il disegno personalizzato. 
        super.paintComponent(g);
        //crea una nuova variabile g2 di tipo Graphics2D e le assegna il valore del parametro g.
        Graphics2D g2 = (Graphics2D) g; 
	g2.setPaint(Color.WHITE);
	Rectangle2D rettangolo = new Rectangle2D.Double(0,0,W,H); //disegna il rettangolo dagli angoli 0,0 del JPanel di larghezza W ed altezza H
	g2.fill(rettangolo); //riempie la forma rettangolo con il colore corrente impostato in g2
	g2.draw(rettangolo); //disegna il contorno della forma rettangolo utilizzando il colore corrente impostato in g2
	g2.setColor(carta.getSeme());
	g2.setFont(new Font("Helvetica",Font.PLAIN,40));
	g2.drawString(carta.getValore(),10,40); //disegna il valore della carta come una stringa di testo sulla posizione specificata
    }
}
