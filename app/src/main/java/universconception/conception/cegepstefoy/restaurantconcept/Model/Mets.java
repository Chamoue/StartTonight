package universconception.conception.cegepstefoy.restaurantconcept.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


public class Mets {

    private int metsId;
    private String nomMet;
    private int profile_pic_id;
    private int Quantity;
    private Float price;


    private int numeroDeCommande;

    public Mets(int metsId, String nomMet, int quantity, Float price, int profile_pic_id) {
        this.metsId = metsId;
        this.nomMet = nomMet;
        Quantity = quantity;
        this.price = price;
        this.profile_pic_id = profile_pic_id;
    }

    public int getMetsId() {
        return metsId;
    }

    public void setMetsId(int metsId) {
        this.metsId = metsId;
    }

    public String getNomMet() {
        return nomMet;
    }

    public void setNomMet(String nomMet) {
        this.nomMet = nomMet;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getProfile_pic_id() {
        return profile_pic_id;
    }

    public void setProfile_pic_id(int pProfile_pic_id) {
        profile_pic_id = pProfile_pic_id;
    }
}
