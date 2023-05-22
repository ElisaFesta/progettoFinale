package progettofinale;

import java.awt.*;

/**
 *
 * @author elisa-stefano-diego
 */

public class CartaBJ {
    private String seme;
    private String valore;
    private Color colore;
    
    public CartaBJ(String valore, String seme, Color colore) 
    {
        this.colore = colore;
        this.seme = seme;
        this.valore = valore;
    }

    public String getCarta() 
    {
        return seme;
    }

    public Color getSeme()
    {
        return colore;
    }

    public String getValore() 
    {
        return valore;
    } 
}
