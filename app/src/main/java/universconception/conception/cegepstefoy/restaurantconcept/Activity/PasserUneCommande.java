package universconception.conception.cegepstefoy.restaurantconcept.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import universconception.conception.cegepstefoy.restaurantconcept.Data.DataBase;
import universconception.conception.cegepstefoy.restaurantconcept.Model.CustomAdapterFacture;
import universconception.conception.cegepstefoy.restaurantconcept.R;

public class PasserUneCommande extends AppCompatActivity {

    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passer_une_commande);

        this.myListView = findViewById(R.id.factureListView);
        CustomAdapterFacture adapter = new CustomAdapterFacture( DataBase.getInstance().getCommande().getMetsCommande(),this);
        this.myListView.setAdapter(adapter);
    }

    public void onFinalOrderButtonClicked(View view) {
        DataBase.getInstance().addToCurrentOrders(DataBase.getInstance().getCommande());
        DataBase.getInstance().clearCurrentUserOrders();
        backToMainActivity();
    }

    private void backToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCancelOrderButton(View view) {
        DataBase.getInstance().clearCurrentUserOrders();
        backToMainActivity();
    }
}
