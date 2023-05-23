package progettofinale;

/**
 *
 * @author elisa-stefano-diego
 */

public class Utente {

    protected String nome, cognome, email;

    Utente(String nome) {
        this.nome = nome;
        cognome = "";
        email = "";
    }

    public Utente(String nome, String cognome, String email){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
