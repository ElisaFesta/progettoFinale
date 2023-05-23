package progettofinale;

/**
 *
 * @author elisa-stefano-diego
 */

public class Utente {

    protected String nome, cognome;

    Utente(String nome) {
        this.nome = nome;
        cognome = "";
    }

    public Utente(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }  
}
