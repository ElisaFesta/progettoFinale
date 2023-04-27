package progettofinale;

/**
 *
 * @author elisa-stefano-diego
 */

public class Carta
{
    int carta;
    int seme;
    int valore;
    
    public Carta()
    {
        carta=0;
        seme=0;
        valore=0;
    }

    public Carta(int carta, int seme, int valore) 
    {
        this.carta = carta;
        this.seme = seme;
        this.valore = valore;
    }

    public int getCarta() 
    {
        return carta;
    }

    public int getSeme()
    {
        return seme;
    }

    public int getValore() 
    {
        return valore;
    }  
}
