package progettofinale;

import java.util.ArrayList;

/**
 *
 * @author elisa-stefano-diego
 */

class BancoBJ {
    private final int SUP = 16; // Minimo da superare; in caso contrario si estrae una nuova carta
    private final int TOT = 21; // Totale da non superare
    private int punti_accumulati = 0; // Memorizza i punti della mano corrente

    private ArrayList<CartaBJ> carte_giocate; //utilizzato per memorizzare le carte distribuite al banco durante le diverse fasi del gioco 

    BancoBJ() {
        carte_giocate = new ArrayList<CartaBJ>();
    }

    // Riporta le variabili allo stato iniziale della partita
    void azzera() {
        punti_accumulati = 0;
        carte_giocate.clear();
    }

    // Ottiene i punti della mano
    int getPuntiMano() {
        return punti_accumulati;
    }
    
    // Restituisce il numero di carte giocate
    int getNGiocate() {
        return carte_giocate.size();
    }
    
    // Restituisce il valore della carta
    String getValoreCarta(int index) {
        return carte_giocate.get(index).getValore();
    }
    
    // Setta i nuovi punti
    void setPunti(int punti_accumulati) {
        this.punti_accumulati += punti_accumulati;
    }
    
    // aggiunge una nuova carta
    void addCartaGiocata(CartaBJ carta) {
        carte_giocate.add(carta);
    }
}
