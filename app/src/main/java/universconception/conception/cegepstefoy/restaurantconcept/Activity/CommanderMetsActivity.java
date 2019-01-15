package universconception.conception.cegepstefoy.restaurantconcept.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import universconception.conception.cegepstefoy.restaurantconcept.R;

public class CommanderMetsActivity extends AppCompatActivity {

    private String member_name;
    private int imageNumber;
    private ImageView mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commander_mets);

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


}
