package universconception.conception.cegepstefoy.restaurantconcept.Model;

public class CompteUsager {

    private Personne personne;
    private Password password;
    private Courriel courriel;
    private String adresse;
    private String nom;

    public CompteUsager(Courriel courriel, Password password, String adresse, String nom) {
        this.password = password;
        this.courriel = courriel;
        this.adresse = adresse;
        this.nom = nom;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Courriel getCourriel() {
        return courriel;
    }

    public void setCourriel(Courriel courriel) {
        this.courriel = courriel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
