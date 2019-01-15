package universconception.conception.cegepstefoy.restaurantconcept.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import universconception.conception.cegepstefoy.restaurantconcept.Data.DataBase;
import universconception.conception.cegepstefoy.restaurantconcept.Model.CustomOrderForMealList;
import universconception.conception.cegepstefoy.restaurantconcept.R;

public class AcceptOrRefuseOrderActivity extends AppCompatActivity {

    private Button acceptOrderButton;
    private Button cancelOrderButton;
    private ListView mealsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_or_refuse_order);

        this.acceptOrderButton = findViewById(R.id.AcceptOrder);
        this.cancelOrderButton = findViewById(R.id.CancelOrder);
        this.mealsListView = findViewById(R.id.mealListView);

        Intent intent = getIntent();
        CustomOrderForMealList adapter = new CustomOrderForMealList(this,DataBase.getInstance().getMealFromCurrentOrderOf(intent.getStringExtra("courriel")));
        this.mealsListView.setAdapter(adapter);
    }


    public void onAcceptOrderButtonClicked(View view) {
        //Will be moved to Accept List once prototype phase is done
        Intent intent = getIntent();
        DataBase.getInstance().removeFromAcceptedOrdersList(intent.getStringExtra("courriel"));
        launchAcceptCommande();
    }

    private void launchAcceptCommande() {
        Intent switchActivity = new Intent(this, AccepterCommandeActivity.class);
        startActivity(switchActivity);
    }

    public void onRefuseOrderButtonClicked(View view) {
        Intent intent = getIntent();
        DataBase.getInstance().removeFromAcceptedOrdersList(intent.getStringExtra("courriel"));
        launchAcceptCommande();
    }
}
