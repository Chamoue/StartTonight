package universconception.conception.cegepstefoy.restaurantconcept.Model;

import java.util.ArrayList;
import java.util.List;


public class Commande {

    private List<Mets> metsCommande;

    public Commande() {
        this.metsCommande = new ArrayList<>();
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
