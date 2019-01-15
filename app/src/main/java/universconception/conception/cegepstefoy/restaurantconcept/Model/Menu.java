package universconception.conception.cegepstefoy.restaurantconcept.Model;
import java.util.ArrayList;
import java.util.List;

public class Menu {


    private List<Mets> menu;

    public Menu() {
        this.menu = new ArrayList<>();
    }

    public List<Mets> getMenu() {
        return menu;
    }

    public void setMenu(List<Mets> menu) {
        this.menu = menu;
    }

    public void addToMenu(Mets mets) {
        this.menu.add(mets);
    }

    public void removeFromMenu(Mets mets){
        this.menu.remove(mets);
    }
}
