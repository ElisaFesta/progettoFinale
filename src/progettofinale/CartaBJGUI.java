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
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
	g2.setPaint(Color.WHITE);
	
	// Disegna il rettangolo dagli angoli 0,0 del JPanel di larghezza W ed altezza H
	Rectangle2D rect = new Rectangle2D.Double(0,0,W,H);
	g2.fill(rect);
	g2.draw(rect);
	
	/*// Seme della carta
	if(carta.getSeme().equals("P")) g2.drawImage(new ImageIcon("img/picche.png").getImage(),12,30,null);
	else if(carta.getSeme().equals("F")) g2.drawImage(new ImageIcon("img/fiori.png").getImage(),12,30,null);
	else if(carta.getSeme().equals("D")) g2.drawImage(new ImageIcon("img/quadri.png").getImage(),12,30,null);
	else if(carta.getSeme().equals("C")) g2.drawImage(new ImageIcon("img/cuori.png").getImage(),12,30,null);
	*/
	g2.setColor(carta.getSeme());
	g2.setFont(new Font("Helvetica",Font.PLAIN,40));
	g2.drawString(carta.getValore(),10,40);
    }
}
