package progettofinale;

/**
 *
 * @author elisa-stefano-diego
 */

import java.util.*;

class GiocatoreBJ {
    // Soldi ad inizio partita
    private final int INITIAL_POT = 2000;
    // Punteggio per (come minimo) pareggiare la partita
    private final int TOTAL = 21;

    // Soldi a disposizione del giocatore
    private int portafoglio;
    // puntata_effettuata si riferisce ai soldi scommessi ad inizio partita
    private int puntata_effettuata = 0;
    // Memorizza i punti totalizzati nella mano corrente
    private int punti_accumulati = 0;

    private ArrayList<CartaBJ> carte_giocate;

    GiocatoreBJ() {
        portafoglio = INITIAL_POT;
        carte_giocate = new ArrayList<CartaBJ>();
    }
    
    // Riporta le variabili allo stato iniziale della partita
    void azzera() {
        puntata_effettuata = 0;
        punti_accumulati = 0;
        portafoglio = INITIAL_POT;
        carte_giocate.clear();
    }
    
    // Riporta le variabili allo stato iniziale della mano
    void azzeraMano() {
        puntata_effettuata = 0;
        punti_accumulati = 0;
        carte_giocate.clear();
    }

    //Ritorna il totale
    int getPortafoglio() {
        return portafoglio;
    }
    
    //restituisce la puntata effettuata
    int getPuntata() {
        return puntata_effettuata;
    }
    

    //restituisce i punti accumulati nella mano corrente
    int getPuntiMano() {
        return punti_accumulati;
    }
    
    //restituisce il numero di carte giocate
    int getNGiocate() {
        return carte_giocate.size();
    }
    
    //Restituisce il valore della carta giocata
    String getValoreCarta(int index) { //index Indice della carta nel mazzo
        return carte_giocate.get(index).getValore();
    }
     
    //Setta i nuovi soldi del giocatore
    void setPortafoglio(int portafoglio) {
        this.portafoglio = portafoglio;
    }
    
    // Setta la nuova puntata
    void setPuntata(int puntata_effettuata) {
        this.puntata_effettuata += puntata_effettuata;
    }
    
    // Setta i punti correnti della mano
    void setPuntiMano(int punti_accumulati) {
        this.punti_accumulati += punti_accumulati;
    }
    
    // Aggiunge una carta giocata
    void addCartaGiocata(CartaBJ carta) {
        carte_giocate.add(carta);
    }
}
