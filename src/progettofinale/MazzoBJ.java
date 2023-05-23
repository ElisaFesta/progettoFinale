package progettofinale;

import java.util.*;
import java.awt.*;

/**
 *
 * @author elisa-stefano-diego
 */

public class MazzoBJ {
    private static final String[] semi = {"F","P","Q","C"}; //valori fissi dei semi
    private static final String[] carta = {"A","K","4","5","6","J","8","9","10","7","Q","3","2"}; //valori fissi di ogni carta
    private static LinkedList<CartaBJ> mazzo = new LinkedList<CartaBJ>(); //array dinamico utilizzato per memorizzare il mazzo

    public static void mischiaMazzo() 
    {
        for(int i=0; i<semi.length; i++) {
            for(int j=0; j<carta.length; j++) {
              //aggiunge una carta al mazzo e se la carta è uguale a Fiori o Picche si colora di nero se no di rosso
              mazzo.add(new CartaBJ(carta[j],semi[i],((semi[i].equals("F")) || (semi[i].equals("P")) ? Color.BLACK : Color.RED)));  
            }
          }
        // Mischia le carte
        Collections.shuffle(mazzo);
    }

    // Ottengo la prima carta del mazzo
    public static CartaBJ getCarta() 
    {
        CartaBJ carta = mazzo.get(0);
        mazzo.remove(carta);
        return carta;
    }
}
