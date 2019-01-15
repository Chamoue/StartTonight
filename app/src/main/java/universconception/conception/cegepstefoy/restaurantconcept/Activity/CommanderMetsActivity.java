package universconception.conception.cegepstefoy.restaurantconcept.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import universconception.conception.cegepstefoy.restaurantconcept.Data.DataBase;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Mets;
import universconception.conception.cegepstefoy.restaurantconcept.R;

public class CommanderMetsActivity extends AppCompatActivity {

    private String member_name;
    private int imageNumber;
    private ImageView mView;
    private Button addToOrderButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commander_mets);
        this.addToOrderButton = findViewById(R.id.ajouter);

        if (DataBase.getInstance().isAdminModeEnabled()) {
            this.addToOrderButton.setText("Retirer cet item du menu");
            this.addToOrderButton.setBackgroundColor(Color.parseColor("#ff0000"));
        }

        Spinner spinner = findViewById(R.id.drop_down_option);
        mView = findViewById(R.id.view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.les_option_quantite, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Intent intent = getIntent();
        member_name = intent.getStringExtra("member_name");
        imageNumber = intent.getIntExtra("imageNumber", 1);

        mView.setImageResource(imageNumber);

    }

    public void removeItemFromMenu() {
        DataBase.getInstance().removeFromMenu(member_name);
    }


    public void onAddToOrderButtonClicked(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        if (DataBase.getInstance().isAdminModeEnabled()) {
            DataBase.getInstance().removeFromMenu(member_name);
            startActivity(intent);
        }
        else {
            DataBase.getInstance().addToOrder(new Mets(1, member_name,1,1f,1));
            startActivity(intent);
        }
    }
}
