package universconception.conception.cegepstefoy.restaurantconcept.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import universconception.conception.cegepstefoy.restaurantconcept.Data.DataBase;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Commande;
import universconception.conception.cegepstefoy.restaurantconcept.Model.CustomAdapterForOrderList;
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

        CustomAdapterForOrderList adapter = new CustomAdapterForOrderList (this, DataBase.getInstance().getCurrentOrders());
        orderListView.setAdapter(adapter);

        this.orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AccepterCommandeActivity.this, AcceptOrRefuseOrderActivity.class);
                intent.putExtra("courriel", orderList.get(position).getClient().getCourriel().getCourriel());
                startActivity(intent);
            }
        });
    }
}
