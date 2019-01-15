package universconception.conception.cegepstefoy.restaurantconcept.Model;

public class Client extends Personne {


    private Integer clientId;

    private Commande commandeEnCours;


    public Client(String prenom, String nom, Courriel courriel, Password password) {
        super(prenom, nom, courriel, password);
    }


    public Client(String prenom, String nom, Courriel courriel, Password password, Commande commandeEnCours) {
        super(prenom, nom, courriel, password);
        this.commandeEnCours = commandeEnCours;
    }

    public Client(String prenom, String nom, Courriel courriel, Password password, Integer clientId, Commande commandeEnCours) {
        super(prenom, nom, courriel, password);
        this.clientId = clientId;
        this.commandeEnCours = commandeEnCours;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Commande getCommandeEnCours() {
        return commandeEnCours;
    }

    public void setCommandeEnCours(Commande commandeEnCours) {
        this.commandeEnCours = commandeEnCours;
    }
}
