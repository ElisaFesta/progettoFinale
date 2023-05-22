package progettofinale;

import java.util.*;

/**
 *
 * @author elisa-stefano-diego
 */

class PuntiCarte {
    private static LinkedHashMap<String,Integer> punti = new LinkedHashMap<String,Integer>();
    private PuntiCarte() {}
    
    static 
    {
        punti.put("2",2);
        punti.put("3",3);
        punti.put("4",4);
        punti.put("5",5);
        punti.put("6",6);
        punti.put("7",7);
        punti.put("8",8);
        punti.put("9",9);
        punti.put("10",10);
        punti.put("A",1);
        punti.put("J",10);
        punti.put("Q",10);
        punti.put("K",10);
    }
    
    public static int getValoreCarta(String key) {
        return punti.get(key);
    }
}