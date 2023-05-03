package progettofinale;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author elisa-stefano-diego
 */

public class MazzoBJ 
{
    private ArrayList<CartaBJ> mazzo;
    public MazzoBJ()
    {
        int i,j;
        mazzo=new ArrayList<CartaBJ>();
        for(i=0;i<4;i++)
        {
            for(j=0;j<13;j++)
            {
                if(j==0)
                {
                    CartaBJ carta=new CartaBJ(i,j,11);
                    mazzo.add(carta);
                }
                else if(j>=10)
                {
                    CartaBJ carta=new CartaBJ(i,j,11);
                    mazzo.add(carta); 
                }
                else
                {
                   CartaBJ carta=new CartaBJ(i,j,11);
                   mazzo.add(carta); 
                }
            }
        }
    }
    
    public CartaBJ getCard(int i)
    {
        return mazzo.get(i);
    }
    
    public CartaBJ rimuoviCarta(int i)
    {
        return mazzo.remove(i);
    }
    
    /*public void shuffleDeck()
    {
        Collections.shuffle(mazzo);
    }*/
}
