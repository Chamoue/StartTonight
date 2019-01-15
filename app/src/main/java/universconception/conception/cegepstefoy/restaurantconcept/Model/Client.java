package universconception.conception.cegepstefoy.restaurantconcept.Model;

public class Client extends Personne {
    private String adresse;
    public Client(String prenom, String nom, Courriel courriel, Password password, String adresse) {
        super(prenom, nom, courriel, password);
        this.adresse=adresse;
    }

    public String getAdresse() {
        return adresse;
    }
}

