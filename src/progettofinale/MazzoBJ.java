package progettofinale;

import java.util.*;
import java.awt.*;

/**
 *
 * @author elisa-stefano-diego
 */

public class MazzoBJ {
    private static final String[] semi = {"F","P","Q","C"};
    private static final String[] carta = {"A","K","4","5","6","J","8","9","10","7","Q","3","2"};
    private static LinkedList<CartaBJ> mazzo = new LinkedList<CartaBJ>();

    private MazzoBJ() {}

    public static void mischiaMazzo() 
    {
        for(int i=0; i<semi.length; i++) {
            for(int j=0; j<carta.length; j++) {
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
