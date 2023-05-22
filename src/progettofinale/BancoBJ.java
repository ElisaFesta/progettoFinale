package progettofinale;

import java.util.ArrayList;

/**
 *
 * @author elisa-stefano-diego
 */

class BancoBJ {
    private final int SUP = 16; // Minimo da superare; in caso contrario si estrae una nuova carta
    private final int TOT = 21; // Totale da non superare
    // Memorizza i punti della mano corrente
    private int punti_accumulati = 0;
    // Memorizza le fiches del gioco.
    private int fiches = 200000;

    private ArrayList<CartaBJ> carte_giocate;

    BancoBJ() {
        carte_giocate = new ArrayList<CartaBJ>();
    }

    // Riporta le variabili allo stato iniziale della partita
    void azzera() {
        punti_accumulati = 0;
        fiches = 200000;
        carte_giocate.clear();
    }

    // Ottiene i punti della mano
    int getPuntiMano() {
        return punti_accumulati;
    }
    
    // Ottiene le fiches
    int getFiches() {
        return fiches;
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
    
    void setFiches(int fiches) {
        this.fiches = fiches;
    }
    
    //aggiunge una nuova carta
    void addCartaGiocata(CartaBJ carta) {
        carte_giocate.add(carta);
    }
}
