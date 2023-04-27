package progettofinale;

/**
 *
 * @author elisa-stefano-diego
 */

public class CartaBJ
{
    int carta;
    int seme;
    int valore;
    
    public CartaBJ()
    {
        carta=0;
        seme=0;
        valore=0;
    }

    public CartaBJ(int carta, int seme, int valore) 
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
