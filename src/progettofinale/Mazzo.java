package progettofinale;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author elisa-stefano-diego
 */

public class Mazzo 
{
    private ArrayList<Carta> mazzo;
    public Mazzo()
    {
        int i,j;
        mazzo=new ArrayList<Carta>();
        for(i=0;i<4;i++)
        {
            for(j=0;j<13;j++)
            {
                if(j==0)
                {
                    Carta carta=new Carta(i,j,11);
                    mazzo.add(carta);
                }
                else if(j>=10)
                {
                    Carta carta=new Carta(i,j,11);
                    mazzo.add(carta); 
                }
                else
                {
                   Carta carta=new Carta(i,j,11);
                   mazzo.add(carta); 
                }
            }
        }
    }
    
    public Carta getCard(int i)
    {
        return mazzo.get(i);
    }
    
    public Carta rimuoviCarta(int i)
    {
        return mazzo.remove(i);
    }
    
    public void shuffleDeck()
    {
        Collections.shuffle(mazzo);
    }
}
