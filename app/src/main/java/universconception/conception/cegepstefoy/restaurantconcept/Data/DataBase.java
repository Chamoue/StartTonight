package universconception.conception.cegepstefoy.restaurantconcept.Data;

import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

import universconception.conception.cegepstefoy.restaurantconcept.Model.Client;
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

    public void addToMenu(Mets mets) {
        this.menu.addToMenu(mets);
    }

    public void removeFromMenu(String nomDuMet) {
        for (Mets met : this.menu.getMenu()) {
            if (met.getNomMet().equals(nomDuMet)) {
                this.menu.removeFromMenu(met);
            }
        }
    }

    public Commande getCommande() {
        return commande;
    }

    public void removeFromAcceptedOrdersList(String courriel) {
        Commande orderToRemove = new Commande();
        for (Commande commande : this.currentOrders) {
            if (commande.getClient().getCourriel().getCourriel().equals(courriel)){
                orderToRemove=commande;
            }
        }
        this.currentOrders.remove(orderToRemove);
    }

    public void addToCurrentOrders(Commande commande) {
        this.currentOrders.add(commande);
    }

    public void clearCurrentUserOrders() {
        this.commande = new Commande();
        this.commande.setUser(this.currentUser);
    }


    public boolean isAdminModeEnabled() {
        return adminMode;
    }

    public void generateBasicAppPrototypeNeeds() {
        generateUsers();
        generateOrders();
        this.commande.setUser(this.currentUser);
    }

    public List<Mets> getMealFromCurrentOrderOf (String courriel) {
        for (Commande commande : this.currentOrders ) {
            if (commande.getClient().getCourriel().getCourriel().equals(courriel)){
                return commande.getMetsCommande();
            }
        }
        return  null;
    }

    private void generateOrders() {
        List<Mets> order = new ArrayList<>();
        order.add(new Mets(1,"Patate", 2,2f,1));
        order.add(new Mets(1,"Pepsi", 2,2f,1));
        order.add(new Mets(1,"Chips", 2,2f,1));
        this.currentOrders.add(new Commande(new Client("Bob","Marcel Leboeuf",new Courriel("unePremiere@commande.ca"),new Password("Check"),"123, Fausse Rue"),order));
        this.currentOrders.add(new Commande(new Client("Serghei","Serghei",new Courriel("uneDeuxieme@commande.ca"),new Password("Check"), "666 De L'enfer"),order));
        this.currentOrders.add(new Commande(new Client("Mikael","Mikael",new Courriel("uneTroisieme@commande.ca"),new Password("Check"),"5123 Blvd Random"),order));
    }

    private void generateUsers() {
        this.addUser(new Courriel("gerant"), new Password("gerant"), "gerant", "gerant");
        this.addUser(new Courriel("mik"), new Password("mik"), "mik", "mik");
    }

    public CompteUsager getCurrentUser() {
        return currentUser;
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
            dataBase.generateBasicAppPrototypeNeeds();
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
