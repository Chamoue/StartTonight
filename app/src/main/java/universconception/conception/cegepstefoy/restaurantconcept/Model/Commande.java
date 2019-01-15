package universconception.conception.cegepstefoy.restaurantconcept.Model;

import java.util.ArrayList;
import java.util.List;


public class Commande {

    private List<Mets> metsCommande;
    private Client client;

    public Commande() {
        this.metsCommande = new ArrayList<>();
        this.client=null;
    }

    public Commande(Client client, List<Mets> order) {
        this.metsCommande = order;
        this.client=client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addToOrder(Mets mets) {
        this.metsCommande.add(mets);
    }

    public  void removeFromOrder(Mets mets) {
        this.metsCommande.remove(mets);
    }

    public List<Mets> getMetsCommande() {
        return metsCommande;
    }

    public void setMetsCommande(List<Mets> metsCommande) {
        this.metsCommande = metsCommande;
    }
}
