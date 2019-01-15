package universconception.conception.cegepstefoy.restaurantconcept.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import universconception.conception.cegepstefoy.restaurantconcept.Data.DataBase;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Commande;
import universconception.conception.cegepstefoy.restaurantconcept.R;

public class AccepterCommandeActivity extends AppCompatActivity {

    private List<Commande> orderList;
    private ListView orderListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepter_commande);

        this.orderList= DataBase.getInstance().getCurrentOrders();

        this.orderListView = findViewById(R.id.orderList);

        //TODO CUSTOM ADAPTER ?????
    }
}
