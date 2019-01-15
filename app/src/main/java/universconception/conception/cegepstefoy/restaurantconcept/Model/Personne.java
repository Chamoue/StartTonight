package universconception.conception.cegepstefoy.restaurantconcept.Model;

public class Personne {

    private String prenom;

    private String nom;

    private Courriel courriel;

    private Password password;

    protected Personne(String prenom, String nom, Courriel courriel, Password password) {
        this.prenom = prenom;
        this.nom = nom;
        this.courriel = courriel;
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Courriel getCourriel() {
        return courriel;
    }

    public void setCourriel(Courriel courriel) {
        this.courriel = courriel;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
