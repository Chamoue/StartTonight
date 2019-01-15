package universconception.conception.cegepstefoy.restaurantconcept.Data;

import java.util.ArrayList;
import java.util.List;

import universconception.conception.cegepstefoy.restaurantconcept.Model.Commande;
import universconception.conception.cegepstefoy.restaurantconcept.Model.CompteUsager;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Courriel;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Menu;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Mets;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Password;

public class DataBase {

    private static final DataBase instance = new DataBase();
    private  List<CompteUsager> compteUsagers;
    private Commande commande;
    private  Menu menu;
    private CompteUsager currentUser;
    private boolean loggedIn;
    private boolean adminMode;
    private List<Commande> currentOrders;

    private DataBase() {
        //Singleton
        this.compteUsagers = new ArrayList<>();
        this.menu = new Menu();
        this.commande = new Commande();
        this.currentOrders= new ArrayList<>();
    }

    public void addToAcceptedOrdersList(Commande commande) {
        this.currentOrders.add(commande);
    }

    public void removeFromAcceptedOrdersList(Commande commande) {
        this.currentOrders.remove(commande);
    }

    public void clearAcceptedOrderList() {
        this.currentOrders = new ArrayList<>();
    }

    public boolean isAdminModeEnabled() {
        return adminMode;
    }

    public void addAdminAccount() {
        this.addUser(new Courriel("gerant"), new Password("gerant"), "gerant", "gerant");
    }

    public void setCurrentUser(CompteUsager compteUsager) {
        this.currentUser=compteUsager;
        this.loggedIn=true;
        if (compteUsager.getCourriel().getCourriel().equals("gerant")){
            this.adminMode=true;
        }
    }

    public CompteUsager getUser(Courriel courriel){
        for (CompteUsager comptes : this.compteUsagers) {
            if (comptes.getCourriel().getCourriel().equals(courriel.getCourriel())){
                return comptes;
            }
        }
        return null;
    }

    public boolean isUserLoggedIn() {
        return this.loggedIn;
    }

    public void logout() {
        this.loggedIn=false;
        this.currentUser=null;
        this.adminMode=false;
    }

    public List<Commande> getCurrentOrders(){
        return this.currentOrders;
    }

    public void addToOrder(Mets mets) {
        this.commande.addToOrder(mets);
    }

    public void removeFromOrder(Mets mets) {
        this.commande.removeFromOrder(mets);
    }

    public void cancelCurrentOrder() {
        this.commande = new Commande();
    }

    public static DataBase getInstance() {
        if (instance == null) {
            DataBase dataBase = new DataBase();
            dataBase.addAdminAccount();
            return dataBase;
        }
        else {
            return instance;
        }
    }

    public boolean checkIfMailIsInDatabase(Courriel courriel) {
        for (CompteUsager compteUsager : this.compteUsagers) {
            if (compteUsager.getCourriel().getCourriel().equals(courriel.getCourriel())){
                return true;
            }
        }
        return false;
    }

    public void addUser(Courriel courriel, Password password, String adresse, String nom) {
        this.compteUsagers.add(new CompteUsager(courriel,password, adresse, nom));
    }

    public boolean checkLoginInfo(Courriel courriel, Password password) {
        for (CompteUsager compte : compteUsagers){
            if (compte.getCourriel().getCourriel().equals(courriel.getCourriel())) {
                if (compte.getPassword().getPassword().equals(password.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }
}
